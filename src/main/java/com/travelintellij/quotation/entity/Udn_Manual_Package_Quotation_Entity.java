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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ManualPackageQuotationVO;

@Entity
@Table(name = "udn_pkg_manual_quotation")
public class Udn_Manual_Package_Quotation_Entity extends AuditModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualPkgQuotationId;

	protected int cityId;
	protected int adults;
	protected int children;
	protected int infant;
	protected int pkgCost; 
	protected int pkgMarkup;
	protected String packageName; 
	protected String packageDescription;
	protected String cancellationPolicy; 
	protected Date startDate;
	protected Date endDate; 
	protected int displayOrder;
	protected boolean active;
	protected boolean flightIncluded;
	protected String inclusions;
	protected String exclusions;
	protected String remarks;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
    protected Tg_Quotation_Recorder_Entity quotationEntity;

	public Udn_Manual_Package_Quotation_Entity() {}
	
	public Udn_Manual_Package_Quotation_Entity(ManualPackageQuotationVO manualPkgVO) {
		this.manualPkgQuotationId = manualPkgVO.getManualPkgQuotationId();
		this.adults = manualPkgVO.getAdults();
		this.children = manualPkgVO.getChildren();
		this.infant = manualPkgVO.getInfant();
		this.packageName = manualPkgVO.getPackageName();
		this.startDate = manualPkgVO.getStartDate();
		this.endDate=manualPkgVO.getEndDate();
		this.remarks = manualPkgVO.getRemarks();
		this.pkgCost = manualPkgVO.getPkgCost();
		this.pkgMarkup = manualPkgVO.getPkgMarkup();
		this.packageDescription = manualPkgVO.getPackageDescription();
		this.inclusions=manualPkgVO.getInclusions();
		this.exclusions=manualPkgVO.getExclusions();
		this.cancellationPolicy = manualPkgVO.getCancellationPolicy();
		this.displayOrder = manualPkgVO.getDisplayOrder();
		this.flightIncluded=manualPkgVO.isFlightIncluded();
		this.cityId = manualPkgVO.getCityId();
		this.active = manualPkgVO.isActive();
	}




	public long getManualPkgQuotationId() {
		return manualPkgQuotationId;
	}




	public void setManualPkgQuotationId(long manualPkgQuotationId) {
		this.manualPkgQuotationId = manualPkgQuotationId;
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




	public int getPkgCost() {
		return pkgCost;
	}




	public void setPkgCost(int pkgCost) {
		this.pkgCost = pkgCost;
	}




	public int getPkgMarkup() {
		return pkgMarkup;
	}




	public void setPkgMarkup(int pkgMarkup) {
		this.pkgMarkup = pkgMarkup;
	}




	public String getPackageName() {
		return packageName;
	}




	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}




	public String getPackageDescription() {
		return packageDescription;
	}




	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}




	public String getCancellationPolicy() {
		return cancellationPolicy;
	}




	public void setCancellationPolicy(String cancellationPolicy) {
		this.cancellationPolicy = cancellationPolicy;
	}




	public Date getStartDate() {
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getEndDate() {
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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




	public int getCityId() {
		return cityId;
	}




	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public boolean isFlightIncluded() {
		return flightIncluded;
	}

	public void setFlightIncluded(boolean flightIncluded) {
		this.flightIncluded = flightIncluded;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInclusions() {
		return inclusions;
	}

	public void setInclusions(String inclusions) {
		this.inclusions = inclusions;
	}

	public String getExclusions() {
		return exclusions;
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}
	
	

}
