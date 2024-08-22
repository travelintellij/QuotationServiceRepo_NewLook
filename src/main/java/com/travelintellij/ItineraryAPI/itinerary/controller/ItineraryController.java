package com.travelintellij.ItineraryAPI.itinerary.controller;

import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryTemp;
import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryMaster;
import com.travelintellij.ItineraryAPI.itinerary.service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    @GetMapping("/search/{quotationId}")
    public ResponseEntity<List<ItineraryTemp>> searchItinerary(@PathVariable Long quotationId) {
        return ResponseEntity.ok(itineraryService.searchItineraries(quotationId));
    }



    @ResponseBody
    @RequestMapping(path = "/getItineraryByQuotationId", method = RequestMethod.GET)
    public String  getItineraryByQuotationId(@RequestParam long quotationId) {
        Optional<ItineraryTemp> itinerary = itineraryService.getItineraryByQuotationId(quotationId);
        if(itinerary.isPresent()) {
            return Boolean.TRUE.toString();
        } else {
            return Boolean.FALSE.toString();
        }

    }


    @PostMapping
    public ResponseEntity<ItineraryTemp> createItinerary(@RequestBody ItineraryTemp request) {

        ItineraryTemp itineraryTemp = new ItineraryTemp();
        itineraryTemp.setTravelDestination(request.getTravelDestination());
        itineraryTemp.setCreatedAt(request.getCreatedAt());
        itineraryTemp.setDuration(request.getDuration());
        itineraryTemp.setLeadId(request.getLeadId());
        itineraryTemp.setQuotationId(request.getQuotationId());

        List<ItineraryMaster> details = request.getDetails().stream()
                .map(detail -> {
                    ItineraryMaster itineraryMaster = new ItineraryMaster();
                    itineraryMaster.setTitle(detail.getTitle());
                    itineraryMaster.setDayNumber(detail.getDayNumber());
                    itineraryMaster.setActivity(detail.getActivity());
                    return itineraryMaster;
                }).collect(Collectors.toList());

        ItineraryTemp savedItinerary = itineraryService.createItineraryWithDetails(itineraryTemp, details);
        return ResponseEntity.ok(savedItinerary);
    }

    @DeleteMapping("/{quotationId}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long quotationId) {
        itineraryService.deleteItinerary(quotationId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ItineraryTemp> updateItinerary(@RequestBody ItineraryTemp request) {
        ItineraryTemp itineraryTemp = new ItineraryTemp();
        itineraryTemp.setTravelDestination(request.getTravelDestination());
        itineraryTemp.setCreatedAt(request.getCreatedAt());
        itineraryTemp.setDuration(request.getDuration());
        itineraryTemp.setLeadId(request.getLeadId());
        itineraryTemp.setQuotationId(request.getQuotationId());

        List<ItineraryMaster> details = request.getDetails().stream()
                .map(detail -> {
                    ItineraryMaster itineraryMaster = new ItineraryMaster();
                    itineraryMaster.setTitle(detail.getTitle());
                    itineraryMaster.setDayNumber(detail.getDayNumber());
                    itineraryMaster.setActivity(detail.getActivity());
                    return itineraryMaster;
                }).collect(Collectors.toList());

        itineraryService.deleteItinerary(request.getQuotationId());
        ItineraryTemp savedItinerary = itineraryService.createItineraryWithDetails(itineraryTemp, details);
        return ResponseEntity.ok(savedItinerary);
    }
}
