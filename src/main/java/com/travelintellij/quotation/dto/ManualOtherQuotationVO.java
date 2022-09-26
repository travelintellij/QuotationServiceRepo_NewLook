package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Manual_Other_Quotation_Entity;

public class ManualOtherQuotationVO extends Udn_Manual_Other_Quotation_Entity implements Comparable<Object>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void updateManualOtherVoFromEntity(Udn_Manual_Other_Quotation_Entity manualPkgEntity) {
		this.manualOtherQuotationId=manualPkgEntity.getManualOtherQuotationId();
		this.serviceName=manualPkgEntity.getServiceName();
		this.serviceDetails=manualPkgEntity.getServiceDetails();
		this.serviceDate=manualPkgEntity.getServiceDate();
		this.serviceCost=manualPkgEntity.getServiceCost();
		this.serviceMarkup=manualPkgEntity.getServiceMarkup();
		this.displayOrder=manualPkgEntity.getDisplayOrder();
		this.active=manualPkgEntity.isActive();

	}

	@Override
	public int compareTo(Object manualVisa) {
		if(this.getDisplayOrder() < ((ManualOtherQuotationVO)manualVisa).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}


	
	
}
