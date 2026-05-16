package com.travelintellij.quotation.contoller;

import com.travelintellij.quotation.entity.ItineraryMasterEntity;
import com.travelintellij.quotation.entity.ItineraryDay;
import com.travelintellij.quotation.repository.ItineraryMasterRepository;
import com.travelintellij.quotation.repository.TI_Quotations_Repository;
import com.travelintellij.quotation.entity.Tg_Quotation_Recorder_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class ItineraryApiController {

    @Autowired
    private ItineraryMasterRepository itineraryMasterRepository;

    @Autowired
    private TI_Quotations_Repository quotationRepository;

    // SAVE ITINERARY
    @PostMapping("/save_itinerary")
    @Transactional
    public String saveItinerary(@RequestBody ItineraryMasterEntity itinerary) {

        // Ensure bidirectional relationship is set for each day
        if (itinerary.getDays() != null) {
            itinerary.getDays().forEach(day -> day.setItinerary(itinerary));
        }

        itineraryMasterRepository.save(itinerary);
        return itinerary.getItineraryId().toString();
    }

    // DUPLICATE ITINERARY
    @PostMapping("/duplicate_itinerary")
    @Transactional
    public String duplicateItinerary(
            @RequestParam Long leadId,
            @RequestParam Long itineraryId) {

        ItineraryMasterEntity existing = itineraryMasterRepository.findById(itineraryId).orElse(null);

        if(existing == null){
            return "NOT_FOUND";
        }

        ItineraryMasterEntity copy = new ItineraryMasterEntity();
        copy.setLeadId(leadId);
        copy.setTitle(existing.getTitle() + " (Copy)");
        copy.setDescription(existing.getDescription());
        copy.setParentItineraryId(existing.getItineraryId());
        copy.setIsDeleted(false);
        copy.setCreatedDate(LocalDateTime.now());

        // Deep copy the days
        if (existing.getDays() != null) {
            for (ItineraryDay originalDay : existing.getDays()) {
                ItineraryDay dayCopy = new ItineraryDay();
                dayCopy.setDayNumber(originalDay.getDayNumber());
                dayCopy.setTitle(originalDay.getTitle());
                dayCopy.setDescription(originalDay.getDescription());
                // Link the copy to the new itinerary
                copy.addDay(dayCopy);
            }
        }

        itineraryMasterRepository.save(copy);
        return copy.getItineraryId().toString();
    }

    // LINK EXISTING ITINERARY
    @PostMapping("/link_existing_itinerary")
    @Transactional
    public String linkItinerary(
            @RequestParam Long leadId,
            @RequestParam Long itineraryId) {

        ItineraryMasterEntity existing = itineraryMasterRepository.findById(itineraryId).orElse(null);

        if(existing == null){
            return "NOT_FOUND";
        }

        existing.setLeadId(leadId);
        itineraryMasterRepository.save(existing);
        return existing.getItineraryId().toString();
    }

    // 🔥 THIS IS YOUR MAIN DROPDOWN API
    @GetMapping("/get_itineraries_by_lead")
    public List<Map<String, Object>> getItineraries(@RequestParam Long leadId) {

        List<ItineraryMasterEntity> list = itineraryMasterRepository.findByLeadIdAndIsDeletedFalse(leadId);

        List<Map<String, Object>> result = new ArrayList<>();

        for(ItineraryMasterEntity i : list){
            Map<String, Object> map = new HashMap<>();
            map.put("id", i.getItineraryId());
            map.put("title", i.getTitle());
            map.put("description", i.getDescription());
            map.put("totalDays", i.getDays() != null ? i.getDays().size() : 0);
            
            // Fetch linked quotations
            List<Tg_Quotation_Recorder_Entity> linkedQtns = quotationRepository.findByItineraryId(i.getItineraryId());
            
            List<Map<String, Object>> qtnInfos = new ArrayList<>();
            if (linkedQtns != null && !linkedQtns.isEmpty()) {
                for(Tg_Quotation_Recorder_Entity q : linkedQtns) {
                    Map<String, Object> qInfo = new HashMap<>();
                    qInfo.put("id", q.getQuotationId());
                    qInfo.put("name", q.getQuotationName());
                    qtnInfos.add(qInfo);
                }
            }
            map.put("linkedQuotations", qtnInfos);
            
            result.add(map);
        }

        return result;
    }

    @GetMapping("/get_itinerary_by_id")
    public ItineraryMasterEntity getItineraryById(@RequestParam Long id) {
        return itineraryMasterRepository.findById(id).orElse(null);
    }

    @GetMapping("/get_itinerary")
    public ItineraryMasterEntity getItinerary(@RequestParam Long itineraryId) {
        return itineraryMasterRepository.findById(itineraryId).orElse(null);
    }

    @PostMapping("/update_itinerary")
    @Transactional
    public String updateItinerary(@RequestBody ItineraryMasterEntity itinerary) {

        ItineraryMasterEntity existing = itineraryMasterRepository.findById(itinerary.getItineraryId()).orElse(null);

        if (existing != null) {
            existing.setLeadId(itinerary.getLeadId());
            existing.setTitle(itinerary.getTitle());
            existing.setDescription(itinerary.getDescription());

            // Clear old days and add new ones (cascade ALL handles removal and save)
            existing.getDays().clear();
            if (itinerary.getDays() != null) {
                for (ItineraryDay day : itinerary.getDays()) {
                    existing.addDay(day);
                }
            }

            itineraryMasterRepository.save(existing);
            return existing.getItineraryId().toString();
        }

        return "NOT_FOUND";
    }

    @GetMapping("/getItineraryByQuotationId")
    public ItineraryMasterEntity getItineraryByQuotationId(@RequestParam Long quotationId) {

        // TEMPORARY LOGIC
        // replace with actual DB relation later

        return itineraryMasterRepository.findById(quotationId).orElse(null);
    }
}