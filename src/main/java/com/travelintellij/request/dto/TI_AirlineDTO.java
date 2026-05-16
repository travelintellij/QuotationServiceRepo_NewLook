package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class TI_AirlineDTO {
	
	private long airlineId;
	private String airlineCode;
	private String airlineShortName;
	private String airlineName;
	private String address1;
	private String address2;
	private long customerCare;
	private String email;
	private String remarks;

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineShortName() {
		return airlineShortName;
	}

	public void setAirlineShortName(String airlineShortName) {
		this.airlineShortName = airlineShortName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public long getCustomerCare() {
		return customerCare;
	}

	public void setCustomerCare(long customerCare) {
		this.customerCare = customerCare;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String toString() {
		
		String attrib = " airlineId-> " + airlineId + "\n";
		attrib = attrib + "airlineShortName -> " + airlineShortName+ "\n";
		attrib = attrib + "airlineName -> " + airlineName + "\n";
		attrib = attrib + "address1 -> " + address1 + "\n";
		attrib = attrib + "address2 -> " + address2 + "\n";
		attrib = attrib + "customerCare -> " + customerCare + "\n";
		attrib = attrib + "email -> " + email + "\n";
		attrib = attrib + "remarks -> " + remarks + "\n";
		return attrib;
	}

}