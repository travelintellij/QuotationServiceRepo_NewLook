package com.travelintellij.quotation.contoller;

import com.travelintellij.quotation.dto.EmailMessageVO;
import com.travelintellij.quotation.dto.ManualFlightQuotationVO;
import com.travelintellij.quotation.dto.QuotationEmailSendingRequestVO;
import com.travelintellij.quotation.entity.*;
import com.travelintellij.quotation.service.impl.EmailServiceImpl;
import com.travelintellij.quotation.service.impl.QuotationGenerateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@RestController
public class QuotationController {

    @Autowired
    QuotationGenerateServiceImpl quotationGenerateService;

    @Value("${pdf.directory}")
    private String quotationRootDirectory;

    @Autowired
    EmailServiceImpl emailService;

    @RequestMapping("generatePdf")
    public String generatePdf(){
        System.out.println("Generate Pdf is invoked");
        Map<String, Object> data = new HashMap<>();
        Customer customer = new Customer();
        customer.setCompanyName("Simple Solution");
        customer.setContactName("John Doe");
        customer.setAddress("123, Simple Street");
        customer.setEmail("john@simplesolution.dev");
        customer.setPhone("123 456 789");
        data.put("customer", customer);

        List<QuoteItem> quoteItems = new ArrayList<>();
        QuoteItem quoteItem1 = new QuoteItem();
        quoteItem1.setDescription("Test Quote Item 1");
        quoteItem1.setQuantity(1);
        quoteItem1.setUnitPrice(100.0);
        quoteItem1.setTotal(100.0);
        quoteItems.add(quoteItem1);

        QuoteItem quoteItem2 = new QuoteItem();
        quoteItem2.setDescription("Test Quote Item 2");
        quoteItem2.setQuantity(4);
        quoteItem2.setUnitPrice(500.0);
        quoteItem2.setTotal(2000.0);
        quoteItems.add(quoteItem2);

        QuoteItem quoteItem3 = new QuoteItem();
        quoteItem3.setDescription("Test Quote Item 3");
        quoteItem3.setQuantity(2);
        quoteItem3.setUnitPrice(200.0);
        quoteItem3.setTotal(400.0);
        quoteItems.add(quoteItem3);

        data.put("quoteItems", quoteItems);

        //quotationGenerateService.generatePdfFile("quotation", data, "quotation.pdf");

        return "Munna Pdf Successfully Created !! ";
    }

    @RequestMapping("generateQuotation")
    public String generateQuotation(@RequestParam long quotationId,@RequestParam long manualConfigurationQuotationId){
        boolean isSuccess = quotationGenerateService.generationQuotation(quotationId, manualConfigurationQuotationId);
        //Udn_Configuration_Manual_Quotation_Entity manualConfigQtnEntity = quotationGenerateService.find_Manual_Configuration_Quotation_By_Id(quotationId);
        if(isSuccess)
            return Boolean.TRUE.toString();
        else
            return Boolean.FALSE.toString();

    }

    @RequestMapping("checkQuotationExists")
    @ResponseBody
    public String checkQuotationExists(@RequestParam("leadId") int leadId,@RequestParam("quotationId")int quotationId,@RequestParam("version") int version) {
        String quotationFileName = "Q-"+ leadId + "-" + quotationId + "-" +  version + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + leadId + File.separator + "Q" + quotationId + File.separator +  "V" + version;
        File quotationFile = new File(quotationFilePath + File.separator + quotationFileName);
        if(quotationFile.exists())
            return Boolean.TRUE.toString();
        else
            return Boolean.FALSE.toString();
    }

    @RequestMapping("deleteQuotation")
    @ResponseBody
    public String deleteQuotation(@RequestParam("leadId") int leadId,@RequestParam("quotationId")int quotationId,@RequestParam("version") int version) {
        String quotationFileName = "Q-"+ leadId + "-" + quotationId + "-" +  version + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + leadId + File.separator + "Q" + quotationId + File.separator +  "V" + version;
        File quotationFile = new File(quotationFilePath + File.separator + quotationFileName);
        quotationFile.delete();
        if(quotationFile.exists())
            return Boolean.FALSE.toString();
        else
            return Boolean.TRUE.toString();
    }


    @RequestMapping(path = "/downloadQuotation", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadQuotation(@RequestParam("leadId") int leadId, @RequestParam("quotationId")int quotationId, @RequestParam("version") int version) throws IOException, MalformedURLException {
        String quotationFileName = "Q-"+ leadId + "-" + quotationId + "-" +  version + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + leadId + File.separator + "Q" + quotationId + File.separator +  "V" + version;
        String quotationFullFilePath = quotationFilePath + File.separator + quotationFileName;

        String  contentType = "application/octet-stream";
        Path path = Paths.get(quotationFullFilePath);
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @RequestMapping(path = "/viewQuotation", method = RequestMethod.GET)
    public ResponseEntity<Resource> viewQuotation(@RequestParam("leadId") int leadId, @RequestParam("quotationId")int quotationId, @RequestParam("version") int version) throws IOException, MalformedURLException {
        String quotationFileName = "Q-"+ leadId + "-" + quotationId + "-" +  version + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + leadId + File.separator + "Q" + quotationId + File.separator +  "V" + version;
        String quotationFullFilePath = quotationFilePath + File.separator + quotationFileName;

        String  contentType = "application/pdf";
        Path path = Paths.get(quotationFullFilePath);
        Resource resource = new UrlResource(path.toUri());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @RequestMapping(path = "/sendEmailQuotation", method = RequestMethod.POST)
    public String sendEmailQuotation( @RequestBody QuotationEmailSendingRequestVO emailQuotationMessageVO)  {
        String quotationFileName = "Q-"+ emailQuotationMessageVO.getLeadId() + "-" + emailQuotationMessageVO.getQuotationId() + "-" +  emailQuotationMessageVO.getVersion() + ".pdf";
        String quotationFilePath = quotationRootDirectory + File.separator + "L" + emailQuotationMessageVO.getLeadId() + File.separator + "Q" + emailQuotationMessageVO.getQuotationId() + File.separator +  "V" + emailQuotationMessageVO.getVersion();
        String quotationFullFilePath = quotationFilePath + File.separator + quotationFileName;
        ArrayList fileList = new ArrayList();
        fileList.add(quotationFullFilePath);
        try {
            System.out.println("Sending Quotation Email" + emailQuotationMessageVO.getQuotationId() );
            emailService.sendMailWithAttachment(emailQuotationMessageVO.getEmailMessageVO(), fileList);
            System.out.println("Quotation Email Sent..");
        }
        catch (Exception e) {
            return Boolean.FALSE.toString();
        }
        return Boolean.TRUE.toString();
    }

    @ResponseBody
    @RequestMapping(path = "/getFlightDetailsByQuotationId", method = RequestMethod.GET)
    public ManualFlightQuotationVO[] getFlightDetailsByQuotationId(long quotationId) {
       Tg_Quotation_Recorder_Entity quotationEntity = quotationGenerateService.findQuotationRecordById(quotationId);
        ManualFlightQuotationVO[] manualFlightQuotationVOArray = new ManualFlightQuotationVO[quotationEntity.getManualQuotationsList().size()];
        int i=0;
        for(Udn_Manual_Flight_Quotation_Entity flightEntity:quotationEntity.getManualQuotationsList()){
            manualFlightQuotationVOArray[i] = new ManualFlightQuotationVO();
            manualFlightQuotationVOArray[i].updateManualFlightVoFromEntity(flightEntity);
            i++;
       }
       return manualFlightQuotationVOArray;
    }


}
