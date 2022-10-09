package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Size;


@Getter
@Setter
public class ClientRecorderDTO {

	private Long clientId;
	private String clientName;
	
	private String address;
	
	private int cityId;
	
	private String cityName;
	private String countryName;
	private String email;
	private Long mobile;
	private Long phone;
	private String companyDetails;
	private String referredBy;
	private String gstDetails;
	private String bankDetails;
	private String remarks;
	private int countryId;
	private String passportNumber;
	private Date passportExpiry;
	private Date birthDate;
	private Date anniversaryDate;
	private int hotelPref;
	private int costSavvy;
	private int serviceSavvy;
	private String foodPref;
	private int aggressiveness;
	private int paymentRating;
	private boolean active=true;
	
	public ClientRecorderDTO() {
		
	}
	
	public String toString() {
		String attributes = "" + " Client ID - " + clientId + "\n";
		attributes = attributes + " Client Name - " + clientName + "\n";
		attributes = attributes + " Client Address -  " + address + "\n";
		attributes = attributes + " City - " + cityId + "\n";
		attributes = attributes + " Email - " + email + "\n";
		attributes = attributes + " mobile  - " + mobile + "\n";
		attributes = attributes + " Phone - " + phone + "\n";
		attributes = attributes + " Company Name - " + companyDetails + "\n";
		attributes = attributes + " ReferredBy - " + referredBy + "\n";
		attributes = attributes + " GST Number - " + gstDetails + "\n";
		attributes = attributes + " Bank Account Details - " + bankDetails + "\n";
		attributes = attributes + " remarks - " + remarks + "\n";
		attributes = attributes + " countryId - " + countryId + "\n";
		attributes = attributes + " passportNumber - " + passportNumber + "\n";
		attributes = attributes + " passportExpiry - " + passportExpiry + "\n";
		attributes = attributes + " birthDate - " + birthDate + "\n";
		attributes = attributes + " anniversaryDate - " + anniversaryDate + "\n";
		attributes = attributes + " hotelPref - " + hotelPref + "\n";
		attributes = attributes + " costSavvy - " + costSavvy + "\n";
		attributes = attributes + " serviceSavvy - " + serviceSavvy + "\n";
		attributes = attributes + " foodPref - " + foodPref + "\n";
		attributes = attributes + " aggressiveness - " + aggressiveness + "\n";
		attributes = attributes + " paymentRating - " + paymentRating + "\n";
		attributes = attributes + " active - " + active + "\n";
		return attributes;
		
	}
	


}
