package com.travelintellij.quotation.entity;

import javax.persistence.*;

@Entity
@Table(name = "quotation_itinerary_mapping",
        uniqueConstraints = @UniqueConstraint(columnNames = {"quotation_id", "itinerary_id"}))
public class QuotationItineraryMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quotation_id")
    private Long quotationId;

    @Column(name = "itinerary_id")
    private Long itineraryId;

    @Column(name = "is_linked")
    private Boolean isLinked = true;

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    public Long getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public Boolean getIsLinked() {
        return isLinked;
    }

    public void setIsLinked(Boolean isLinked) {
        this.isLinked = isLinked;
    }
}
