package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Udn_Manual_Package_Quotation_Entity;

public class ManualPackageQuotationVO extends Udn_Manual_Package_Quotation_Entity implements Comparable<Object>{

	private String cityName;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void updateManualPackageVoFromEntity(Udn_Manual_Package_Quotation_Entity manualPkgEntity) {
		this.manualPkgQuotationId= manualPkgEntity.getManualPkgQuotationId();
		this.adults = manualPkgEntity.getAdults();
		this.children = manualPkgEntity.getChildren();
		this.infant = manualPkgEntity.getInfant();
		this.packageName = manualPkgEntity.getPackageName();
		this.startDate = manualPkgEntity.getStartDate();
		this.endDate=manualPkgEntity.getEndDate();
		this.remarks = manualPkgEntity.getRemarks();
		this.pkgCost = manualPkgEntity.getPkgCost();
		this.pkgMarkup = manualPkgEntity.getPkgMarkup();
		this.packageDescription = manualPkgEntity.getPackageDescription();
		this.inclusions=manualPkgEntity.getInclusions();
		this.exclusions=manualPkgEntity.getExclusions();
		this.displayOrder = manualPkgEntity.getDisplayOrder();
		this.quotationEntity = manualPkgEntity.getQuotationEntity();
		this.cityId = manualPkgEntity.getCityId();
		this.flightIncluded=manualPkgEntity.isFlightIncluded();
		this.active = manualPkgEntity.isActive();
	}

	@Override
	public int compareTo(Object manualVisa) {
		if(this.getDisplayOrder() < ((ManualPackageQuotationVO)manualVisa).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
	
	
	
}
