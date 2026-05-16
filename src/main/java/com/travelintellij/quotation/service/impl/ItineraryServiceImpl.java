package com.travelintellij.quotation.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.travelintellij.quotation.entity.ItineraryDay;
import com.travelintellij.quotation.repository.ItineraryDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelintellij.quotation.entity.ItineraryMasterEntity;
import com.travelintellij.quotation.entity.QuotationItineraryMappingEntity;
import com.travelintellij.quotation.repository.ItineraryMasterRepository;
import com.travelintellij.quotation.repository.QuotationItineraryMappingRepository;

@Service
public class ItineraryServiceImpl {

    @Autowired
    private ItineraryMasterRepository itineraryMasterRepo;

    @Autowired
    private ItineraryDayRepository itineraryDayRepo;

    @Autowired
    private QuotationItineraryMappingRepository mappingRepo;

    // ✅ SAVE NEW ITINERARY
    public ItineraryMasterEntity saveItinerary(ItineraryMasterEntity itinerary) {
        return itineraryMasterRepo.save(itinerary);
    }

    // ✅ FIND BY ID
    public ItineraryMasterEntity findItineraryById(Long itineraryId) {
        return itineraryMasterRepo.findById(itineraryId).orElse(null);
    }

    // ✅ GET ALL ITINERARIES FOR LEAD (FOR DROPDOWN)
    public List<ItineraryMasterEntity> findItinerariesByLeadId(Long leadId) {
        return itineraryMasterRepo.findByLeadIdAndIsDeletedFalse(leadId);
    }

    // ✅ LINK EXISTING ITINERARY (READ ONLY)
    public void linkExistingItinerary(Long itineraryId, Long quotationId) {

        QuotationItineraryMappingEntity mapping = new QuotationItineraryMappingEntity();
        mapping.setItineraryId(itineraryId);
        mapping.setQuotationId(quotationId);
        mapping.setIsLinked(true); // 🔒 original (no edit)

        mappingRepo.save(mapping);
    }

    // ✅ DUPLICATE ITINERARY (EDITABLE COPY)
    public ItineraryMasterEntity duplicateItinerary(Long itineraryId, Long quotationId) {

        ItineraryMasterEntity original = findItineraryById(itineraryId);

        if (original == null) return null;

        // 🔥 STEP 1: COPY MASTER
        ItineraryMasterEntity copy = new ItineraryMasterEntity();
        copy.setLeadId(original.getLeadId());
        copy.setTitle(original.getTitle() + " (Copy)");
        copy.setDescription(original.getDescription());
        copy.setParentItineraryId(original.getItineraryId());

        ItineraryMasterEntity savedCopy = itineraryMasterRepo.save(copy);

        // 🔥 STEP 2: COPY DAYS
        List<ItineraryDay> newDays = new ArrayList<>();



        // 🔥 STEP 3: MAP WITH QUOTATION
        QuotationItineraryMappingEntity mapping = new QuotationItineraryMappingEntity();
        mapping.setItineraryId(savedCopy.getItineraryId());
        mapping.setQuotationId(quotationId);
        mapping.setIsLinked(false); // editable copy

        mappingRepo.save(mapping);

        return savedCopy;
    }
}