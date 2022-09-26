package com.travelintellij.quotation.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.travelintellij.quotation.dto.ManualHotelQuotationVO;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "udn_htl_manual_quotation")
public class Udn_Manual_Hotel_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualHotelQuotationId;
	
	protected int hotelId;
	protected int roomCategoryId;
	protected int cityId;
	protected Date checkInDate;
	protected Date checkOutDate;
	protected int adults;
	protected int children;
	protected int extrabed;
	protected int mealPlan;
	protected int noOfRooms;
	protected String remarks;
	protected int hotelStayCost;
	protected int hotelStayMarkup;
	protected int displayOrder;
	protected boolean active;
	protected int optionNo=0;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;
	
	
	
	
	public Udn_Manual_Hotel_Quotation_Entity(ManualHotelQuotationVO manualHotelQuotationVO) {
		this.manualHotelQuotationId = manualHotelQuotationVO.getManualHotelQuotationId();
		this.hotelId = manualHotelQuotationVO.getHotelId();
		this.roomCategoryId = manualHotelQuotationVO.getRoomCategoryId();
		this.cityId = manualHotelQuotationVO.getCityId();
		this.checkInDate = manualHotelQuotationVO.getCheckInDate();
		this.checkOutDate = manualHotelQuotationVO.getCheckOutDate();
		this.adults = manualHotelQuotationVO.getAdults();
		this.children = manualHotelQuotationVO.getChildren();
		this.extrabed = manualHotelQuotationVO.getExtrabed();
		this.mealPlan = manualHotelQuotationVO.getMealPlan();
		this.noOfRooms = manualHotelQuotationVO.getNoOfRooms();
		this.remarks = manualHotelQuotationVO.getRemarks();
		this.hotelStayCost = manualHotelQuotationVO.getHotelStayCost();
		this.hotelStayMarkup = manualHotelQuotationVO.getHotelStayMarkup();
		this.displayOrder = manualHotelQuotationVO.getDisplayOrder();
		this.active = manualHotelQuotationVO.isActive();
		this.optionNo = manualHotelQuotationVO.getOptionNo();
		//this.quotationEntity = manualHotelQuotationVO.getQuotationEntity();
	}

	public Udn_Manual_Hotel_Quotation_Entity() {}
	
	
	public long getManualHotelQuotationId() {
		return manualHotelQuotationId;
	}

	public void setManualHotelQuotationId(long manualHotelQuotationId) {
		this.manualHotelQuotationId = manualHotelQuotationId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomCategoryId() {
		return roomCategoryId;
	}

	public void setRoomCategoryId(int roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getExtrabed() {
		return extrabed;
	}

	public void setExtrabed(int extrabed) {
		this.extrabed = extrabed;
	}

	public int getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(int mealPlan) {
		this.mealPlan = mealPlan;
	}

	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getHotelStayCost() {
		return hotelStayCost;
	}

	public void setHotelStayCost(int hotelStayCost) {
		this.hotelStayCost = hotelStayCost;
	}

	public int getHotelStayMarkup() {
		return hotelStayMarkup;
	}

	public void setHotelStayMarkup(int hotelStayMarkup) {
		this.hotelStayMarkup = hotelStayMarkup;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Tg_Quotation_Recorder_Entity getQuotationEntity() {
		return quotationEntity;
	}

	public void setQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity) {
		this.quotationEntity = quotationEntity;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getOptionNo() {
		return optionNo;
	}

	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}
	

	
	
}
