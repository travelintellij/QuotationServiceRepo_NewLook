package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Udn_Manual_Cruise_Quotation_Entity;

public class ManualCruiseQuotationVO extends Udn_Manual_Cruise_Quotation_Entity implements Comparable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/**
	 * 
	 */

	private String cityName;
	private String stateRoomName;
	private String cruiseProviderName;
	
	public void updateManualCruiseVoFromEntity(Udn_Manual_Cruise_Quotation_Entity manualCruiseEntity) {
		this.manualCruiseQuotationId = manualCruiseEntity.getManualCruiseQuotationId();
		this.cruiseName=manualCruiseEntity.getCruiseName();
		this.cruiseProvider = manualCruiseEntity.getCruiseProvider();
		this.stateRoomType = manualCruiseEntity.getStateRoomType();
		this.cityId = manualCruiseEntity.getCityId();
		this.sailingStartDate = manualCruiseEntity.getSailingStartDate();
		this.sailingEndDate = manualCruiseEntity.getSailingEndDate();
		this.adults = manualCruiseEntity.getAdults();
		this.children = manualCruiseEntity.getChildren();
		this.childrenAgeInfo = manualCruiseEntity.getChildrenAgeInfo();
		this.noOfDecks = manualCruiseEntity.getNoOfDecks();
		this.remarks = manualCruiseEntity.getRemarks();
		this.cruiseStayCost = manualCruiseEntity.getCruiseStayCost();
		this.cruiseStayMarkup = manualCruiseEntity.getCruiseStayMarkup();
		this.displayOrder = manualCruiseEntity.getDisplayOrder();
		this.active = manualCruiseEntity.isActive();
	}

	@Override
	public int compareTo(Object manualCruise) {
		if(this.getDisplayOrder() < ((ManualCruiseQuotationVO)manualCruise).getDisplayOrder() ) {
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

	public String getStateRoomName() {
		return stateRoomName;
	}

	public void setStateRoomName(String stateRoomName) {
		this.stateRoomName = stateRoomName;
	}

	public String getCruiseProviderName() {
		return cruiseProviderName;
	}

	public void setCruiseProviderName(String cruiseProviderName) {
		this.cruiseProviderName = cruiseProviderName;
	}

	@Override
	public String toString() {
		return "ManualCruiseQuotationVO{" +
				"cityName='" + cityName + '\'' +
				", stateRoomName='" + stateRoomName + '\'' +
				", cruiseProviderName='" + cruiseProviderName + '\'' +
				", manualCruiseQuotationId=" + manualCruiseQuotationId +
				", stateRoomType=" + stateRoomType +
				", cruiseProvider=" + cruiseProvider +
				", cruiseName='" + cruiseName + '\'' +
				", cityId=" + cityId +
				", sailingStartDate=" + sailingStartDate +
				", sailingEndDate=" + sailingEndDate +
				", adults=" + adults +
				", children=" + children +
				", childrenAgeInfo='" + childrenAgeInfo + '\'' +
				", noOfDecks=" + noOfDecks +
				", remarks='" + remarks + '\'' +
				", cruiseStayCost=" + cruiseStayCost +
				", cruiseStayMarkup=" + cruiseStayMarkup +
				", displayOrder=" + displayOrder +
				", active=" + active +
				'}';
	}
}
