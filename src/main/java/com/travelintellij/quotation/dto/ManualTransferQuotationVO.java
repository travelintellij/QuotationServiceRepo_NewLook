package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Manual_Transfer_Quotation_Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class ManualTransferQuotationVO extends Udn_Manual_Transfer_Quotation_Entity implements Comparable<Object>{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pickUpCityName;
	private String dropToCityName;
	private String pickUpFromDesc;
	private String dropToDesc;
	private String transferTypeName;


	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

	public void updateManualTransferVoFromEntity(Udn_Manual_Transfer_Quotation_Entity manualTransferEntity) {
		this.manualTransferQuotationId = manualTransferEntity.getManualTransferQuotationId();
		this.pickUpCityId = manualTransferEntity.getPickUpCityId();
		this.pickUpFrom = manualTransferEntity.getPickUpFrom();
		this.pickUpFromName = manualTransferEntity.getPickUpFromName();
		this.dropToCityId = manualTransferEntity.getDropToCityId();
		this.dropTo = manualTransferEntity.getDropTo();
		this.dropToName = manualTransferEntity.getDropToName();
		this.transferDate = manualTransferEntity.getTransferDate();
		this.adults = manualTransferEntity.getAdults();
		this.children = manualTransferEntity.getChildren();
		this.infant = manualTransferEntity.getInfant();
		this.transferType = manualTransferEntity.getTransferType();
		this.transferCost = manualTransferEntity.getTransferCost();
		this.transferMarkup = manualTransferEntity.getTransferMarkup();
		this.remarks = manualTransferEntity.getRemarks();
		this.displayOrder = manualTransferEntity.getDisplayOrder();
		this.quotationEntity = manualTransferEntity.getQuotationEntity();
		this.active = manualTransferEntity.isActive();

	}

	@Override
	public int compareTo(Object manualTransfer) {
		if(this.getDisplayOrder() < ((ManualTransferQuotationVO)manualTransfer).getDisplayOrder() ) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
	public String getPickUpCityName() {
		return pickUpCityName;
	}
	
	
	public void setPickUpCityName(String pickUpCityName) {
		this.pickUpCityName = pickUpCityName;
	}
	
	
	public String getDropToCityName() {
		return dropToCityName;
	}
	
	
	public void setDropToCityName(String dropToCityName) {
		this.dropToCityName = dropToCityName;
	}
	
	/*
	public void setTransferDate(String transferDate) {
		this.transferDate = LocalDateTime.parse(transferDate,formatter);
	}*/

	public String getPickUpFromDesc() {
		return pickUpFromDesc;
	}

	public void setPickUpFromDesc(String pickUpFromDesc) {
		this.pickUpFromDesc = pickUpFromDesc;
	}

	public String getDropToDesc() {
		return dropToDesc;
	}

	public void setDropToDesc(String dropToDesc) {
		this.dropToDesc = dropToDesc;
	}

	public String getTransferTypeName() {
		return transferTypeName;
	}

	public void setTransferTypeName(String transferTypeName) {
		this.transferTypeName = transferTypeName;
	}

	@Override
	public String toString() {
		return "ManualTransferQuotationVO{" +
				"pickUpCityName='" + pickUpCityName + '\'' +
				", dropToCityName='" + dropToCityName + '\'' +
				", pickUpFromDesc='" + pickUpFromDesc + '\'' +
				", dropToDesc='" + dropToDesc + '\'' +
				", transferTypeName='" + transferTypeName + '\'' +
				", formatter=" + formatter +
				", manualTransferQuotationId=" + manualTransferQuotationId +
				", pickUpCityId=" + pickUpCityId +
				", pickUpFrom=" + pickUpFrom +
				", pickUpFromName='" + pickUpFromName + '\'' +
				", dropToCityId=" + dropToCityId +
				", dropTo=" + dropTo +
				", dropToName='" + dropToName + '\'' +
				", transferDate=" + transferDate +
				", adults=" + adults +
				", children=" + children +
				", infant=" + infant +
				", transferType=" + transferType +
				", transferCost=" + transferCost +
				", transferMarkup=" + transferMarkup +
				", remarks='" + remarks + '\'' +
				", displayOrder=" + displayOrder +
				", active=" + active +
				'}';
	}
}
