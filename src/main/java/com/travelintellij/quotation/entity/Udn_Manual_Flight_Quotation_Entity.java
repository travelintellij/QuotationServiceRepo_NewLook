package com.travelintellij.quotation.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualFlightQuotationVO;

@Entity
@Table(name = "udn_flt_manual_quotation")
public class Udn_Manual_Flight_Quotation_Entity extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualFlightQuotationId;
	
	protected long airlineId;
	protected String flightNumber;
	protected int airportCodeOrigin;
	protected int airportCodeDestination;
	protected LocalDateTime departureDate;
	protected LocalDateTime arrivalDate;
	protected String duration;
	protected int adultCount;
	protected int childCount;
	protected int infantCount;
	protected int noOfStops;
	protected int cabinClass;
	protected int flightCost;
	protected int flightMarkup;
	protected int displayOrder;

	protected boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "manualFlightQuotationEntity")
	@OrderBy("departureDate")
	@JsonBackReference
	protected Set<Udn_Flight_Quotation_Stop_Detail_Entity> fltQuotationStopsList = new HashSet<Udn_Flight_Quotation_Stop_Detail_Entity>();
	
	
	
	public Udn_Manual_Flight_Quotation_Entity() {}
	
	public Udn_Manual_Flight_Quotation_Entity(ManualFlightQuotationVO manualFlightQuotationVo) {
		this.manualFlightQuotationId = manualFlightQuotationVo.getManualFlightQuotationId();
		this.airlineId=manualFlightQuotationVo.getAirlineId();
		this.flightNumber=manualFlightQuotationVo.getFlightNumber();
		this.airportCodeOrigin=manualFlightQuotationVo.getAirportCodeOrigin();
		this.airportCodeDestination=manualFlightQuotationVo.getAirportCodeDestination();
		this.departureDate=manualFlightQuotationVo.getDepartureDate();
		this.arrivalDate=manualFlightQuotationVo.getArrivalDate();
		this.duration=manualFlightQuotationVo.getDuration();
		this.adultCount=manualFlightQuotationVo.getAdultCount();
		this.childCount=manualFlightQuotationVo.getChildCount();
		this.infantCount=manualFlightQuotationVo.getInfantCount();
		this.flightCost=manualFlightQuotationVo.getFlightCost();
		this.flightMarkup=manualFlightQuotationVo.getFlightMarkup();
		this.displayOrder=manualFlightQuotationVo.getDisplayOrder();
		this.noOfStops=manualFlightQuotationVo.getNoOfStops();
		this.cabinClass=manualFlightQuotationVo.getCabinClass();
		this.active = manualFlightQuotationVo.isActive();
	}
	
	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public int getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public int getInfantCount() {
		return infantCount;
	}

	public void setInfantCount(int infantCount) {
		this.infantCount = infantCount;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
/*
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}*/

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	/*
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	*/

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}

	public int getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(int cabinClass) {
		this.cabinClass = cabinClass;
	}

	public long getManualFlightQuotationId() {
		return manualFlightQuotationId;
	}

	public void setManualFlightQuotationId(long manualFlightQuotationId) {
		this.manualFlightQuotationId = manualFlightQuotationId;
	}

	public int getAirportCodeOrigin() {
		return airportCodeOrigin;
	}

	public void setAirportCodeOrigin(int airportCodeOrigin) {
		this.airportCodeOrigin = airportCodeOrigin;
	}

	public int getAirportCodeDestination() {
		return airportCodeDestination;
	}

	public void setAirportCodeDestination(int airportCodeDestination) {
		this.airportCodeDestination = airportCodeDestination;
	}

	public Tg_Quotation_Recorder_Entity getQuotationEntity() {
		return quotationEntity;
	}

	public void setQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity) {
		this.quotationEntity = quotationEntity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getFlightCost() {
		return flightCost;
	}

	public void setFlightCost(int flightCost) {
		this.flightCost = flightCost;
	}

	public int getFlightMarkup() {
		return flightMarkup;
	}

	public void setFlightMarkup(int flightMarkup) {
		this.flightMarkup = flightMarkup;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Set<Udn_Flight_Quotation_Stop_Detail_Entity> getFltQuotationStopsList() {
		return fltQuotationStopsList;
	}

	public void setFltQuotationStopsList(Set<Udn_Flight_Quotation_Stop_Detail_Entity> fltQuotationStopsList) {
		this.fltQuotationStopsList = fltQuotationStopsList;
	}

	
	
	
	
}
