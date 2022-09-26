package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Udn_Manual_Visa_Quotation_Entity;

public class ManualVisaQuotationVO extends Udn_Manual_Visa_Quotation_Entity implements Comparable<Object>{

	private String visaCountry;
	private String visaConsulate;

	private int systemVisaCost;
	private int systemVisaMarkup;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void updateManualVisaVoFromEntity(Udn_Manual_Visa_Quotation_Entity manualVisaEntity) {
		this.manualVisaQuotationId = manualVisaEntity.getManualVisaQuotationId();
		this.adults = manualVisaEntity.getAdults();
		this.children = manualVisaEntity.getChildren();
		this.infant = manualVisaEntity.getInfant();
		this.visaCost = manualVisaEntity.getVisaCost();
		this.visaMarkup = manualVisaEntity.getVisaMarkup();
		this.remarks = manualVisaEntity.getRemarks();
		this.displayOrder = manualVisaEntity.getDisplayOrder();
		this.quotationEntity = manualVisaEntity.getQuotationEntity();
		this.visaQuotationEntity = manualVisaEntity.getVisaQuotationEntity();
		this.active = manualVisaEntity.isActive();
		this.systemVisaCost = (this.adults + this.children + this.infant ) * manualVisaEntity.getVisaQuotationEntity().getStandardCost();
		this.systemVisaMarkup = ((this.adults + this.children + this.infant ) * manualVisaEntity.getVisaQuotationEntity().getStandardB2cPrice()) - this.systemVisaCost;

	}

	@Override
	public int compareTo(Object manualVisa) {
		if(this.getDisplayOrder() < ((ManualVisaQuotationVO)manualVisa).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}

	public String getVisaCountry() {
		return visaCountry;
	}

	public void setVisaCountry(String visaCountry) {
		this.visaCountry = visaCountry;
	}

	public String getVisaConsulate() {
		return visaConsulate;
	}

	public void setVisaConsulate(String visaConsulate) {
		this.visaConsulate = visaConsulate;
	}

	public int getSystemVisaCost() {
		return systemVisaCost;
	}

	public void setSystemVisaCost(int systemVisaCost) {
		this.systemVisaCost = systemVisaCost;
	}

	public int getSystemVisaMarkup() {
		return systemVisaMarkup;
	}

	public void setSystemVisaMarkup(int systemVisaMarkup) {
		this.systemVisaMarkup = systemVisaMarkup;
	}
	

	
}
