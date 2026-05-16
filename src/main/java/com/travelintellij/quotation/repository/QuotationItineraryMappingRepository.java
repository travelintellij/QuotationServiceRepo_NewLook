package com.travelintellij.quotation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelintellij.quotation.entity.QuotationItineraryMappingEntity;

@Repository
public interface QuotationItineraryMappingRepository
        extends JpaRepository<QuotationItineraryMappingEntity, Long> {
}