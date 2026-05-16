package com.travelintellij.quotation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelintellij.quotation.entity.ItineraryMasterEntity;

@Repository
public interface ItineraryMasterRepository
        extends JpaRepository<ItineraryMasterEntity, Long> {

    List<ItineraryMasterEntity> findByLeadIdAndIsDeletedFalse(Long leadId);
}