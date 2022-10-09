package com.travelintellij.quotation.service.impl;

import com.lowagie.text.DocumentException;
import com.travelintellij.quotation.dto.ConfigurationQuotationVO;
import com.travelintellij.quotation.dto.TI_B2bPartnersDTO;
import com.travelintellij.quotation.dto.TgQuotationRecorderVO;
import com.travelintellij.quotation.entity.Tg_Quotation_Recorder_Entity;
import com.travelintellij.quotation.entity.Udn_Configuration_Manual_Quotation_Entity;
import com.travelintellij.quotation.repository.TI_Quotations_Repository;
import com.travelintellij.quotation.repository.Udn_Configuration_Manual_Quotation_Repository;

import com.travelintellij.quotation.util.TIConstants;
import com.travelintellij.request.dto.ClientRecorderDTO;
import com.travelintellij.request.dto.TI_AirlineDTO;
import com.travelintellij.request.dto.TI_AirportDTO;
import com.travelintellij.request.dto.TI_CityRecorderDTO;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuotationGenerateServiceImpl  {
    private Logger logger = LoggerFactory.getLogger(QuotationGenerateServiceImpl.class);

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pdf.directory}")
    private String pdfDirectory;

    @Autowired
    private Udn_Configuration_Manual_Quotation_Repository manualConfQuotRepository;

    @Autowired
    TI_Quotations_Repository quotationRepository;


    public void generatePdfFile(String templateName, Map<String, Object> data, String pdfFileName) {
        Context context = new Context();
        context.setVariables(data);

        System.out.println("Processing template engine for template name : " + templateName);
        String htmlContent = templateEngine.process(templateName, context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pdfDirectory + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (DocumentException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public Udn_Configuration_Manual_Quotation_Entity find_Manual_Configuration_Quotation_By_Id(long manualConfigQtnId){
        return manualConfQuotRepository.findById(manualConfigQtnId).get();
    }



    public void generationQuotation(long manualConfigQtnId,long manualConfigurationQuotationId){
        Udn_Configuration_Manual_Quotation_Entity manualConfigurationEntity;
        Tg_Quotation_Recorder_Entity quotuationEntity ;
        if(manualConfigurationQuotationId==0){
            ConfigurationQuotationVO configurationQuotationVO = new ConfigurationQuotationVO();
            manualConfigurationEntity = new Udn_Configuration_Manual_Quotation_Entity(configurationQuotationVO);
            quotuationEntity = findQuotationRecordById(manualConfigQtnId);
            manualConfigurationEntity.setQuotationEntity(quotuationEntity);
        }else {
            manualConfigurationEntity = find_Manual_Configuration_Quotation_By_Id(manualConfigurationQuotationId);
        }
        Map<String, String> params = new HashMap<String, String>();
        Map<String, Object> quotationInputDataMap = new HashMap<>();
        params.put("b2bPartnerId", String.valueOf(manualConfigurationEntity.getPartnerId()));
        params.put("clientId", String.valueOf(manualConfigurationEntity.getQuotationEntity().getLeadEntity().getContactId()));

        int srcCityId= manualConfigurationEntity.getQuotationEntity().getLeadEntity().getSource();
        int dstCityId= manualConfigurationEntity.getQuotationEntity().getLeadEntity().getDestination();

        Tg_Quotation_Recorder_Entity quotationEntity= manualConfigurationEntity.getQuotationEntity();
        TgQuotationRecorderVO quotationRecorderVO = new TgQuotationRecorderVO();
        quotationRecorderVO.setVoFromEntity(quotationEntity);
        quotationRecorderVO.getManualQuotationsVoList().forEach((e) -> {
            TI_AirlineDTO airlineDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirlineById?airlineId={airlineId}", TI_AirlineDTO.class, e.getAirlineId());
            TI_AirportDTO originAirportDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirportById?airportId={airportId}", TI_AirportDTO.class, e.getAirportCodeOrigin());
            TI_AirportDTO destAirportDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirportById?airportId={airportId}", TI_AirportDTO.class, e.getAirportCodeDestination());
            e.setAirlineName(airlineDTO.getAirlineShortName());
            e.setCabinClassName(TIConstants.CABIN_CLASS.get(e.getCabinClass()));
            e.setOriginCity(originAirportDTO.getCityName());
            e.setDestinationCity(destAirportDTO.getCityName());
            if(manualConfigurationEntity.isFlightShowConnections()){
                e.getFlightStopsQuotationsVoList().forEach(flightStopDetailQuotationVO -> {
                    TI_AirlineDTO fsAirlineDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirlineById?airlineId={airlineId}", TI_AirlineDTO.class, flightStopDetailQuotationVO.getAirlineId());
                    TI_AirportDTO fsOriginAirportDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirportById?airportId={airportId}", TI_AirportDTO.class, flightStopDetailQuotationVO.getAirportCodeOrigin());
                    TI_AirportDTO fsDestAirportDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getAirportById?airportId={airportId}", TI_AirportDTO.class, flightStopDetailQuotationVO.getAirportCodeDestination());

                    flightStopDetailQuotationVO.setAirlineName(fsAirlineDTO.getAirlineShortName());
                    flightStopDetailQuotationVO.setOriginCity(fsOriginAirportDTO.getCityName());
                    flightStopDetailQuotationVO.setDestinationCity(fsDestAirportDTO.getCityName());

                    flightStopDetailQuotationVO.setCabinClassName(TIConstants.CABIN_CLASS.get(flightStopDetailQuotationVO.getCabinClass()));
                });
            }
        });

        TI_B2bPartnersDTO b2bPartnersDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getB2bPartnerById?b2bPartnerId={b2bPartnerId}", TI_B2bPartnersDTO.class, params);
        ClientRecorderDTO clientDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getClientById?clientId={clientId}", ClientRecorderDTO.class, params);
        TI_CityRecorderDTO srcCityDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getCityById?cityId={cityId}", TI_CityRecorderDTO.class, srcCityId);
        TI_CityRecorderDTO dstCityDTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getCityById?cityId={cityId}", TI_CityRecorderDTO.class, dstCityId);


        quotationInputDataMap.put("manualConfigurationEntity",manualConfigurationEntity);
        quotationInputDataMap.put("b2bPartnersDTO",b2bPartnersDTO);
        //quotationInputDataMap.put("quotationRecorderDTO",manualConfigurationEntity.getQuotationEntity());
        quotationInputDataMap.put("leadRecorderDTO",manualConfigurationEntity.getQuotationEntity().getLeadEntity());
        quotationInputDataMap.put("quotationRecorderDTO",quotationRecorderVO);
        quotationInputDataMap.put("clientName",clientDTO.getClientName());
        quotationInputDataMap.put("cityFromName",srcCityDTO.getCityName());
        quotationInputDataMap.put("destinationName",dstCityDTO.getCityName());
        //quotationInputDataMap.put("leadRecorderDTO",manualConfigurationEntity.getQuotationEntity().getLeadEntity());
        generatePdfFile("TravelQuotation", quotationInputDataMap, "travel-quotation.pdf");

        //TI_LeadsRecorderDTO leadsRecorderDTODTO = restTemplate.getForObject("http://localhost:8080/udanchoo/getLeadRecordById?leadId={leadId}", TI_LeadsRecorderDTO.class, params);


    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public Tg_Quotation_Recorder_Entity findQuotationRecordById(long quotationId) {
        return quotationRepository.findById(quotationId).get();

    }
}
