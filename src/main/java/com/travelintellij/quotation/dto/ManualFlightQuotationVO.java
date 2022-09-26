package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Flight_Quotation_Stop_Detail_Entity;
import com.travelintellij.quotation.entity.Udn_Manual_Flight_Quotation_Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class ManualFlightQuotationVO extends Udn_Manual_Flight_Quotation_Entity implements Comparable{

private String originCity;
private String destinationCity;
private String airlineName;
private String cabinClassName;

protected SortedSet<FlightStopDetailQuotationVO> flightStopsQuotationsVoList = new TreeSet<FlightStopDetailQuotationVO>();

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

public void setArrivalDate(String arrDate) {
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


public void updateManualFlightVoFromEntity(Udn_Manual_Flight_Quotation_Entity manualFligtEntity) {
	this.manualFlightQuotationId = manualFligtEntity.getManualFlightQuotationId();
	this.airlineId=manualFligtEntity.getAirlineId();
	this.flightNumber=manualFligtEntity.getFlightNumber();
	this.airportCodeOrigin=manualFligtEntity.getAirportCodeOrigin();
	this.airportCodeDestination=manualFligtEntity.getAirportCodeDestination();
	this.departureDate=manualFligtEntity.getDepartureDate();
	this.arrivalDate=manualFligtEntity.getArrivalDate();
	this.duration=manualFligtEntity.getDuration();
	this.adultCount=manualFligtEntity.getAdultCount();
	this.childCount=manualFligtEntity.getChildCount();
	this.infantCount=manualFligtEntity.getInfantCount();
	this.noOfStops=manualFligtEntity.getNoOfStops();
	this.cabinClass=manualFligtEntity.getCabinClass();
	this.flightCost = manualFligtEntity.getFlightCost();
	this.flightMarkup=manualFligtEntity.getFlightMarkup();
	this.displayOrder=manualFligtEntity.getDisplayOrder();
	this.active = manualFligtEntity.isActive();
	updateFlightStopVO(manualFligtEntity.getFltQuotationStopsList());
}


private void updateFlightStopVO(Set<Udn_Flight_Quotation_Stop_Detail_Entity> flightStopsList) {
	flightStopsList.forEach((e) -> { 
		FlightStopDetailQuotationVO flightStopVo = new FlightStopDetailQuotationVO();
		flightStopVo.updateFlightStopVoFromEntity(e);
		flightStopsQuotationsVoList.add(flightStopVo);
	});
	//System.out.println("Flight Id is " + getManualFlightQuotationId() +" Size issss " + flightStopsQuotationsVoList.size());
}


@Override
public String toString() {
	return "ManualFlightQuotationVO [originCity=" + originCity + ", destinationCity=" + destinationCity + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", getOriginCity()="
			+ getOriginCity() + ", getDestinationCity()=" + getDestinationCity() + ", getAirlineId()=" + getAirlineId()
			+ ", getAdultCount()=" + getAdultCount() + ", getChildCount()=" + getChildCount() + ", getInfantCount()="
			+ getInfantCount() + ", getFlightNumber()=" + getFlightNumber() + ", getAirportCodeOrigin()="
			+ getAirportCodeOrigin() + ", getAirportCodeDestination()=" + getAirportCodeDestination()
			+ ", getDepartureDate()=" + getDepartureDate() + ", getArrivalDate()=" + getArrivalDate()
			+ ", getDuration()=" + getDuration() + ", getNoOfStops()=" + getNoOfStops() + ", getCabinClass()="
			+ getCabinClass() + ", getManualFlightQuotationId()=" + getManualFlightQuotationId() + ", getCreatedAt()="
			+ getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", toString()=" + super.toString() + "]";
}
public String getCabinClassName() {
	return cabinClassName;
}
public void setCabinClassName(String cabinClassName) {
	this.cabinClassName = cabinClassName;
}

/*
public int compareTo(ManualFlightQuotationVO manualFlight) {
    // return this.id - otherStudent.id ; //result of this operation can overflow
    return (this.displayOrder < manualFlight.displayOrder ) ? -1: (this.displayOrder > manualFlight.displayOrder) ? 1:0 ;

 }
*/

@Override
public int compareTo(Object manualFlight) {
	if(this.getDisplayOrder() < ((ManualFlightQuotationVO)manualFlight).getDisplayOrder() ) {
		return -1;
	}
	else {
		return 1;
	}
	//return (this.displayOrder < ((ManualFlightQuotationVO)manualFlight).displayOrder ) ? -1: (this.displayOrder > ((ManualFlightQuotationVO)manualFlight).displayOrder) ? 1:0 ;
}
public SortedSet<FlightStopDetailQuotationVO> getFlightStopsQuotationsVoList() {
	return flightStopsQuotationsVoList;
}
public void setFlightStopsQuotationsVoList(SortedSet<FlightStopDetailQuotationVO> flightStopsQuotationsVoList) {
	this.flightStopsQuotationsVoList = flightStopsQuotationsVoList;
}


}
