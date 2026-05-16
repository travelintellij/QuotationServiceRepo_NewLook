package com.travelintellij.request.dto;

import com.travelintellij.quotation.util.TIConstants;
import lombok.Getter;
import lombok.Setter;

public class TI_CityRecorderDTO {
    protected int destinationId;
    protected String cityName;
    protected String countryCode = TIConstants.DEFAULT_DESTINATION_INDIA_CTRY_CODE;
    protected String countryName = TIConstants.DEFAULT_DESTINATION_INDIA_CTRY_NAME;
    protected boolean active = true;

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public TI_CityRecorderDTO() {

    }

    public String toString() {
        String attrib = "destination Id -> " + destinationId + "\n";
        attrib = attrib + " City Name -> " + cityName + "\n";
        attrib = attrib + " Country Code-> " + countryCode + "\n";
        attrib = attrib + " Country Name-> " + countryName + "\n";
        attrib = attrib + " City Active -> " + active + "\n";
        return attrib;
    }

}