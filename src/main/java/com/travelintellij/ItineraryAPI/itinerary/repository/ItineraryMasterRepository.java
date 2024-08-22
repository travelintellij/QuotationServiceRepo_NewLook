package com.travelintellij.ItineraryAPI.itinerary.repository;

import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItineraryMasterRepository extends JpaRepository<ItineraryMaster, Long> {
}
