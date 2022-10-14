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
		this.cancellationPolicy = manualPkgEntity.getCancellationPolicy();
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


	@Override
	public String toString() {
		return "ManualPackageQuotationVO{" +
				"cityName='" + cityName + '\'' +
				", manualPkgQuotationId=" + manualPkgQuotationId +
				", cityId=" + cityId +
				", adults=" + adults +
				", children=" + children +
				", infant=" + infant +
				", pkgCost=" + pkgCost +
				", pkgMarkup=" + pkgMarkup +
				", packageName='" + packageName + '\'' +
				", packageDescription='" + packageDescription + '\'' +
				", cancellationPolicy='" + cancellationPolicy + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				", displayOrder=" + displayOrder +
				", active=" + active +
				", flightIncluded=" + flightIncluded +
				", inclusions='" + inclusions + '\'' +
				", exclusions='" + exclusions + '\'' +
				", remarks='" + remarks + '\'' +
				'}';
	}
}
