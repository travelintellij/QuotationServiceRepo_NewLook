package com.travelintellij.quotation.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.travelintellij.quotation.dto.FlightStopDetailQuotationVO;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "udn_flt_quotation_stops_detail")
public class Udn_Flight_Quotation_Stop_Detail_Entity extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long fltQuotationStopId;
	
	protected long airlineId;
	protected String flightNumber;
	protected int airportCodeOrigin;
	protected int airportCodeDestination;
	
	protected LocalDateTime departureDate;
	protected LocalDateTime arrivalDate;
	
	protected int adultCount;
	protected int childCount;
	protected int infantCount;
	
	protected int cabinClass;
	
	

	protected boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manualFlightQuotationId", nullable=false)
	@JsonManagedReference
    protected Udn_Manual_Flight_Quotation_Entity manualFlightQuotationEntity;
	
	
	
	public Udn_Flight_Quotation_Stop_Detail_Entity() {}
	
	public Udn_Flight_Quotation_Stop_Detail_Entity(FlightStopDetailQuotationVO flightStopQuotationVO) {
		this.fltQuotationStopId = flightStopQuotationVO.getFltQuotationStopId();
		this.airlineId=flightStopQuotationVO.getAirlineId();
		this.flightNumber=flightStopQuotationVO.getFlightNumber();
		this.airportCodeOrigin=flightStopQuotationVO.getAirportCodeOrigin();
		this.airportCodeDestination=flightStopQuotationVO.getAirportCodeDestination();
		this.departureDate=flightStopQuotationVO.getDepartureDate();
		this.arrivalDate=flightStopQuotationVO.getArrivalDate();
		this.adultCount=flightStopQuotationVO.getAdultCount();
		this.childCount=flightStopQuotationVO.getChildCount();
		this.infantCount=flightStopQuotationVO.getInfantCount();
		this.cabinClass=flightStopQuotationVO.getCabinClass();
		this.active = flightStopQuotationVO.isActive();
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

	public long getFltQuotationStopId() {
		return fltQuotationStopId;
	}

	public void setFltQuotationStopId(long fltQuotationStopId) {
		this.fltQuotationStopId = fltQuotationStopId;
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

	public int getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(int cabinClass) {
		this.cabinClass = cabinClass;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Udn_Manual_Flight_Quotation_Entity getManualFlightQuotationEntity() {
		return manualFlightQuotationEntity;
	}

	public void setManualFlightQuotationEntity(Udn_Manual_Flight_Quotation_Entity manualFlightQuotationEntity) {
		this.manualFlightQuotationEntity = manualFlightQuotationEntity;
	}

	
	/*public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}*/
	

	
	
	
	
	
}
