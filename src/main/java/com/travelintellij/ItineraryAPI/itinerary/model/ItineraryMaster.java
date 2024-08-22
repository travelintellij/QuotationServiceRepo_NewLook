package com.travelintellij.ItineraryAPI.itinerary.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "itinerary_master")
@Entity
public class ItineraryMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day_number")
    private int dayNumber;

    private String title;
    @Column(length = 10000)
    private String activity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itinerary_id", nullable = false)
    @JsonBackReference
    private ItineraryTemp itinerary;
}
