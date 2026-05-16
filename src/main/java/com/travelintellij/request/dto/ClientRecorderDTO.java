package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.constraints.Size;


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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(String companyDetails) {
		this.companyDetails = companyDetails;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getGstDetails() {
		return gstDetails;
	}

	public void setGstDetails(String gstDetails) {
		this.gstDetails = gstDetails;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getPassportExpiry() {
		return passportExpiry;
	}

	public void setPassportExpiry(Date passportExpiry) {
		this.passportExpiry = passportExpiry;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public int getHotelPref() {
		return hotelPref;
	}

	public void setHotelPref(int hotelPref) {
		this.hotelPref = hotelPref;
	}

	public int getCostSavvy() {
		return costSavvy;
	}

	public void setCostSavvy(int costSavvy) {
		this.costSavvy = costSavvy;
	}

	public int getServiceSavvy() {
		return serviceSavvy;
	}

	public void setServiceSavvy(int serviceSavvy) {
		this.serviceSavvy = serviceSavvy;
	}

	public String getFoodPref() {
		return foodPref;
	}

	public void setFoodPref(String foodPref) {
		this.foodPref = foodPref;
	}

	public int getAggressiveness() {
		return aggressiveness;
	}

	public void setAggressiveness(int aggressiveness) {
		this.aggressiveness = aggressiveness;
	}

	public int getPaymentRating() {
		return paymentRating;
	}

	public void setPaymentRating(int paymentRating) {
		this.paymentRating = paymentRating;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
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
