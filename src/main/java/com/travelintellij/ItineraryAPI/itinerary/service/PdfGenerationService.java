package com.travelintellij.ItineraryAPI.itinerary.service;



import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryTemp;

import com.travelintellij.ItineraryAPI.itinerary.repository.ItineraryTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class PdfGenerationService {

    @Autowired
    private ItineraryTempRepository itineraryTempRepository;

    @Autowired
    private TemplateEngine templateEngine;

    public void generatePdf(ItineraryTemp itineraryTemp, HttpServletResponse response) throws IOException, DocumentException {
        Context context = new Context();
        context.setVariable("itinerary", itineraryTemp);

        String html = templateEngine.process("itinerary", context);

        // Create a temporary file to hold the PDF
        File tempPdf = File.createTempFile("itinerary", ".pdf");

        String filePath = "C:/Users/Dell/Desktop/itienerary/itienerary/src/main/resources/templates/itinerary.pdf";

        // Create a file output stream to write the PDF
        try (OutputStream outputStream = new FileOutputStream(tempPdf)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
        }

        // Add watermark to the PDF
        addWatermark(tempPdf, filePath);
    }

    private void addWatermark(File inputPdf, String outputPdf) throws IOException, DocumentException {
        PdfReader pdfReader = new PdfReader(new FileInputStream(inputPdf));
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(outputPdf));


        // Load the watermark image
        Image watermark = Image.getInstance("C:\\Users\\Dell\\Desktop\\itienerary\\itienerary\\src\\main\\resources\\images\\UDN.jpg");
        watermark.setAbsolutePosition(0, 0); // Adjust as needed
        watermark.scaleToFit(40, 40); // Adjust size as needed

        PdfContentByte contentByte;
        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            contentByte = pdfStamper.getOverContent(i);
            // Calculate position for the top-right corner
            float pageWidth = pdfReader.getPageSize(i).getWidth();
            float pageHeight = pdfReader.getPageSize(i).getHeight();
            float watermarkWidth = watermark.getScaledWidth();
            float watermarkHeight = watermark.getScaledHeight();

            // Position watermark at the top-right corner
            watermark.setAbsolutePosition(pageWidth - watermarkWidth - 20, pageHeight - watermarkHeight - 20); // 20 units margin from the edges
            contentByte.addImage(watermark);
        }

        pdfStamper.close();
        pdfReader.close();


    }
}
