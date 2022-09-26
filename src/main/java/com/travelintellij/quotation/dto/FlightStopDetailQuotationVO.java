package com.travelintellij.quotation.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.travelintellij.quotation.entity.Udn_Flight_Quotation_Stop_Detail_Entity;


public class FlightStopDetailQuotationVO extends Udn_Flight_Quotation_Stop_Detail_Entity implements Comparable{

/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private String originCity;
private String destinationCity;
private String airlineName;
private String cabinClassName;

private String dateErrorHolder;


private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");



public String getOriginCity() {
	return originCity;
}
public void setOriginCity(String originCity) {
	this.originCity = originCity;
}

public void setDepartureDate(String depDate) {
	this.departureDate = LocalDateTime.parse(depDate,formatter);
}

public void setArrivalDate(String  arrDate) {
	this.arrivalDate = LocalDateTime.parse(arrDate,formatter);
}


public String getDestinationCity() {
	return destinationCity;
}
public void setDestinationCity(String destinationCity) {
	this.destinationCity = destinationCity;
}



public String getAirlineName() {
	return airlineName;
}
public void setAirlineName(String airlineName) {
	this.airlineName = airlineName;
}


public void updateFlightStopVoFromEntity(Udn_Flight_Quotation_Stop_Detail_Entity flightStopEntity) {
	this.fltQuotationStopId= flightStopEntity.getFltQuotationStopId();
	this.airlineId=flightStopEntity.getAirlineId();
	this.flightNumber=flightStopEntity.getFlightNumber();
	this.airportCodeOrigin=flightStopEntity.getAirportCodeOrigin();
	this.airportCodeDestination=flightStopEntity.getAirportCodeDestination();
	this.departureDate=flightStopEntity.getDepartureDate();
	this.arrivalDate=flightStopEntity.getArrivalDate();
	this.adultCount=flightStopEntity.getAdultCount();
	this.childCount=flightStopEntity.getChildCount();
	this.infantCount=flightStopEntity.getInfantCount();
	this.cabinClass=flightStopEntity.getCabinClass();
	this.active = flightStopEntity.isActive();
}


public String getCabinClassName() {
	return cabinClassName;
}
public void setCabinClassName(String cabinClassName) {
	this.cabinClassName = cabinClassName;
}

@Override
public int compareTo(Object flightStopVo) {

	if(this.getDepartureDate().isBefore(((FlightStopDetailQuotationVO)flightStopVo).getDepartureDate()))
		return -1;
	else
		return 1;
}

@Override
public String toString() {
	return "FlightStopDetailQuotationVO [originCity=" + originCity + ", destinationCity=" + destinationCity
			+ ", airlineName=" + airlineName + ", cabinClassName=" + cabinClassName + ", fltQuotationStopId=" + fltQuotationStopId + ", airlineId=" + airlineId + ", flightNumber="
			+ flightNumber + ", airportCodeOrigin=" + airportCodeOrigin + ", airportCodeDestination="
			+ airportCodeDestination + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
			+ ", adultCount=" + adultCount + ", childCount=" + childCount + ", infantCount=" + infantCount
			+ ", cabinClass=" + cabinClass + ", active=" + active + ", manualFlightQuotationEntity="
			+ manualFlightQuotationEntity + "]";
}
public String getDateErrorHolder() {
	return dateErrorHolder;
}
public void setDateErrorHolder(String dateErrorHolder) {
	this.dateErrorHolder = dateErrorHolder;
}


}