package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

public class TI_AirportDTO {
	
	protected int airportId;
	protected String airportName;
	protected String airportCode;
	protected String cityName;
	protected String cityCode;
	protected String countryName;
	protected String countryCode;
	protected String nationality;
	protected String currency;
	protected boolean active;

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Tg_Flt_Airport_Entity [airportId=" + airportId + ", airportName=" + airportName + ", airportCode="
				+ airportCode + ", cityName=" + cityName + ", cityCode=" + cityCode + ", countryName=" + countryName
				+ ", countryCode=" + countryCode + ", nationality=" + nationality + ", currency=" + currency
				+ ", active=" + active + "]";
	}
}