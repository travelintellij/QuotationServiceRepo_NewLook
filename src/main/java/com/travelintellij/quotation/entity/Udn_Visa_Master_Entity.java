package com.travelintellij.quotation.entity;

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

import com.travelintellij.quotation.dto.Udn_Visa_Master_Obj;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "udn_visa_master")
public class Udn_Visa_Master_Entity extends AuditModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visaId;
	private String countryCode;
	private String otherCosts;
	private String internalRemarks;
	private int consulateCity;
	private int profile;
	private int visaType;
	private int visaPurpose;
	private int processingTime;
	private int standardCost;
	private int standardB2bPrice;
	private int standardB2cPrice;
	private String remarks;
	private boolean active;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "visaId")
	@JsonBackReference
	@OrderBy("visaDocId ASC")
    private Set<Udn_Visa_Doc_Map_Entity> visaDocumentEntityList = new HashSet<Udn_Visa_Doc_Map_Entity>();
	
	public Udn_Visa_Master_Entity() {}
	


	public Udn_Visa_Master_Entity(@Valid Udn_Visa_Master_Obj visaObj) {
		this.visaId=visaObj.getVisaId();
		this.countryCode=visaObj.getCountryCode();
		this.consulateCity=visaObj.getConsulateCity();
		this.otherCosts = visaObj.getOtherCosts();
		this.internalRemarks = visaObj.getInternalRemarks();
		this.profile=visaObj.getProfile();
		this.visaType=visaObj.getVisaType();
		this.visaPurpose=visaObj.getVisaPurpose();
		this.processingTime=visaObj.getProcessingTime();
		this.standardCost=visaObj.getStandardCost();
		this.standardB2bPrice=visaObj.getStandardB2bPrice();
		this.standardB2cPrice=visaObj.getStandardB2cPrice();
		this.remarks=visaObj.getRemarks();
		this.active=visaObj.isActive();
		this.visaDocumentEntityList=visaObj.getVisaDocumentEntityList();

	}
	
	  public String toString() {
	    	String attrib = "Displaying Visa Entity Obj: \n";
			attrib = attrib +" visaId -> " + visaId + "\n";
			attrib = attrib +" countryCode-> " +countryCode + "\n";
			attrib = attrib +" consulateCity-> " +consulateCity + "\n";
			attrib = attrib +" profile-> " + profile+ "\n";
			attrib = attrib +" visaType -> " + visaType+ "\n";
			attrib = attrib +" visaPurpose -> " + visaPurpose+ "\n";
			attrib = attrib +" processingTime-> " +processingTime + "\n";
			attrib = attrib +" standardCost -> " +standardCost + "\n";
			attrib = attrib +" standardCost -> " +standardCost + "\n";
			attrib = attrib +" standardB2bPrice -> " +standardB2bPrice + "\n";
			attrib = attrib +" standardB2cPrice -> " +standardB2cPrice + "\n";
			attrib = attrib +" remarks -> " +remarks + "\n";
			attrib = attrib +" otherCosts -> " +otherCosts+ "\n";
			attrib = attrib +" Internal Remarks -> " +internalRemarks+ "\n";
			attrib = attrib +" active -> " +active + "\n";
			//attrib = attrib +" visaDocumentEntityList -> " +visaDocumentEntityList + "\n";
			
			return attrib;
	}

	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}
	public int getStandardCost() {
		return standardCost;
	}
	public void setStandardCost(int standardCost) {
		this.standardCost = standardCost;
	}
	public int getStandardB2bPrice() {
		return standardB2bPrice;
	}
	public void setStandardB2bPrice(int standardB2bPrice) {
		this.standardB2bPrice = standardB2bPrice;
	}
	public int getStandardB2cPrice() {
		return standardB2cPrice;
	}
	public void setStandardB2cPrice(int standardB2cPrice) {
		this.standardB2cPrice = standardB2cPrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<Udn_Visa_Doc_Map_Entity> getVisaDocumentEntityList() {
		return visaDocumentEntityList;
	}
	public void setVisaDocumentEntityList(Set<Udn_Visa_Doc_Map_Entity> visaDocumentEntityList) {
		this.visaDocumentEntityList = visaDocumentEntityList;
	}



	public int getVisaId() {
		return visaId;
	}



	public void setVisaId(int visaId) {
		this.visaId = visaId;
	}



	public int getProfile() {
		return profile;
	}



	public void setProfile(int profile) {
		this.profile = profile;
	}



	public int getVisaType() {
		return visaType;
	}



	public void setVisaType(int visaType) {
		this.visaType = visaType;
	}



	public int getVisaPurpose() {
		return visaPurpose;
	}



	public void setVisaPurpose(int visaPurpose) {
		this.visaPurpose = visaPurpose;
	}



	public int getConsulateCity() {
		return consulateCity;
	}



	public void setConsulateCity(int consulateCity) {
		this.consulateCity = consulateCity;
	}



	public String getOtherCosts() {
		return otherCosts;
	}



	public void setOtherCosts(String otherCosts) {
		this.otherCosts = otherCosts;
	}



	public String getInternalRemarks() {
		return internalRemarks;
	}



	public void setInternalRemarks(String internalRemarks) {
		this.internalRemarks = internalRemarks;
	}

	

}