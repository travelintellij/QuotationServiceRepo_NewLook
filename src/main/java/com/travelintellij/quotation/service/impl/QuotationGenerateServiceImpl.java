package com.travelintellij.quotation.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.lowagie.text.DocumentException;
import com.travelintellij.quotation.dto.*;
import com.travelintellij.quotation.entity.*;
import com.travelintellij.quotation.repository.TI_Quotations_Repository;
import com.travelintellij.quotation.repository.Udn_Configuration_Manual_Quotation_Repository;

import com.travelintellij.quotation.util.TIConstants;
import com.travelintellij.request.dto.ClientRecorderDTO;
import com.travelintellij.request.dto.TI_AirlineDTO;
import com.travelintellij.request.dto.TI_AirportDTO;
import com.travelintellij.request.dto.TI_CityRecorderDTO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuotationGenerateServiceImpl  {
    private Logger logger = LoggerFactory.getLogger(QuotationGenerateServiceImpl.class);

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pdf.directory}")
    private String quotationRootDirectory;

    @Autowired
    private Udn_Configuration_Manual_Quotation_Repository manualConfQuotRepository;

    @Autowired
    TI_Quotations_Repository quotationRepository;

    @Autowired
    private com.travelintellij.quotation.repository.ItineraryMasterRepository itineraryMasterRepository;

    @Value("${B2B_PARTNER_SERVICE}")
    private String B2B_PARTNER_SERVICE;

    @Value("${HOTEL_OPTION_WISE_SERVICE}")
    private String HOTEL_OPTION_WISE_SERVICE;

    @Value("${CITY_BY_ID_SERVICE}")
    private String CITY_BY_ID_SERVICE;

    @Value("${COUNTRY_BY_CODE_SERVICE}")
    private String COUNTRY_BY_CODE_SERVICE;

    @Value("${AIRLINE_BY_ID_SERVICE}")
    private String AIRLINE_BY_ID_SERVICE;

    @Value("${AIRPORT_BY_ID_SERVICE}")
    private String AIRPORT_BY_ID_SERVICE;

    @Value("${CLIENT_BY_ID_SERVICE}")
    private String CLIENT_BY_ID_SERVICE;

    @Value("${LOGO_FILE_PATH}")
    private String LOGO_FILE_PATH;



    public boolean generatePdfFile(String templateName, Map<String, Object> data,String quotationFilePath, String pdfFileName,String waterMarkBrandName) {
        Context context = new Context();
        context.setVariables(data);
        String htmlContent = templateEngine.process(templateName, context);
        // Sanitize ampersands for XML/XHTML compliance in ITextRenderer
        if (htmlContent != null) {
            htmlContent = htmlContent.replaceAll("&(?![a-zA-Z0-9#]+;)", "&amp;");
        }
        try {

            System.out.println("Quotation File PAth is " + quotationFilePath);
            System.out.println("Quotation File Nameh is " + pdfFileName);

            Path path = Paths.get(quotationFilePath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            File existingFile = new File(quotationFilePath + File.separator + pdfFileName);
            if (existingFile.exists()) {
                existingFile.delete();
                System.out.println("DEBUG: Existing PDF deleted to ensure fresh generation.");
            }
            FileOutputStream fileOutputStream = new FileOutputStream(quotationFilePath + File.separator + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
            addWatermark(new File(quotationFilePath + File.separator + pdfFileName),waterMarkBrandName);
            fileOutputStream.close();
            return true;

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
            return false;
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
            return false;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return false;
        } catch (com.itextpdf.text.DocumentException e) {
            throw new RuntimeException(e);
        }
    }

    private void addWatermark(File file,String waterMarkBrandName) throws IOException, com.itextpdf.text.DocumentException {
        try (PDDocument doc = PDDocument.load(file)) {
            // Loop through each page to add text water mark on each page
            for (final PDPage page : doc.getPages()) {
                final PDFont font = PDType1Font.TIMES_ITALIC;
                addWatermarkText(doc, page, font, waterMarkBrandName);
            }
            doc.save(file);
        }
    }

    private static void addWatermarkText(final PDDocument doc, final PDPage page, final PDFont font, final String text)
            throws IOException {
        try (PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true,
                true)) {
            final float fontHeight = 70; // arbitrary for short text
            final float width = page.getMediaBox().getWidth();
            final float height = page.getMediaBox().getHeight();
            final float stringWidth = font.getStringWidth(text) / 1000 * fontHeight;
            final float diagonalLength = (float) Math.sqrt(width * width + height * height);
            final float angle = (float) Math.atan2(height, width);
            final float x = (diagonalLength - stringWidth) / 2; // "horizontal" position in rotated world
            final float y = -fontHeight / 4; // 4 is a trial-and-error thing, this lowers the text a bit
            cs.transform(Matrix.getRotateInstance(angle, 0, 0));
            cs.setFont(font, fontHeight);
            // cs.setRenderingMode(RenderingMode.STROKE) // for "hollow" effect

            final PDExtendedGraphicsState gs = new PDExtendedGraphicsState();
            gs.setNonStrokingAlphaConstant(0.2f);
            gs.setStrokingAlphaConstant(0.2f);
            gs.setBlendMode(BlendMode.MULTIPLY);
            gs.setLineWidth(2f);
            cs.setGraphicsStateParameters(gs);

            // Set color
            cs.setNonStrokingColor(Color.LIGHT_GRAY);
            cs.setStrokingColor(Color.LIGHT_GRAY);

            cs.beginText();
            cs.newLineAtOffset(x, y);
            cs.showText(text);
            cs.endText();
        }
    }

    public Udn_Configuration_Manual_Quotation_Entity find_Manual_Configuration_Quotation_By_Id(long manualConfigQtnId){
        return manualConfQuotRepository.findById(manualConfigQtnId).get();
    }

    public boolean generationQuotation(long manualConfigQtnId,long manualConfigurationQuotationId){
        Map<String, Object> quotationInputDataMap = new HashMap<>();
        Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity;
        Tg_Quotation_Recorder_Entity quotationEntity = findQuotationRecordById(manualConfigQtnId);
        if(manualConfigurationQuotationId==0){
            ConfigurationQuotationVO configurationQuotationVO = new ConfigurationQuotationVO();
            manualConfigurationEntity = new Udn_Configuration_Manual_Quotation_Entity(configurationQuotationVO);
            manualConfigurationEntity.setQuotationEntity(quotationEntity);
        }else {
            manualConfigurationEntity = find_Manual_Configuration_Quotation_By_Id(manualConfigurationQuotationId);
        }
        TI_QuotationCostDetails costingDetails = new TI_QuotationCostDetails();
        TI_B2bPartnersDTO b2bPartnersDTO = restTemplate.getForObject(B2B_PARTNER_SERVICE, TI_B2bPartnersDTO.class, String.valueOf(manualConfigurationEntity.getPartnerId()));
        quotationInputDataMap.put("b2bPartnersDTO",b2bPartnersDTO);
        String logoFileName=b2bPartnersDTO.getPartnerShortName()+".jpg";
        File logoFile=new File(LOGO_FILE_PATH+"/"+logoFileName);
        if(!logoFile.exists()) {
            logoFileName=b2bPartnersDTO.getPartnerShortName()+".png";
            logoFile=new File(LOGO_FILE_PATH+"/"+logoFileName);
        }
        String logFileAbsPath = "";
        try {
            if(logoFile.exists()) {
                byte[] logoBytes = java.nio.file.Files.readAllBytes(logoFile.toPath());
                String base64Logo = java.util.Base64.getEncoder().encodeToString(logoBytes);
                String mimeType = logoFileName.toLowerCase().endsWith(".png") ? "image/png" : "image/jpeg";
                logFileAbsPath = "data:" + mimeType + ";base64," + base64Logo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        quotationInputDataMap.put("LOGO_FILE_ABS_PATH",logFileAbsPath);
        quotationInputDataMap.put("LOGO_FILE_NAME",logoFileName);

        try {
            org.springframework.core.io.ClassPathResource imgFile = new org.springframework.core.io.ClassPathResource("images/quotation_print_bg.png");
            byte[] bytes = org.springframework.util.StreamUtils.copyToByteArray(imgFile.getInputStream());
            String base64Image = java.util.Base64.getEncoder().encodeToString(bytes);
            quotationInputDataMap.put("bgImageBase64", "data:image/png;base64," + base64Image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("Logo File Path is " + LOGO_BASE_PATH+b2bPartnersDTO.getPartnerShortName()+".jpg");
        prepareFlightQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareHotelQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareTransfersQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareCruiseQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareSightSeeingQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareTourPackagesQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareVisaQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareInsuranceQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        prepareOthersQuotationDetails(manualConfigurationEntity,quotationInputDataMap,costingDetails);
        System.out.println("DEBUG: Quotation ID: " + quotationEntity.getQuotationId() + " has Itinerary ID: " + quotationEntity.getItineraryId());
        quotationInputDataMap.put("quotationEntityStr", quotationEntity.toString());
        prepareItineraryQuotationDetails(quotationEntity, quotationInputDataMap);
        //prepareCostingForQuotationDetails(manualConfigurationEntity,quotationInputDataMap);
        quotationInputDataMap.put("COSTING_OBJ", costingDetails);
        String quotationFileName = "Q-"+ quotationEntity.getLeadEntity().getLeadId() + "-" + quotationEntity.getQuotationId() + "-" +  quotationEntity.getVersion() + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + quotationEntity.getLeadEntity().getLeadId() + File.separator + "Q" + quotationEntity.getQuotationId() + File.separator +  "V" + quotationEntity.getVersion();

        boolean isSuccess = generatePdfFile("TravelQuotation", quotationInputDataMap, quotationFilePath, quotationFileName,b2bPartnersDTO.getPartnerBrandName());
        //TI_LeadsRecorderDTO leadsRecorderDTODTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getLeadRecordById?leadId={leadId}", TI_LeadsRecorderDTO.class, params);
        return isSuccess;
    }

    private void prepareHotelQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        Map hotelPriceOptionWise = new HashMap();
        Map hotelMarkupOptionWise = new HashMap();
        if(quotationRecorderVO.isHotel()){
            //Map<Integer,List<ManualHotelQuotationVO>> mapHotelOptionsList = restTemplate.getForObject("http://localhost:8080/udanchoo/getOptionWiseHotelMap?quotationId={quotationId}", Map.class, quotationEntity.getQuotationId());
            Map mapTempHotelOptionsList = restTemplate.getForObject(HOTEL_OPTION_WISE_SERVICE, Map.class, quotationEntity.getQuotationId());
            quotationInputDataMap.put("mapHotelOptionsList",mapTempHotelOptionsList);
            for (Object strkey : mapTempHotelOptionsList.keySet()) {
                List linkedHashMap = (List) mapTempHotelOptionsList.get(strkey);
                int hotelTotalCostAndMarkup=0;int hotelMarkup=0;
                for(int i=0;i<linkedHashMap.size();i++) {
                    Integer stayCost = (Integer) ((LinkedHashMap) linkedHashMap.get(i)).get("hotelStayCost");
                    Integer stayMarkup = (Integer) ((LinkedHashMap) linkedHashMap.get(i)).get("hotelStayMarkup");
                    hotelTotalCostAndMarkup = hotelTotalCostAndMarkup + stayCost.intValue() + stayMarkup.intValue();
                    hotelMarkup = hotelMarkup + stayMarkup;
                    //System.out.println("Cost is " + ((LinkedHashMap) linkedHashMap.get(i)).get("hotelStayCost"));
                    //System.out.println("Markup is " + ((LinkedHashMap) linkedHashMap.get(i)).get("hotelStayMarkup"));
                }
                hotelPriceOptionWise.put((Integer.parseInt(strkey.toString())),hotelTotalCostAndMarkup);
                hotelMarkupOptionWise.put((Integer.parseInt(strkey.toString())),hotelMarkup);
            }
        }
        if(hotelPriceOptionWise.size()==0) {
            hotelPriceOptionWise.put(0, 0);
        }
        if(hotelMarkupOptionWise.size()==0) {
            hotelMarkupOptionWise.put(0, 0);
        }
        costingDetails.setHotelOptionsWithCostAndMarkup(hotelPriceOptionWise);
        costingDetails.setHotelOptionsWithMarkup(hotelMarkupOptionWise);
    }


    private void prepareOthersQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isOthers()) {
            int totalOthersCost=0,totalOthersMarkup=0;
            for (ManualOtherQuotationVO othersVO : quotationRecorderVO.getOtherVoList()) {
                totalOthersCost = totalOthersCost + othersVO.getServiceCost();
                totalOthersMarkup = totalOthersMarkup + othersVO.getServiceMarkup();
            }
            costingDetails.setOtherTotalCost(totalOthersCost);
            costingDetails.setOtherTotalMarkup(totalOthersMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalOthersCost+totalOthersMarkup);
            quotationInputDataMap.put("OthersVOList", quotationRecorderVO.getOtherVoList());
        }
    }

    private void prepareInsuranceQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isInsurance()) {
            int totalInsuranceCost=0,totalInsuranceMarkup=0;
            for (ManualInsuranceQuotationVO insuranceVO : quotationRecorderVO.getInsuranceVoList()) {
                TI_CityRecorderDTO insuranceDestDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, insuranceVO.getCountryId());
                insuranceVO.setInsuranceProviderName(TIConstants.INSURANCE_PROVIDERS_MAP.get(insuranceVO.getInsuranceProvider()));
                insuranceVO.setCountryName(insuranceDestDTO.getCountryName());
                totalInsuranceCost = totalInsuranceCost + insuranceVO.getPremiumCost();
                totalInsuranceMarkup = totalInsuranceMarkup + insuranceVO.getPremiumMarkup();
            }
            costingDetails.setInsuranceTotalCost(totalInsuranceCost);
            costingDetails.setInsuranceTotalMarkup(totalInsuranceMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalInsuranceCost+totalInsuranceMarkup);
            quotationInputDataMap.put("InsuranceVOList",quotationRecorderVO.getInsuranceVoList());
        }
    }

    private void prepareVisaQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isVisa()) {
            int totalVisaCost=0,totalVisaMarkup=0;
            for (ManualVisaQuotationVO visaQuotationVO : quotationRecorderVO.getVisaVoList()) {
                Udn_Visa_Master_Entity visaEntity = visaQuotationVO.getVisaQuotationEntity();
                TI_CityRecorderDTO visaDestDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, visaEntity.getConsulateCity());
                visaQuotationVO.setVisaConsulate(visaDestDTO.getCityName());
                visaDestDTO = restTemplate.getForObject(COUNTRY_BY_CODE_SERVICE, TI_CityRecorderDTO.class, visaEntity.getCountryCode());
                visaQuotationVO.setVisaCountry(visaDestDTO.getCountryName());
                totalVisaCost = totalVisaCost + visaQuotationVO.getVisaCost();
                totalVisaMarkup = totalVisaMarkup + visaQuotationVO.getVisaMarkup();
            }
            costingDetails.setVisaTotalCost(totalVisaCost);
            costingDetails.setVisaTotalMarkup(totalVisaMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalVisaCost+totalVisaMarkup);
            quotationInputDataMap.put("VisaVOList",quotationRecorderVO.getVisaVoList());
        }

    }

    private void prepareTourPackagesQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isTourPackage()) {
            int totalTourPackageCost=0,totalTourPackageMarkup=0;
            for (ManualPackageQuotationVO tourPackageQuotationVO : quotationRecorderVO.getTourPackageVoList()) {
                TI_CityRecorderDTO cityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, tourPackageQuotationVO.getCityId());
                tourPackageQuotationVO.setCityName(cityDTO.getCityName());
                totalTourPackageCost = totalTourPackageCost + tourPackageQuotationVO.getPkgCost() ;
                totalTourPackageMarkup = totalTourPackageMarkup + tourPackageQuotationVO.getPkgMarkup();
            }
            costingDetails.setTourPackageTotalCost(totalTourPackageCost);
            costingDetails.setTourPackageTotalMarkup(totalTourPackageMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalTourPackageCost+totalTourPackageMarkup);
            quotationInputDataMap.put("TourPackagesVOList",quotationRecorderVO.getTourPackageVoList());
        }

    }

    private void prepareTransfersQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isTransfers()) {
            int totalTransfersCost=0,totalTransfersMarkup=0;
            for (ManualTransferQuotationVO transferQuotationVO : quotationRecorderVO.getTransferVoList()) {
                TI_CityRecorderDTO pickupCityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, transferQuotationVO.getPickUpCityId());
                TI_CityRecorderDTO dropCityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, transferQuotationVO.getDropToCityId());
                transferQuotationVO.setPickUpCityName(pickupCityDTO.getCityName());
                transferQuotationVO.setDropToCityName(dropCityDTO.getCityName());
                transferQuotationVO.setPickUpFromDesc(TIConstants.TRANSFER_POINT_MAP.get(transferQuotationVO.getPickUpFrom()));
                transferQuotationVO.setDropToDesc(TIConstants.TRANSFER_POINT_MAP.get(transferQuotationVO.getDropTo()));
                transferQuotationVO.setTransferTypeName(TIConstants.TRANSFER_TYPE_MODE.get(transferQuotationVO.getTransferType()));
                totalTransfersCost = totalTransfersCost + transferQuotationVO.getTransferCost();
                totalTransfersMarkup = totalTransfersMarkup + transferQuotationVO.getTransferMarkup();

            }
            costingDetails.setTransfersTotalCost(totalTransfersCost);
            costingDetails.setTransfersTotalMarkup(totalTransfersMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalTransfersCost+totalTransfersMarkup);
            quotationInputDataMap.put("TransfersVOList",quotationRecorderVO.getTransferVoList());
        }
    }

    private void prepareCruiseQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isCruise()) {
            int totalCruiseCost=0,totalCruiseMarkup=0;
            for (ManualCruiseQuotationVO cruiseVO : quotationRecorderVO.getCruiseVoList()) {
                TI_CityRecorderDTO cityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, cruiseVO.getCityId());
                cruiseVO.setCityName(cityDTO.getCityName());
                cruiseVO.setStateRoomName(TIConstants.CRUISE_STATE_ROOM_TYPE_MAP.get(cruiseVO.getStateRoomType()));
                cruiseVO.setCruiseProviderName(TIConstants.CRUISE_PROVIDER_NAMES_MAP.get(cruiseVO.getCruiseProvider()));
                totalCruiseCost = totalCruiseCost + cruiseVO.getCruiseStayCost();
                totalCruiseMarkup = totalCruiseMarkup + cruiseVO.getCruiseStayMarkup();
            }
            costingDetails.setCruiseTotalCost(totalCruiseCost);
            costingDetails.setCruiseTotalMarkup(totalCruiseMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalCruiseCost+totalCruiseMarkup);
            quotationInputDataMap.put("CruiseVOList",quotationRecorderVO.getCruiseVoList());
        }

    }

    private void prepareSightSeeingQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        Tg_Quotation_Recorder_Entity  quotationEntity = manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        if(quotationRecorderVO.isSightseeing()) {
            int totalSightSeeingCost=0,totalSightSeeingMarkup=0;
            for (ManualSightSeeingQuotationVO sightSeeingVO : quotationRecorderVO.getSightSeeingVoList()) {
                TI_CityRecorderDTO cityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, sightSeeingVO.getCityId());
                sightSeeingVO.setCityName(cityDTO.getCityName());
                sightSeeingVO.setTransferTypeName(TIConstants.TRANSFER_TYPE_MODE.get(sightSeeingVO.getTransferType()));
                totalSightSeeingCost = totalSightSeeingCost + sightSeeingVO.getSightSeeingCost();
                totalSightSeeingMarkup = totalSightSeeingMarkup + sightSeeingVO.getSightSeeingMarkup();
            }
            costingDetails.setSightSeeingTotalCost(totalSightSeeingCost);
            costingDetails.setSightSeeingTotalMarkup(totalSightSeeingMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalSightSeeingCost+totalSightSeeingMarkup);
            quotationInputDataMap.put("SightSeeingVOList",quotationRecorderVO.getSightSeeingVoList());
        }

    }

    private void prepareFlightQuotationDetails(Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity, Map<String, Object> quotationInputDataMap, TI_QuotationCostDetails costingDetails) {
        //Map<String, String> params = new HashMap<String, String>();
        //params.put("b2bPartnerId", String.valueOf(manualConfigurationEntity.getPartnerId()));
        //params.put("clientId", String.valueOf(manualConfigurationEntity.getQuotationEntity().getLeadEntity().getContactId()));
        int srcCityId= manualConfigurationEntity.getQuotationEntity().getLeadEntity().getSource();
        int dstCityId= manualConfigurationEntity.getQuotationEntity().getLeadEntity().getDestination();
        Tg_Quotation_Recorder_Entity quotationEntity= manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);

        if(quotationRecorderVO.isFlight()) {
            //quotationRecorderVO.getManualQuotationsVoList().forEach((e) -> {
            int totalFlightCost=0,totalFlightMarkup=0;
            for (ManualFlightQuotationVO flightQuotationVO : quotationRecorderVO.getManualQuotationsVoList()) {
                TI_AirlineDTO airlineDTO = restTemplate.getForObject(AIRLINE_BY_ID_SERVICE, TI_AirlineDTO.class, flightQuotationVO.getAirlineId());
                TI_AirportDTO originAirportDTO = restTemplate.getForObject(AIRPORT_BY_ID_SERVICE, TI_AirportDTO.class, flightQuotationVO.getAirportCodeOrigin());
                TI_AirportDTO destAirportDTO = restTemplate.getForObject(AIRPORT_BY_ID_SERVICE, TI_AirportDTO.class, flightQuotationVO.getAirportCodeDestination());
                flightQuotationVO.setAirlineName(airlineDTO.getAirlineShortName());
                flightQuotationVO.setCabinClassName(TIConstants.CABIN_CLASS.get(flightQuotationVO.getCabinClass()));
                flightQuotationVO.setOriginCity(originAirportDTO.getCityName());
                flightQuotationVO.setDestinationCity(destAirportDTO.getCityName());
                if (manualConfigurationEntity.isFlightShowConnections()) {
                    flightQuotationVO.getFlightStopsQuotationsVoList().forEach(flightStopDetailQuotationVO -> {
                        TI_AirlineDTO fsAirlineDTO = restTemplate.getForObject(AIRLINE_BY_ID_SERVICE, TI_AirlineDTO.class, flightStopDetailQuotationVO.getAirlineId());
                        TI_AirportDTO fsOriginAirportDTO = restTemplate.getForObject(AIRPORT_BY_ID_SERVICE, TI_AirportDTO.class, flightStopDetailQuotationVO.getAirportCodeOrigin());
                        TI_AirportDTO fsDestAirportDTO = restTemplate.getForObject(AIRPORT_BY_ID_SERVICE, TI_AirportDTO.class, flightStopDetailQuotationVO.getAirportCodeDestination());
                        flightStopDetailQuotationVO.setAirlineName(fsAirlineDTO.getAirlineShortName());
                        flightStopDetailQuotationVO.setOriginCity(fsOriginAirportDTO.getCityName());
                        flightStopDetailQuotationVO.setDestinationCity(fsDestAirportDTO.getCityName());
                        flightStopDetailQuotationVO.setCabinClassName(TIConstants.CABIN_CLASS.get(flightStopDetailQuotationVO.getCabinClass()));
                    });
                }
                totalFlightCost = totalFlightCost + flightQuotationVO.getFlightCost();
                totalFlightMarkup = totalFlightMarkup + flightQuotationVO.getFlightMarkup();
            }
            costingDetails.setFlightTotalCost(totalFlightCost);
            costingDetails.setFlightTotalMarkup(totalFlightMarkup);
            costingDetails.setGrandTotalWithoutHotel(costingDetails.getGrandTotalWithoutHotel()+totalFlightCost+totalFlightMarkup);

        }

        ClientRecorderDTO clientDTO = restTemplate.getForObject(CLIENT_BY_ID_SERVICE, ClientRecorderDTO.class, String.valueOf(manualConfigurationEntity.getQuotationEntity().getLeadEntity().getContactId()));
        TI_CityRecorderDTO srcCityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, srcCityId);
        TI_CityRecorderDTO dstCityDTO = restTemplate.getForObject(CITY_BY_ID_SERVICE, TI_CityRecorderDTO.class, dstCityId);

        quotationInputDataMap.put("manualConfigurationEntity",manualConfigurationEntity);
        quotationInputDataMap.put("leadRecorderDTO",manualConfigurationEntity.getQuotationEntity().getLeadEntity());
        quotationInputDataMap.put("quotationRecorderDTO",quotationRecorderVO);
        quotationInputDataMap.put("clientName",clientDTO.getClientName());
        quotationInputDataMap.put("cityFromName",srcCityDTO.getCityName());
        quotationInputDataMap.put("destinationName",dstCityDTO.getCityName());
    }

    private void prepareItineraryQuotationDetails(Tg_Quotation_Recorder_Entity quotationEntity, Map<String, Object> quotationInputDataMap) {
        Long itineraryId = quotationEntity.getItineraryId();
        System.out.println("DEBUG: Starting prepareItineraryQuotationDetails. Entity Itinerary ID: " + itineraryId);

        if (itineraryId == null || itineraryId == 0) {
            TgQuotationRecorderVO vo = (TgQuotationRecorderVO) quotationInputDataMap.get("quotationRecorderDTO");
            if (vo != null) {
                itineraryId = vo.getItineraryId();
                System.out.println("DEBUG: Fallback to VO Itinerary ID: " + itineraryId);
            }
        }

        if (itineraryId != null && itineraryId > 0) {
            System.out.println("DEBUG: Fetching Itinerary from Repository for ID: " + itineraryId);
            System.out.println("DEBUG: FETCHING ITINERARY FOR PDF. ID=" + itineraryId);
            Optional<ItineraryMasterEntity> itineraryOpt = itineraryMasterRepository.findById(itineraryId);
            if (itineraryOpt.isPresent()) {
                ItineraryMasterEntity itinerary = itineraryOpt.get();
                System.out.println("DEBUG: Successfully found Itinerary: " + itinerary.getTitle());
                if (itinerary.getDays() != null) {
                    System.out.println("DEBUG: Itinerary has " + itinerary.getDays().size() + " days.");
                }
                quotationInputDataMap.put("ITINERARY_OBJ", itinerary);
                quotationInputDataMap.put("ITINERARY_DAYS", new ArrayList<>(itinerary.getDays()));
                quotationInputDataMap.put("itineraryLinked", true);
            } else {
                System.out.println("DEBUG: Itinerary record NOT FOUND in database for ID: " + itineraryId);
            }
        } else {
            System.out.println("DEBUG: No valid Itinerary ID found for this quotation.");
        }
    }







    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public Tg_Quotation_Recorder_Entity findQuotationRecordById(long quotationId) {
        return quotationRepository.findById(quotationId).get();

    }


}
