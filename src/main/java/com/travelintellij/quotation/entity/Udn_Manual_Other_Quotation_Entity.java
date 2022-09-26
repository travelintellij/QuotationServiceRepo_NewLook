package com.travelintellij.quotation.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualOtherQuotationVO;

@Entity
@Table(name = "udn_oth_manual_quotation")
public class Udn_Manual_Other_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualOtherQuotationId;

	protected String serviceName;
	protected String serviceDetails;
	protected Date serviceDate;
	protected int serviceCost;
	protected int serviceMarkup;
	protected int displayOrder;
	protected boolean active;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	public Udn_Manual_Other_Quotation_Entity() {}
	
	public Udn_Manual_Other_Quotation_Entity(ManualOtherQuotationVO manualOthVO) {
		this.manualOtherQuotationId=manualOthVO.getManualOtherQuotationId();
		this.serviceName=manualOthVO.getServiceName();
		this.serviceDetails=manualOthVO.getServiceDetails();
		this.serviceDate=manualOthVO.getServiceDate();
		this.serviceCost=manualOthVO.getServiceCost();
		this.serviceMarkup=manualOthVO.getServiceMarkup();
		this.displayOrder=manualOthVO.getDisplayOrder();
		this.active=manualOthVO.isActive();
	}

	public long getManualOtherQuotationId() {
		return manualOtherQuotationId;
	}

	public void setManualOtherQuotationId(long manualOtherQuotationId) {
		this.manualOtherQuotationId = manualOtherQuotationId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(int serviceCost) {
		this.serviceCost = serviceCost;
	}

	public int getServiceMarkup() {
		return serviceMarkup;
	}

	public void setServiceMarkup(int serviceMarkup) {
		this.serviceMarkup = serviceMarkup;
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





	

}
