package com.travelintellij.ItineraryAPI.itinerary.repository;

import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryTempRepository extends JpaRepository<ItineraryTemp, Long> {

    List<ItineraryTemp> findByTravelDestination(String travelDestination);
    List<ItineraryTemp> findByQuotationId(Long quotationId);

}
