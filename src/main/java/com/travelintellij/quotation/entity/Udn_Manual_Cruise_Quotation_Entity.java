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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualCruiseQuotationVO;

@Entity
@Table(name = "udn_crs_manual_quotation")
public class Udn_Manual_Cruise_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualCruiseQuotationId;
	
	protected int stateRoomType;
	protected int cruiseProvider;
	
	protected String cruiseName;
	protected int cityId;
	protected Date sailingStartDate;
	protected Date sailingEndDate;
	protected int adults;
	protected int children;
	protected String childrenAgeInfo;
	
	protected int noOfDecks;
	protected String remarks;
	protected int cruiseStayCost;
	protected int cruiseStayMarkup;
	protected int displayOrder;
	protected boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;
	
	
	
	
	public Udn_Manual_Cruise_Quotation_Entity(ManualCruiseQuotationVO manualCruiseQuotationVO) {
		this.manualCruiseQuotationId = manualCruiseQuotationVO.getManualCruiseQuotationId();
		this.cruiseName=manualCruiseQuotationVO.getCruiseName();
		this.cruiseProvider=manualCruiseQuotationVO.getCruiseProvider();
		this.stateRoomType = manualCruiseQuotationVO.getStateRoomType();
		this.cityId = manualCruiseQuotationVO.getCityId();
		this.sailingStartDate = manualCruiseQuotationVO.getSailingStartDate();
		this.sailingEndDate = manualCruiseQuotationVO.getSailingEndDate();
		this.adults = manualCruiseQuotationVO.getAdults();
		this.children = manualCruiseQuotationVO.getChildren();
		this.childrenAgeInfo = manualCruiseQuotationVO.getChildrenAgeInfo();
		this.noOfDecks = manualCruiseQuotationVO.getNoOfDecks();
		this.remarks = manualCruiseQuotationVO.getRemarks();
		this.cruiseStayCost = manualCruiseQuotationVO.getCruiseStayCost();
		this.cruiseStayMarkup = manualCruiseQuotationVO.getCruiseStayMarkup();
		this.displayOrder = manualCruiseQuotationVO.getDisplayOrder();
		this.active = manualCruiseQuotationVO.isActive();
		//this.quotationEntity = manualHotelQuotationVO.getQuotationEntity();
	}

	public Udn_Manual_Cruise_Quotation_Entity() {}

	public long getManualCruiseQuotationId() {
		return manualCruiseQuotationId;
	}

	public void setManualCruiseQuotationId(long manualCruiseQuotationId) {
		this.manualCruiseQuotationId = manualCruiseQuotationId;
	}



	public int getStateRoomType() {
		return stateRoomType;
	}

	public void setStateRoomType(int stateRoomType) {
		this.stateRoomType = stateRoomType;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public Date getSailingStartDate() {
		return sailingStartDate;
	}

	public void setSailingStartDate(Date sailingStartDate) {
		this.sailingStartDate = sailingStartDate;
	}

	public Date getSailingEndDate() {
		return sailingEndDate;
	}

	public void setSailingEndDate(Date sailingEndDate) {
		this.sailingEndDate = sailingEndDate;
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

	public int getNoOfDecks() {
		return noOfDecks;
	}

	public void setNoOfDecks(int noOfDecks) {
		this.noOfDecks = noOfDecks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getCruiseStayCost() {
		return cruiseStayCost;
	}

	public void setCruiseStayCost(int cruiseStayCost) {
		this.cruiseStayCost = cruiseStayCost;
	}

	public int getCruiseStayMarkup() {
		return cruiseStayMarkup;
	}

	public void setCruiseStayMarkup(int cruiseStayMarkup) {
		this.cruiseStayMarkup = cruiseStayMarkup;
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

	public String getCruiseName() {
		return cruiseName;
	}

	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	public int getCruiseProvider() {
		return cruiseProvider;
	}

	public void setCruiseProvider(int cruiseProvider) {
		this.cruiseProvider = cruiseProvider;
	}

	public String getChildrenAgeInfo() {
		return childrenAgeInfo;
	}

	public void setChildrenAgeInfo(String childrenAgeInfo) {
		this.childrenAgeInfo = childrenAgeInfo;
	}
	
	
	
	
	
}
