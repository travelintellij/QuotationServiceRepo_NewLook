package com.travelintellij.quotation.repository;

import com.travelintellij.quotation.entity.ItineraryDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryDayRepository
        extends JpaRepository<ItineraryDay, Long> {
    // Basic CRUD operations are sufficient
}