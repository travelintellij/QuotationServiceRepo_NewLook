package com.travelintellij.quotation.entity;

import java.sql.Date;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.travelintellij.quotation.dto.TgLeadsRecorderVO;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tg_leads_recorder")
public class Tg_Leads_Recorder_Entity extends AuditModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long leadId;

	protected long contactId;
	protected int leadSource;
	protected int adults;
	protected int children;
	protected int tentativeCost;
	protected String clientRemarks;
	protected String internalRemarks;
	protected String childrenAgeInfo;
	protected int source;
	
	protected boolean landPackage;
	//protected boolean packageWithFlight;
	//protected boolean packageWithoutFlight;
	protected boolean flight;
	protected boolean hotel;
	protected boolean transfers;
	protected boolean sightseeing;
	protected boolean visa;
	protected boolean insurance;
	protected boolean cruise;
	protected boolean others;
	protected boolean leadCreationClientInformed;
 
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "leadEntity")
	@OrderBy("updated_at DESC")
	@JsonBackReference
	protected Set<Tg_Quotation_Recorder_Entity> leadQuotationsList = new HashSet<Tg_Quotation_Recorder_Entity>();
	
	
	
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}

	protected int destination;
	protected Date travelStartDate;
	protected Date travelEndDate;
	protected int leadStatus;
	protected int resultReason;
	protected boolean	isQualified = true;
	protected boolean isFlagged;
	protected int leadOwner;
	
	public Long getLeadId() {
		return leadId;
	}
	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public int getLeadSource() {
		return leadSource;
	}
	public void setLeadSource(int leadSource) {
		this.leadSource = leadSource;
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
	public int getTentativeCost() {
		return tentativeCost;
	}
	public void setTentativeCost(int tentativeCost) {
		this.tentativeCost = tentativeCost;
	}

	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public Date getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(Date travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public Date getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(Date travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public int getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(int leadStatus) {
		this.leadStatus = leadStatus;
	}
	public int getResultReason() {
		return resultReason;
	}
	public void setResultReason(int resultReason) {
		this.resultReason = resultReason;
	}
	public boolean isQualified() {
		return isQualified;
	}
	public void setQualified(boolean isQualified) {
		this.isQualified = isQualified;
	}
	public boolean isFlagged() {
		return isFlagged;
	}
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}
	public int getLeadOwner() {
		return leadOwner;
	}
	public void setLeadOwner(int leadOwner) {
		this.leadOwner = leadOwner;
	}
	
	
	public Tg_Leads_Recorder_Entity() {

	}
	
	public Tg_Leads_Recorder_Entity(TgLeadsRecorderVO leadsRecorderVo) {
		this.leadId=leadsRecorderVo.getLeadId();

		this.contactId=leadsRecorderVo.getContactId();
		this.leadSource=leadsRecorderVo.getLeadSource();
		this.adults=leadsRecorderVo.getAdults();
		this.children=leadsRecorderVo.getChildren();
		this.tentativeCost=leadsRecorderVo.getTentativeCost();
		this.clientRemarks=leadsRecorderVo.getClientRemarks();
		this.internalRemarks=leadsRecorderVo.getInternalRemarks();
		this.childrenAgeInfo=leadsRecorderVo.getChildrenAgeInfo();
		this.source=leadsRecorderVo.getSource();
		//this.packageWithFlight=leadsRecorderVo.isPackageWithFlight();
		//this.packageWithoutFlight=leadsRecorderVo.isPackageWithoutFlight();
		this.landPackage =leadsRecorderVo.isLandPackage()  ;
		this.flight=leadsRecorderVo.isFlight();
		this.hotel=leadsRecorderVo.isHotel();
		this.transfers=leadsRecorderVo.isTransfers();
		this.sightseeing=leadsRecorderVo.isSightseeing();
		this.visa=leadsRecorderVo.isVisa();
		this.insurance=leadsRecorderVo.isInsurance();
		this.cruise=leadsRecorderVo.isCruise();
		this.others=leadsRecorderVo.isOthers();
		this.leadCreationClientInformed=leadsRecorderVo.isLeadCreationClientInformed();
		this.destination=leadsRecorderVo.getDestination();
		this.travelStartDate=leadsRecorderVo.getTravelStartDate();
		this.travelEndDate=leadsRecorderVo.getTravelEndDate();
		this.leadStatus=leadsRecorderVo.getLeadStatus();
		this.resultReason=leadsRecorderVo.getResultReason();
		this.isQualified=leadsRecorderVo.isQualified();
		this.isFlagged=leadsRecorderVo.isFlagged();
		this.leadOwner=leadsRecorderVo.getLeadOwner();
	}
	
	public String getClientRemarks() {
		return clientRemarks;
	}
	public void setClientRemarks(String clientRemarks) {
		this.clientRemarks = clientRemarks;
	}
	public String getInternalRemarks() {
		return internalRemarks;
	}
	public void setInternalRemarks(String internalRemarks) {
		this.internalRemarks = internalRemarks;
	}
	
	
	/*public boolean isPackageWithFlight() {
		return packageWithFlight;
	}
	public void setPackageWithFlight(boolean packageWithFlight) {
		this.packageWithFlight = packageWithFlight;
	}
	public boolean isPackageWithoutFlight() {
		return packageWithoutFlight;
	}
	public void setPackageWithoutFlight(boolean packageWithoutFlight) {
		this.packageWithoutFlight = packageWithoutFlight;
	}
	*/
	
	public boolean isFlight() {
		return flight;
	}
	public boolean isLandPackage() {
		return landPackage;
	}
	public void setLandPackage(boolean landPackage) {
		this.landPackage = landPackage;
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
	public boolean isLeadCreationClientInformed() {
		return leadCreationClientInformed;
	}
	public void setLeadCreationClientInformed(boolean leadCreationClientInformed) {
		this.leadCreationClientInformed = leadCreationClientInformed;
	}
	
	public String getChildrenAgeInfo() {
		return childrenAgeInfo;
	}
	public void setChildrenAgeInfo(String childrenAgeInfo) {
		this.childrenAgeInfo = childrenAgeInfo;
	}
	
	
	public Set<Tg_Quotation_Recorder_Entity> getLeadQuotationsList() {
		return leadQuotationsList;
	}
	
	public void setLeadQuotationsList(Set<Tg_Quotation_Recorder_Entity> leadQuotationsList) {
		this.leadQuotationsList = leadQuotationsList;
	}
	
	public String toString(){
		String attrib = "Displaying Lead Details : " ; 
		attrib = attrib + "leadId " + leadId + " \n ";
		attrib = attrib + "contactId " + contactId + " \n ";
		attrib = attrib + "leadSource " + leadSource + " \n ";
		attrib = attrib + " adults " + adults + " \n ";
		attrib = attrib + "children " + children + " \n ";
		attrib = attrib + "tentativeCost " + tentativeCost + " \n ";
		attrib = attrib + "Client Remarks " + clientRemarks + " \n ";
		attrib = attrib + "Internal Remarks " + internalRemarks + " \n ";
		attrib = attrib + "destination " + destination + " \n ";
		attrib = attrib + "travelStartDate " + travelStartDate + " \n ";
		attrib = attrib + "travelEndDate " + travelEndDate + " \n ";
		attrib = attrib + "leadStatus " + leadStatus + " \n ";
		attrib = attrib + "resultReason " + resultReason + " \n ";
		attrib = attrib + "isQualified " + isQualified + " \n ";
		attrib = attrib + "isFlagged " + isFlagged + " \n ";
		attrib = attrib + "leadOwner " + leadOwner + " \n ";
		attrib = attrib + "Package " + landPackage + " \n ";
		
		attrib = attrib + "flight " + flight + " \n ";
		attrib = attrib + "hotel " + hotel + " \n ";
		attrib = attrib + "transfers " + transfers + " \n ";
		attrib = attrib + "sightseeing " + sightseeing + " \n ";
		attrib = attrib + "visa " + visa + " \n ";
		attrib = attrib + "insurance " + insurance + " \n ";
		attrib = attrib + "cruise " + cruise + " \n ";
		attrib = attrib + "leadCreationClientInformed " + leadCreationClientInformed + " \n ";
		
		return attrib;
	
	}
	   
	
	
}
