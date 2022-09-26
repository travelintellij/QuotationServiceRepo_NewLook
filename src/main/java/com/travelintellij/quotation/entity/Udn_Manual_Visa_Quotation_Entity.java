package com.travelintellij.quotation.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualVisaQuotationVO;

@Entity
@Table(name = "udn_vsa_manual_quotation")
public class Udn_Manual_Visa_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualVisaQuotationId;
	
	protected int adults;
	protected int children;
	protected int infant;
	protected int visaCost;
	protected int visaMarkup;
	protected String remarks;
	protected int displayOrder;
	protected boolean active;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	@OneToOne
    @JoinColumn(name="visaId")
	protected Udn_Visa_Master_Entity visaQuotationEntity;
	
	public Udn_Manual_Visa_Quotation_Entity() {}
	
	
	
	
	public Udn_Manual_Visa_Quotation_Entity(ManualVisaQuotationVO manualVisaVO) {
		this.manualVisaQuotationId = manualVisaVO.getManualVisaQuotationId();
		//this.visaId
		this.adults = manualVisaVO.getAdults();
		this.children = manualVisaVO.getChildren();
		this.infant = manualVisaVO.getInfant();
		this.visaCost = manualVisaVO.getVisaCost();
		this.visaMarkup = manualVisaVO.getVisaMarkup();
		this.remarks = manualVisaVO.getRemarks();
		this.displayOrder = manualVisaVO.getDisplayOrder();
		this.active = manualVisaVO.isActive();
	}

	public long getManualVisaQuotationId() {
		return manualVisaQuotationId;
	}

	public void setManualVisaQuotationId(long manualVisaQuotationId) {
		this.manualVisaQuotationId = manualVisaQuotationId;
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




	public int getVisaCost() {
		return visaCost;
	}




	public void setVisaCost(int visaCost) {
		this.visaCost = visaCost;
	}




	public int getVisaMarkup() {
		return visaMarkup;
	}




	public void setVisaMarkup(int visaMarkup) {
		this.visaMarkup = visaMarkup;
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




	public Udn_Visa_Master_Entity getVisaQuotationEntity() {
		return visaQuotationEntity;
	}




	public void setVisaQuotationEntity(Udn_Visa_Master_Entity visaQuotationEntity) {
		this.visaQuotationEntity = visaQuotationEntity;
	}

	
}
