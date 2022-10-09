package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
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