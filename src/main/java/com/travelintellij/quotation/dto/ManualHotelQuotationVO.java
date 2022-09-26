package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Manual_Hotel_Quotation_Entity;

import java.util.Map;



public class ManualHotelQuotationVO extends Udn_Manual_Hotel_Quotation_Entity implements Comparable{

private String cityName;
private String hotelName;
private String roomCategoryName;
private Map roomCategoryMap;
private String mealPlanName;
	
	public void updateManualHotelVoFromEntity(Udn_Manual_Hotel_Quotation_Entity manualHotelEntity) {
		this.manualHotelQuotationId = manualHotelEntity.getManualHotelQuotationId();
		this.optionNo = manualHotelEntity.getOptionNo();
		this.hotelId = manualHotelEntity.getHotelId();
		this.roomCategoryId = manualHotelEntity.getRoomCategoryId();
		this.cityId = manualHotelEntity.getCityId();
		this.checkInDate = manualHotelEntity.getCheckInDate();
		this.checkOutDate = manualHotelEntity.getCheckOutDate();
		this.adults = manualHotelEntity.getAdults();
		this.children = manualHotelEntity.getChildren();
		this.extrabed = manualHotelEntity.getExtrabed();
		this.mealPlan = manualHotelEntity.getMealPlan();
		this.noOfRooms = manualHotelEntity.getNoOfRooms();
		this.remarks = manualHotelEntity.getRemarks();
		this.hotelStayCost = manualHotelEntity.getHotelStayCost();
		this.hotelStayMarkup = manualHotelEntity.getHotelStayMarkup();
		this.displayOrder = manualHotelEntity.getDisplayOrder();
		this.active = manualHotelEntity.isActive();
		this.quotationEntity = manualHotelEntity.getQuotationEntity();
	}


@Override
public int compareTo(Object manualHotel) {
	if(this.getDisplayOrder() < ((ManualHotelQuotationVO)manualHotel).getDisplayOrder() ) {
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


public String getHotelName() {
	return hotelName;
}


public void setHotelName(String hotelName) {
	this.hotelName = hotelName;
}


public String getRoomCategoryName() {
	return roomCategoryName;
}


public void setRoomCategoryName(String roomCategoryName) {
	this.roomCategoryName = roomCategoryName;
}


public String getMealPlanName() {
	return mealPlanName;
}


public void setMealPlanName(String mealPlanName) {
	this.mealPlanName = mealPlanName;
}


@Override
public String toString() {
	return "ManualHotelQuotationVO [cityName=" + cityName + ", hotelName=" + hotelName + ", roomCategoryName="
			+ roomCategoryName + ", mealPlanName=" + mealPlanName + ", manualHotelQuotationId=" + manualHotelQuotationId
			+ ", hotelId=" + hotelId + ", roomCategoryId=" + roomCategoryId + ", cityId=" + cityId + ", checkInDate="
			+ checkInDate + ", checkOutDate=" + checkOutDate + ", adults=" + adults + ", children=" + children
			+ ", extrabed=" + extrabed + ", mealplan=" + mealPlan + ", noOfRooms=" + noOfRooms + ", remarks=" + remarks
			+ ", hotelStayCost=" + hotelStayCost + ", hotelStayMarkup=" + hotelStayMarkup + ", displayOrder="
			+ displayOrder + ", active=" + active + ", quotationEntity=" + quotationEntity + "]";
}


public Map getRoomCategoryMap() {
	return roomCategoryMap;
}


public void setRoomCategoryMap(Map roomCategoryMap) {
	this.roomCategoryMap = roomCategoryMap;
}



}
