package com.travelintellij.quotation.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.travelintellij.request.entity.Tg_Leads_Recorder_Entity;
import com.travelintellij.quotation.dto.TgQuotationRecorderVO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tg_quotations_recorder")
public class Tg_Quotation_Recorder_Entity extends AuditModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long quotationId;
	
	
	//@Version
	protected int version;
	
	protected String quotationName;
	protected long createdBy;
	protected long lastUpdatedBy;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="leadId", nullable=false)
	@JsonManagedReference
    protected Tg_Leads_Recorder_Entity leadEntity;
	
	protected boolean tourPackage;
	
	protected boolean flight;
	protected boolean hotel;
	protected boolean transfers;
	protected boolean sightseeing;
	protected boolean visa;
	protected boolean insurance;
	protected boolean cruise;
	protected boolean others;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Flight_Quotation_Entity> manualQuotationsList = new HashSet<Udn_Manual_Flight_Quotation_Entity>();
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Hotel_Quotation_Entity> hotelQuotationsList = new HashSet<Udn_Manual_Hotel_Quotation_Entity>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Transfer_Quotation_Entity> transferQuotationList = new HashSet<Udn_Manual_Transfer_Quotation_Entity>();
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_SightSeeing_Quotation_Entity> sightSeeingQuotationList = new HashSet<Udn_Manual_SightSeeing_Quotation_Entity>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Visa_Quotation_Entity> visaQuotationList = new HashSet<Udn_Manual_Visa_Quotation_Entity>();

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Package_Quotation_Entity> packageQuotationsList = new HashSet<Udn_Manual_Package_Quotation_Entity>();

	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Other_Quotation_Entity> otherQuotationsList = new HashSet<Udn_Manual_Other_Quotation_Entity>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Insurance_Quotation_Entity> insuranceQuotationsList = new HashSet<Udn_Manual_Insurance_Quotation_Entity>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "quotationEntity")
	@OrderBy("displayOrder")
	@JsonBackReference
	protected Set<Udn_Manual_Cruise_Quotation_Entity> cruiseQuotationsList = new HashSet<Udn_Manual_Cruise_Quotation_Entity>();
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "quotationEntity")
    private Udn_Configuration_Manual_Quotation_Entity configurationQuotationEntity;
	
	
	
	public Tg_Quotation_Recorder_Entity() {}

	public Tg_Quotation_Recorder_Entity(TgQuotationRecorderVO tgQuotationVo) {
		this.quotationId = tgQuotationVo.getQuotationId();
		this.tourPackage=tgQuotationVo.isTourPackage();
		this.flight=tgQuotationVo.isFlight();
		this.hotel=tgQuotationVo.isHotel();
		this.transfers=tgQuotationVo.isTransfers();
		this.sightseeing=tgQuotationVo.isSightseeing();
		this.visa=tgQuotationVo.isVisa();
		this.insurance=tgQuotationVo.isInsurance();
		this.cruise=tgQuotationVo.isCruise();
		this.others=tgQuotationVo.isOthers();
		this.version=tgQuotationVo.getVersion();
		this.quotationName=tgQuotationVo.getQuotationName();
		this.createdBy=tgQuotationVo.getCreatedBy();
		this.lastUpdatedBy=tgQuotationVo.getLastUpdatedBy();
		
	}

	
	public long getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getQuotationName() {
		return quotationName;
	}
	public void setQuotationName(String quotationName) {
		this.quotationName = quotationName;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
	public Tg_Leads_Recorder_Entity getLeadEntity() {
		return leadEntity;
	}
	public void setLeadEntity(Tg_Leads_Recorder_Entity leadEntity) {
		this.leadEntity = leadEntity;
	}
	@Override
	public String toString() {
		return "Tg_Quotation_Recorder_Entity [quotationId=" + quotationId + ", version=" + version + ", quotationName="
				+ quotationName + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy + ", leadEntity="
				+ leadEntity + "]";
	}
	
	
	
	
	public boolean isTourPackage() {
		return tourPackage;
	}

	public void setTourPackage(boolean tourPackage) {
		this.tourPackage = tourPackage;
	}

	public boolean isFlight() {
		return flight;
	}
	public void setFlight(boolean flight) {
		this.flight = flight;
	}
	public boolean isHotel() {
		return hotel;
	}
	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}
	public boolean isTransfers() {
		return transfers;
	}
	public void setTransfers(boolean transfers) {
		this.transfers = transfers;
	}
	public boolean isSightseeing() {
		return sightseeing;
	}
	public void setSightseeing(boolean sightseeing) {
		this.sightseeing = sightseeing;
	}
	public boolean isVisa() {
		return visa;
	}
	public void setVisa(boolean visa) {
		this.visa = visa;
	}
	public boolean isInsurance() {
		return insurance;
	}
	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	public boolean isCruise() {
		return cruise;
	}
	public void setCruise(boolean cruise) {
		this.cruise = cruise;
	}
	public boolean isOthers() {
		return others;
	}
	public void setOthers(boolean others) {
		this.others = others;
	}


	public Set<Udn_Manual_Flight_Quotation_Entity> getManualQuotationsList() {
		return manualQuotationsList;
	}


	public void setManualQuotationsList(Set<Udn_Manual_Flight_Quotation_Entity> manualQuotationsList) {
		this.manualQuotationsList = manualQuotationsList;
	}

	public Set<Udn_Manual_Hotel_Quotation_Entity> getHotelQuotationsList() {
		return hotelQuotationsList;
	}

	public void setHotelQuotationsList(Set<Udn_Manual_Hotel_Quotation_Entity> hotelQuotationsList) {
		this.hotelQuotationsList = hotelQuotationsList;
	}

	public Set<Udn_Manual_Transfer_Quotation_Entity> getTransferQuotationList() {
		return transferQuotationList;
	}

	public void setTransferQuotationList(Set<Udn_Manual_Transfer_Quotation_Entity> transferQuotationList) {
		this.transferQuotationList = transferQuotationList;
	}

	public Set<Udn_Manual_SightSeeing_Quotation_Entity> getSightSeeingQuotationList() {
		return sightSeeingQuotationList;
	}

	public void setSightSeeingQuotationList(Set<Udn_Manual_SightSeeing_Quotation_Entity> sightSeeingQuotationList) {
		this.sightSeeingQuotationList = sightSeeingQuotationList;
	}

	public Set<Udn_Manual_Visa_Quotation_Entity> getVisaQuotationList() {
		return visaQuotationList;
	}

	public void setVisaQuotationList(Set<Udn_Manual_Visa_Quotation_Entity> visaQuotationList) {
		this.visaQuotationList = visaQuotationList;
	}

	public Set<Udn_Manual_Package_Quotation_Entity> getPackageQuotationsList() {
		return packageQuotationsList;
	}

	public void setPackageQuotationsList(Set<Udn_Manual_Package_Quotation_Entity> packageQuotationsList) {
		this.packageQuotationsList = packageQuotationsList;
	}

	public Set<Udn_Manual_Other_Quotation_Entity> getOtherQuotationsList() {
		return otherQuotationsList;
	}

	public void setOtherQuotationsList(Set<Udn_Manual_Other_Quotation_Entity> otherQuotationsList) {
		this.otherQuotationsList = otherQuotationsList;
	}

	public Set<Udn_Manual_Insurance_Quotation_Entity> getInsuranceQuotationsList() {
		return insuranceQuotationsList;
	}

	public void setInsuranceQuotationsList(Set<Udn_Manual_Insurance_Quotation_Entity> insuranceQuotationsList) {
		this.insuranceQuotationsList = insuranceQuotationsList;
	}

	public Set<Udn_Manual_Cruise_Quotation_Entity> getCruiseQuotationsList() {
		return cruiseQuotationsList;
	}

	public void setCruiseQuotationsList(Set<Udn_Manual_Cruise_Quotation_Entity> cruiseQuotationsList) {
		this.cruiseQuotationsList = cruiseQuotationsList;
	}

	public Udn_Configuration_Manual_Quotation_Entity getConfigurationQuotationEntity() {
		return configurationQuotationEntity;
	}

	public void setConfigurationQuotationEntity(Udn_Configuration_Manual_Quotation_Entity configurationQuotationEntity) {
		this.configurationQuotationEntity = configurationQuotationEntity;
	}
	
	
	
}