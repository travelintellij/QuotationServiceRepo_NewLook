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
import com.travelintellij.quotation.dto.ManualTransferQuotationVO;

@Entity
@Table(name = "udn_trn_manual_quotation")
public class Udn_Manual_Transfer_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualTransferQuotationId;
	
	protected int pickUpCityId;
	protected int pickUpFrom;
	protected String pickUpFromName;
	protected int dropToCityId;
	protected int dropTo;
	protected String dropToName;
	protected Date 	transferDate;
	protected int adults;
	protected int children;
	protected int infant;
	protected int transferType;
	protected int transferCost;
	protected int transferMarkup;
	protected String remarks;
	protected int displayOrder;
	protected boolean active;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	
	
	public Udn_Manual_Transfer_Quotation_Entity() {}
	
	
	
	
	public Udn_Manual_Transfer_Quotation_Entity(ManualTransferQuotationVO manualTransferVO) {
		this.manualTransferQuotationId = manualTransferVO.getManualTransferQuotationId();
		this.pickUpCityId = manualTransferVO.getPickUpCityId();
		this.pickUpFrom = manualTransferVO.getPickUpFrom();
		this.pickUpFromName = manualTransferVO.getPickUpFromName();
		this.dropToCityId = manualTransferVO.getDropToCityId();
		this.dropTo = manualTransferVO.getDropTo();
		this.dropToName = manualTransferVO.getDropToName();
		this.transferDate = manualTransferVO.getTransferDate();
		this.adults = manualTransferVO.getAdults();
		this.children = manualTransferVO.getChildren();
		this.infant = manualTransferVO.getInfant();
		this.transferType = manualTransferVO.getTransferType();
		this.transferCost = manualTransferVO.getTransferCost();
		this.transferMarkup = manualTransferVO.getTransferMarkup();
		this.remarks = manualTransferVO.getRemarks();
		this.displayOrder = manualTransferVO.getDisplayOrder();
		this.active = manualTransferVO.isActive();
		
	}




	public long getManualTransferQuotationId() {
		return manualTransferQuotationId;
	}
	public void setManualTransferQuotationId(long manualTransferQuotationId) {
		this.manualTransferQuotationId = manualTransferQuotationId;
	}

	
	public int getPickUpCityId() {
		return pickUpCityId;
	}
	public void setPickUpCityId(int pickUpCityId) {
		this.pickUpCityId = pickUpCityId;
	}
	public int getPickUpFrom() {
		return pickUpFrom;
	}
	public void setPickUpFrom(int pickUpFrom) {
		this.pickUpFrom = pickUpFrom;
	}
	public String getPickUpFromName() {
		return pickUpFromName;
	}
	public void setPickUpFromName(String pickUpFromName) {
		this.pickUpFromName = pickUpFromName;
	}
	public int getDropToCityId() {
		return dropToCityId;
	}
	public void setDropToCityId(int dropToCityId) {
		this.dropToCityId = dropToCityId;
	}
	public int getDropTo() {
		return dropTo;
	}
	public void setDropTo(int dropTo) {
		this.dropTo = dropTo;
	}
	public String getDropToName() {
		return dropToName;
	}
	public void setDropToName(String dropToName) {
		this.dropToName = dropToName;
	}

	/*public void setTransferDate(LocalDateTime transferDate) {
		this.transferDate = transferDate;
	}*/
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
	public int getTransferCost() {
		return transferCost;
	}
	public void setTransferCost(int transferCost) {
		this.transferCost = transferCost;
	}
	public int getTransferMarkup() {
		return transferMarkup;
	}
	public void setTransferMarkup(int transferMarkup) {
		this.transferMarkup = transferMarkup;
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

	public Tg_Quotation_Recorder_Entity getQuotationEntity() {
		return quotationEntity;
	}

	public void setQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity) {
		this.quotationEntity = quotationEntity;
	}




	public Date getTransferDate() {
		return transferDate;
	}




	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	
	
	
}
