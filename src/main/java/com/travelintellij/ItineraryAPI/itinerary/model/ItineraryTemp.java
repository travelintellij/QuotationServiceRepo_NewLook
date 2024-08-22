package com.travelintellij.ItineraryAPI.itinerary.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.travelintellij.ItineraryAPI.itinerary.model.ItineraryMaster;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "itinerary_temp")
@Entity
public class ItineraryTemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "travel_destination")
    private String travelDestination;

    @Column(name = "created_at")
    private Date createdAt;

    private int duration;

    @Column(name = "lead_id")
    private Long leadId;

    @Column(name="quotation_id",unique = true)
    private Long quotationId;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ItineraryMaster> details;


}
