package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Udn_Manual_Insurance_Quotation_Entity;

public class ManualInsuranceQuotationVO extends Udn_Manual_Insurance_Quotation_Entity implements Comparable<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String countryName;
	private String insuranceProviderName;
	public void updateManualInsuranceVoFromEntity(Udn_Manual_Insurance_Quotation_Entity manualInsEntity) {
		this.manualInsuranceQuotationId=manualInsEntity.getManualInsuranceQuotationId();
		this.insuranceName=manualInsEntity.getInsuranceName();
		this.insuranceDetails=manualInsEntity.getInsuranceDetails();
		this.coverageStartDate=manualInsEntity.getCoverageStartDate();
		this.coverageEndDate=manualInsEntity.getCoverageEndDate();
		this.coverageAmount=manualInsEntity.getCoverageAmount();
		this.coverageCurrency=manualInsEntity.getCoverageCurrency();
		this.countryId = manualInsEntity.getCountryId();
		this.adults=manualInsEntity.getAdults();
		this.children=manualInsEntity.getChildren();
		this.infant=manualInsEntity.getInfant();
		this.premiumCost=manualInsEntity.getPremiumCost();
		this.premiumMarkup=manualInsEntity.getPremiumMarkup();
		this.displayOrder=manualInsEntity.getDisplayOrder();
		this.active=manualInsEntity.isActive();
		this.insuranceProvider =manualInsEntity.getInsuranceProvider(); 
		this.remarks=manualInsEntity.getRemarks();

	}

	@Override
	public int compareTo(Object manualVisa) {
		if(this.getDisplayOrder() < ((ManualInsuranceQuotationVO)manualVisa).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getInsuranceProviderName() {
		return insuranceProviderName;
	}

	public void setInsuranceProviderName(String insuranceProviderName) {
		this.insuranceProviderName = insuranceProviderName;
	}


	
	
}
