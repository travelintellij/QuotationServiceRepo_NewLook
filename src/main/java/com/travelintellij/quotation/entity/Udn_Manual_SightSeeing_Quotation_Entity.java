package com.travelintellij.quotation.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualSightSeeingQuotationVO;

@Entity
@Table(name = "udn_sts_manual_quotation")
public class Udn_Manual_SightSeeing_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualSightSeeingQuotationId;
	
	protected int cityId;
	protected long sightSeeingId;
	protected boolean savedSightSeeing;
	protected String sightSeeingName;
	protected Date sightSeeingDate;
	protected int adults;
	protected int children;
	protected int infant;
	protected int transferType;
	protected int sightSeeingCost;
	protected int sightSeeingMarkup;
	protected String remarks;
	protected int displayOrder;
	protected boolean active;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	
	
	public Udn_Manual_SightSeeing_Quotation_Entity() {}
	
	
	
	
	public Udn_Manual_SightSeeing_Quotation_Entity(ManualSightSeeingQuotationVO manualSightSeeingVO) {
		this.manualSightSeeingQuotationId = manualSightSeeingVO.getManualSightSeeingQuotationId();
		this.sightSeeingId = manualSightSeeingVO.getSightSeeingId();
		this.cityId = manualSightSeeingVO.getCityId();
		this.savedSightSeeing = manualSightSeeingVO.isSavedSightSeeing();
		this.sightSeeingName = manualSightSeeingVO.getSightSeeingName();
		this.sightSeeingDate = manualSightSeeingVO.getSightSeeingDate();
		this.adults = manualSightSeeingVO.getAdults();
		this.children = manualSightSeeingVO.getChildren();
		this.infant = manualSightSeeingVO.getInfant();
		this.transferType = manualSightSeeingVO.getTransferType();
		this.sightSeeingCost = manualSightSeeingVO.getSightSeeingCost();
		this.sightSeeingMarkup = manualSightSeeingVO.getSightSeeingMarkup();
		this.remarks = manualSightSeeingVO.getRemarks();
		this.displayOrder = manualSightSeeingVO.getDisplayOrder();
		this.active = manualSightSeeingVO.isActive();
	}


	public Tg_Quotation_Recorder_Entity getQuotationEntity() {
		return quotationEntity;
	}

	public void setQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity) {
		this.quotationEntity = quotationEntity;
	}




	public long getManualSightSeeingQuotationId() {
		return manualSightSeeingQuotationId;
	}




	public void setManualSightSeeingQuotationId(long manualSightSeeingQuotationId) {
		this.manualSightSeeingQuotationId = manualSightSeeingQuotationId;
	}




	public long getSightSeeingId() {
		return sightSeeingId;
	}




	public void setSightSeeingId(long sightSeeingId) {
		this.sightSeeingId = sightSeeingId;
	}




	public boolean isSavedSightSeeing() {
		return savedSightSeeing;
	}




	public void setSavedSightSeeing(boolean savedSightSeeing) {
		this.savedSightSeeing = savedSightSeeing;
	}




	public String getSightSeeingName() {
		return sightSeeingName;
	}




	public void setSightSeeingName(String sightSeeingName) {
		this.sightSeeingName = sightSeeingName;
	}




	public Date getSightSeeingDate() {
		return sightSeeingDate;
	}




	public void setSightSeeingDate(Date sightSeeingDate) {
		this.sightSeeingDate = sightSeeingDate;
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




	public int getInfant() {
		return infant;
	}




	public void setInfant(int infant) {
		this.infant = infant;
	}




	public int getTransferType() {
		return transferType;
	}




	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}




	public int getSightSeeingCost() {
		return sightSeeingCost;
	}




	public void setSightSeeingCost(int sightSeeingCost) {
		this.sightSeeingCost = sightSeeingCost;
	}




	public int getSightSeeingMarkup() {
		return sightSeeingMarkup;
	}




	public void setSightSeeingMarkup(int sightSeeingMarkup) {
		this.sightSeeingMarkup = sightSeeingMarkup;
	}




	public String getRemarks() {
		return remarks;
	}




	public void setRemarks(String remarks) {
		this.remarks = remarks;
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




	public int getCityId() {
		return cityId;
	}




	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	
	
	
}
