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
import com.travelintellij.quotation.dto.ManualInsuranceQuotationVO;

@Entity
@Table(name = "udn_ins_manual_quotation")
public class Udn_Manual_Insurance_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualInsuranceQuotationId;

	protected String insuranceName;
	protected String insuranceDetails;
	protected Date coverageStartDate;
	protected Date coverageEndDate;
	protected int coverageAmount;
	protected String coverageCurrency;
	protected int insuranceProvider;
	protected int adults;
	protected int children;
	protected int infant;
	
	protected int premiumCost;
	protected int premiumMarkup;
	protected int countryId;
	
	protected int displayOrder;
	protected boolean active;
	protected String remarks;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	public Udn_Manual_Insurance_Quotation_Entity() {}
	
	public Udn_Manual_Insurance_Quotation_Entity(ManualInsuranceQuotationVO manualInsVO) {
		this.manualInsuranceQuotationId=manualInsVO.getManualInsuranceQuotationId();
		this.insuranceName=manualInsVO.getInsuranceName();
		this.insuranceDetails=manualInsVO.getInsuranceDetails();
		this.coverageStartDate=manualInsVO.getCoverageStartDate();
		this.coverageEndDate=manualInsVO.getCoverageEndDate();
		this.coverageAmount=manualInsVO.getCoverageAmount();
		this.coverageCurrency=manualInsVO.getCoverageCurrency();
		this.countryId = manualInsVO.getCountryId();
		this.adults=manualInsVO.getAdults();
		this.children=manualInsVO.getChildren();
		this.infant=manualInsVO.getInfant();
		this.premiumCost=manualInsVO.getPremiumCost();
		this.premiumMarkup=manualInsVO.getPremiumMarkup();
		this.displayOrder=manualInsVO.getDisplayOrder();
		this.active=manualInsVO.isActive();
		this.insuranceProvider = manualInsVO.getInsuranceProvider();
		this.remarks=manualInsVO.getRemarks();
	}

	public long getManualInsuranceQuotationId() {
		return manualInsuranceQuotationId;
	}

	public void setManualInsuranceQuotationId(long manualInsuranceQuotationId) {
		this.manualInsuranceQuotationId = manualInsuranceQuotationId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceDetails() {
		return insuranceDetails;
	}

	public void setInsuranceDetails(String insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}

	public Date getCoverageStartDate() {
		return coverageStartDate;
	}

	public void setCoverageStartDate(Date coverageStartDate) {
		this.coverageStartDate = coverageStartDate;
	}

	public Date getCoverageEndDate() {
		return coverageEndDate;
	}

	public void setCoverageEndDate(Date coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}

	public int getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(int coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public String getCoverageCurrency() {
		return coverageCurrency;
	}

	public void setCoverageCurrency(String coverageCurrency) {
		this.coverageCurrency = coverageCurrency;
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

	public int getPremiumCost() {
		return premiumCost;
	}

	public void setPremiumCost(int premiumCost) {
		this.premiumCost = premiumCost;
	}

	public int getPremiumMarkup() {
		return premiumMarkup;
	}

	public void setPremiumMarkup(int premiumMarkup) {
		this.premiumMarkup = premiumMarkup;
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

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(int insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}




	

}
