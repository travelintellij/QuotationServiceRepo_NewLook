package com.travelintellij.ItineraryAPI.itinerary.controller;



import com.lowagie.text.DocumentException;
import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryTemp;
import com.travelintellij.ItineraryAPI.itinerary.service.ItineraryService;

import com.travelintellij.ItineraryAPI.itinerary.service.PdfGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/pdf")
public class PdfController {

    @Autowired
    private ItineraryService itineraryService;

    @Autowired
    private PdfGenerationService pdfGenerationService;
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    @GetMapping("/pdf/{quotationId}")
    public void getPdf(@PathVariable Long quotationId, HttpServletResponse response) throws IOException, DocumentException {
        Optional<ItineraryTemp> itinerary = itineraryService.getItineraryByQuotationId(quotationId);
        if (itinerary.isPresent()) {
            pdfGenerationService.generatePdf(itinerary.get(), response);
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.getWriter().write("Itinerary not found.");
        }
    }
}
