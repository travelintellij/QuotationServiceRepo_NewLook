package com.travelintellij.request.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	@Override
	public String toString() {
		return "Tg_Flt_Airport_Entity [airportId=" + airportId + ", airportName=" + airportName + ", airportCode="
				+ airportCode + ", cityName=" + cityName + ", cityCode=" + cityCode + ", countryName=" + countryName
				+ ", countryCode=" + countryCode + ", nationality=" + nationality + ", currency=" + currency
				+ ", active=" + active + "]";
	}
}