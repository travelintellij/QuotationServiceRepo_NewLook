package com.travelintellij.quotation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class TI_QuotationCostDetails {
    private int flightTotalCost;
    private int flightTotalMarkup;
    private Map<Integer, Integer> hotelOptionsWithCostAndMarkup ;
    private Map<Integer, Integer> hotelOptionsWithMarkup ;
    private int sightSeeingTotalCost;
    private int sightSeeingTotalMarkup;
    private int tourPackageTotalCost;
    private int tourPackageTotalMarkup;
    private int visaTotalCost;
    private int visaTotalMarkup;
    private int cruiseTotalCost;
    private int cruiseTotalMarkup;
    private int otherTotalCost;
    private int otherTotalMarkup;
    private int transfersTotalCost;
    private int transfersTotalMarkup;
    private int insuranceTotalCost;
    private int insuranceTotalMarkup;
    private int grandTotalWithoutHotel;

    public int getFlightTotalCost() {
        return flightTotalCost;
    }

    public void setFlightTotalCost(int flightTotalCost) {
        this.flightTotalCost = flightTotalCost;
    }

    public int getFlightTotalMarkup() {
        return flightTotalMarkup;
    }

    public void setFlightTotalMarkup(int flightTotalMarkup) {
        this.flightTotalMarkup = flightTotalMarkup;
    }

    public Map<Integer, Integer> getHotelOptionsWithCostAndMarkup() {
        return hotelOptionsWithCostAndMarkup;
    }

    public void setHotelOptionsWithCostAndMarkup(Map<Integer, Integer> hotelOptionsWithCostAndMarkup) {
        this.hotelOptionsWithCostAndMarkup = hotelOptionsWithCostAndMarkup;
    }

    public Map<Integer, Integer> getHotelOptionsWithMarkup() {
        return hotelOptionsWithMarkup;
    }

    public void setHotelOptionsWithMarkup(Map<Integer, Integer> hotelOptionsWithMarkup) {
        this.hotelOptionsWithMarkup = hotelOptionsWithMarkup;
    }

    public int getSightSeeingTotalCost() {
        return sightSeeingTotalCost;
    }

    public void setSightSeeingTotalCost(int sightSeeingTotalCost) {
        this.sightSeeingTotalCost = sightSeeingTotalCost;
    }

    public int getSightSeeingTotalMarkup() {
        return sightSeeingTotalMarkup;
    }

    public void setSightSeeingTotalMarkup(int sightSeeingTotalMarkup) {
        this.sightSeeingTotalMarkup = sightSeeingTotalMarkup;
    }

    public int getTourPackageTotalCost() {
        return tourPackageTotalCost;
    }

    public void setTourPackageTotalCost(int tourPackageTotalCost) {
        this.tourPackageTotalCost = tourPackageTotalCost;
    }

    public int getTourPackageTotalMarkup() {
        return tourPackageTotalMarkup;
    }

    public void setTourPackageTotalMarkup(int tourPackageTotalMarkup) {
        this.tourPackageTotalMarkup = tourPackageTotalMarkup;
    }

    public int getVisaTotalCost() {
        return visaTotalCost;
    }

    public void setVisaTotalCost(int visaTotalCost) {
        this.visaTotalCost = visaTotalCost;
    }

    public int getVisaTotalMarkup() {
        return visaTotalMarkup;
    }

    public void setVisaTotalMarkup(int visaTotalMarkup) {
        this.visaTotalMarkup = visaTotalMarkup;
    }

    public int getCruiseTotalCost() {
        return cruiseTotalCost;
    }

    public void setCruiseTotalCost(int cruiseTotalCost) {
        this.cruiseTotalCost = cruiseTotalCost;
    }

    public int getCruiseTotalMarkup() {
        return cruiseTotalMarkup;
    }

    public void setCruiseTotalMarkup(int cruiseTotalMarkup) {
        this.cruiseTotalMarkup = cruiseTotalMarkup;
    }

    public int getOtherTotalCost() {
        return otherTotalCost;
    }

    public void setOtherTotalCost(int otherTotalCost) {
        this.otherTotalCost = otherTotalCost;
    }

    public int getOtherTotalMarkup() {
        return otherTotalMarkup;
    }

    public void setOtherTotalMarkup(int otherTotalMarkup) {
        this.otherTotalMarkup = otherTotalMarkup;
    }

    public int getTransfersTotalCost() {
        return transfersTotalCost;
    }

    public void setTransfersTotalCost(int transfersTotalCost) {
        this.transfersTotalCost = transfersTotalCost;
    }

    public int getTransfersTotalMarkup() {
        return transfersTotalMarkup;
    }

    public void setTransfersTotalMarkup(int transfersTotalMarkup) {
        this.transfersTotalMarkup = transfersTotalMarkup;
    }

    public int getInsuranceTotalCost() {
        return insuranceTotalCost;
    }

    public void setInsuranceTotalCost(int insuranceTotalCost) {
        this.insuranceTotalCost = insuranceTotalCost;
    }

    public int getInsuranceTotalMarkup() {
        return insuranceTotalMarkup;
    }

    public void setInsuranceTotalMarkup(int insuranceTotalMarkup) {
        this.insuranceTotalMarkup = insuranceTotalMarkup;
    }

    public int getGrandTotalWithoutHotel() {
        return grandTotalWithoutHotel;
    }

    public void setGrandTotalWithoutHotel(int grandTotalWithoutHotel) {
        this.grandTotalWithoutHotel = grandTotalWithoutHotel;
    }

    @Override
    public String toString() {
        return "TI_QuotationCostDetails{" +
                "flightTotalCost=" + flightTotalCost +
                ", flightTotalMarkup=" + flightTotalMarkup +
                ", hotelOptionsWithCostAndMarkup=" + hotelOptionsWithCostAndMarkup +
                ", sightSeeingTotalCost=" + sightSeeingTotalCost +
                ", sightSeeingTotalMarkup=" + sightSeeingTotalMarkup +
                ", tourPackageTotalCost=" + tourPackageTotalCost +
                ", tourPackageTotalMarkup=" + tourPackageTotalMarkup +
                ", visaTotalCost=" + visaTotalCost +
                ", visaTotalMarkup=" + visaTotalMarkup +
                ", cruiseTotalCost=" + cruiseTotalCost +
                ", cruiseTotalMarkup=" + cruiseTotalMarkup +
                ", otherTotalCost=" + otherTotalCost +
                ", otherTotalMarkup=" + otherTotalMarkup +
                ", transfersTotalCost=" + transfersTotalCost +
                ", transfersTotalMarkup=" + transfersTotalMarkup +
                ", insuranceTotalCost=" + insuranceTotalCost +
                ", insuranceTotalMarkup=" + insuranceTotalMarkup +
                ", grandTotalWithoutHotel=" + grandTotalWithoutHotel +
                '}';
    }
}
