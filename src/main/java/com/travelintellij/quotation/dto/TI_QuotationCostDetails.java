package com.travelintellij.quotation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class TI_QuotationCostDetails {
    private int flightTotalCost;
    private int flightTotalMarkup;
    private Map<Integer, Integer> hotelOptionsWithCostAndMarkup;
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
                '}';
    }
}
