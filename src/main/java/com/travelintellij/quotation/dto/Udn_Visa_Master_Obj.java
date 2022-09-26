package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Visa_Doc_Map_Entity;
import com.travelintellij.quotation.entity.Udn_Visa_Master_Entity;

import java.util.HashSet;
import java.util.Set;


public class Udn_Visa_Master_Obj {
	
	private int visaId;
	private String countryCode;
	private int consulateCity;
	private String otherCosts;
	private String internalRemarks;
	private int profile;
	private int visaType;
	private int visaPurpose;
	private int processingTime;
	private int standardCost;
	private int standardB2bPrice;
	private int standardB2cPrice;
	private String remarks;
	private boolean active = true;
    private Set<Udn_Visa_Doc_Map_Entity> visaDocumentEntityList = new HashSet<Udn_Visa_Doc_Map_Entity>();
	
    
    private String countryName;
    private String cityName;
    
    private String profileString;
    private String visaTypeString;
    private String visaPurposeString;
    
    
    public Udn_Visa_Master_Obj() {}
    
    public Udn_Visa_Master_Obj(Udn_Visa_Master_Entity visaEntity) {
    	this.visaId=visaEntity.getVisaId();
    	this.countryCode=visaEntity.getCountryCode();
    	this.consulateCity = visaEntity.getConsulateCity();
    	this.otherCosts = visaEntity.getOtherCosts();
    	this.internalRemarks = visaEntity.getInternalRemarks();
    	this.profile=visaEntity.getProfile();
    	this.visaType=visaEntity.getVisaType();
    	this.visaPurpose=visaEntity.getVisaPurpose();
    	this.processingTime=visaEntity.getProcessingTime();
    	this.standardCost=visaEntity.getStandardCost();
    	this.standardB2bPrice=visaEntity.getStandardB2bPrice();
    	this.standardB2cPrice=visaEntity.getStandardB2cPrice();
    	this.remarks=visaEntity.getRemarks();
    	this.active=visaEntity.isActive();
    	this.visaDocumentEntityList=visaEntity.getVisaDocumentEntityList();
    }
    
    public void updateVisaVoFromEntity(Udn_Visa_Master_Entity visaEntity) {
    	this.visaId=visaEntity.getVisaId();
    	this.countryCode=visaEntity.getCountryCode();
    	this.consulateCity = visaEntity.getConsulateCity();
    	this.otherCosts = visaEntity.getOtherCosts();
    	this.internalRemarks = visaEntity.getInternalRemarks();
    	this.profile=visaEntity.getProfile();
    	this.visaType=visaEntity.getVisaType();
    	this.visaPurpose=visaEntity.getVisaPurpose();
    	this.processingTime=visaEntity.getProcessingTime();
    	this.standardCost=visaEntity.getStandardCost();
    	this.standardB2bPrice=visaEntity.getStandardB2bPrice();
    	this.standardB2cPrice=visaEntity.getStandardB2cPrice();
    	this.remarks=visaEntity.getRemarks();
    	this.active=visaEntity.isActive();
    	this.visaDocumentEntityList=visaEntity.getVisaDocumentEntityList();
    	
    }
    
    public String toString() {
    	String attrib = "Displaying Visa Master Obj: \n";
		attrib = attrib +" visaId -> " + visaId + "\n";
		attrib = attrib +" countryCode-> " +countryCode + "\n";
		attrib = attrib +" Other Costs -> " +otherCosts+ "\n";
		attrib = attrib +" InternalRemarks -> " +internalRemarks+ "\n";
		attrib = attrib +" consulateCity-> " +consulateCity + "\n";
		attrib = attrib +" countryName-> " +countryName + "\n";
		attrib = attrib +" profile-> " + profile+ "\n";
		attrib = attrib +" visaType -> " + visaType+ "\n";
		attrib = attrib +" visaPurpose -> " + visaPurpose+ "\n";
		attrib = attrib +" processingTime-> " +processingTime + "\n";
		attrib = attrib +" standardCost -> " +standardCost + "\n";
		attrib = attrib +" standardB2bPrice -> " +standardB2bPrice + "\n";
		attrib = attrib +" standardB2cPrice -> " +standardB2cPrice + "\n";
		attrib = attrib +" remarks -> " +remarks + "\n";
		attrib = attrib +" active -> " +active + "\n";
		attrib = attrib +" visaDocumentEntityList -> " +visaDocumentEntityList + "\n";
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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public String getProfileString() {
		return profileString;
	}

	public void setProfileString(String profileString) {
		this.profileString = profileString;
	}

	public String getVisaTypeString() {
		return visaTypeString;
	}

	public void setVisaTypeString(String visaTypeString) {
		this.visaTypeString = visaTypeString;
	}

	public String getVisaPurposeString() {
		return visaPurposeString;
	}

	public void setVisaPurposeString(String visaPurposeString) {
		this.visaPurposeString = visaPurposeString;
	}

	    
    
    
    
}