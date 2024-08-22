package com.travelintellij.ItineraryAPI.itinerary.service;


import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryTemp;
import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryMaster;
import com.travelintellij.ItineraryAPI.itinerary.repository.ItineraryMasterRepository;
import com.travelintellij.ItineraryAPI.itinerary.repository.ItineraryTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryMasterRepository itineraryMasterRepository;

    @Autowired
    private ItineraryTempRepository itineraryTempRepository;

    public List<ItineraryTemp> searchItineraries(Long quotationId) {
        return itineraryTempRepository.findByQuotationId(quotationId);
    }

    public Optional<ItineraryTemp> getItineraryByQuotationId(Long quotationId) {
        return itineraryTempRepository.findByQuotationId(quotationId).stream().findFirst();
    }

    public ItineraryTemp saveItinerary(ItineraryTemp itineraryTemp) {
        return itineraryTempRepository.save(itineraryTemp);
    }

    public void deleteItinerary(Long quotationId) {
        Optional<ItineraryTemp> itinerary = getItineraryByQuotationId(quotationId);
        itinerary.ifPresent(itineraryTempRepository::delete);
        }


    // New method to handle saving of itinerary and its details
    public ItineraryTemp createItineraryWithDetails(ItineraryTemp itineraryTemp, List<ItineraryMaster> details) {
        //Save Itinerary Temp First
        ItineraryTemp savedItinerary = saveItinerary(itineraryTemp);

        //Save each details associated with saved Itinerary
        for(ItineraryMaster detail: details) {
            detail.setItinerary(savedItinerary);
            itineraryMasterRepository.save(detail);
        }
        return savedItinerary;

    }


    }

