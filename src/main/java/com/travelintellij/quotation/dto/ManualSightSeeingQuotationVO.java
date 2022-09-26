package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Udn_Manual_SightSeeing_Quotation_Entity;

public class ManualSightSeeingQuotationVO extends Udn_Manual_SightSeeing_Quotation_Entity implements Comparable<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String transferTypeName;
	private String cityName;

	public void updateManualSightSeeingVoFromEntity(Udn_Manual_SightSeeing_Quotation_Entity manualSightSeeingEntity) {
		this.manualSightSeeingQuotationId = manualSightSeeingEntity.getManualSightSeeingQuotationId();
		this.sightSeeingId = manualSightSeeingEntity.getSightSeeingId();
		this.cityId = manualSightSeeingEntity.getCityId();
		this.savedSightSeeing = manualSightSeeingEntity.isSavedSightSeeing();
		this.sightSeeingName = manualSightSeeingEntity.getSightSeeingName();
		this.sightSeeingDate = manualSightSeeingEntity.getSightSeeingDate();
		this.adults = manualSightSeeingEntity.getAdults();
		this.children = manualSightSeeingEntity.getChildren();
		this.infant = manualSightSeeingEntity.getInfant();
		this.transferType = manualSightSeeingEntity.getTransferType();
		this.sightSeeingCost = manualSightSeeingEntity.getSightSeeingCost();
		this.sightSeeingMarkup = manualSightSeeingEntity.getSightSeeingMarkup();
		this.remarks = manualSightSeeingEntity.getRemarks();
		this.displayOrder = manualSightSeeingEntity.getDisplayOrder();
		this.active = manualSightSeeingEntity.isActive();
	}

	public ManualSightSeeingQuotationVO() {}


	@Override
	public int compareTo(Object manualTransfer) {
		if(this.getDisplayOrder() < ((ManualSightSeeingQuotationVO)manualTransfer).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}

	public String getTransferTypeName() {
		return transferTypeName;
	}

	public void setTransferTypeName(String transferTypeName) {
		this.transferTypeName = transferTypeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
}
