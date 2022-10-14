package com.travelintellij.quotation.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.entity.Tg_Quotation_Recorder_Entity;
import com.travelintellij.quotation.entity.Udn_Manual_Hotel_Quotation_Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Map;


@Getter
@Setter
public class ManualHotelQuotationVO extends Udn_Manual_Hotel_Quotation_Entity implements Comparable {

	private String cityName;
	private String hotelName;
	private String roomCategoryName;
	private Map roomCategoryMap;
	private String mealPlanName;
	private String formattedCheckInDate;
	private String formattedCheckOutDate;

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
	public String toString() {
		return "ManualHotelQuotationVO{" +
				"cityName='" + cityName + '\'' +
				", hotelName='" + hotelName + '\'' +
				", roomCategoryName='" + roomCategoryName + '\'' +
				", roomCategoryMap=" + roomCategoryMap +
				", mealPlanName='" + mealPlanName + '\'' +
				", formattedCheckInDate='" + formattedCheckInDate + '\'' +
				", formattedCheckOutDate='" + formattedCheckOutDate + '\'' +
				", remarks='" + remarks + '\'' +
				'}';
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


}
