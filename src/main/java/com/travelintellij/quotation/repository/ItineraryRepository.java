package com.travelintellij.quotation.repository;

import com.travelintellij.quotation.entity.ItineraryMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItineraryRepository extends JpaRepository<ItineraryMasterEntity, Long> {

    // Find itineraries for a specific lead
    List<ItineraryMasterEntity> findByLeadId(Long leadId);
}