package com.travelintellij.quotation.dto;


import com.travelintellij.quotation.entity.Tg_Leads_Recorder_Entity;

public class TgLeadsRecorderVO extends Tg_Leads_Recorder_Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contactName;
	private String sourceName;
	private String destinationName;
	private String minOneserviceError;
	private String statusName;
	private String leadSourceShortName;
	private String leadSourceName;
	private boolean notifyAgain=false;
	private String leadOwnerName;
	
 	public TgLeadsRecorderVO() {

	}
	
 	public void updateLeadVoFromEntity(Tg_Leads_Recorder_Entity tgLeadEntity) {
		this.leadId=tgLeadEntity.getLeadId();
		this.contactId=tgLeadEntity.getContactId();
		this.leadSource=tgLeadEntity.getLeadSource();
		this.adults=tgLeadEntity.getAdults();
		this.children=tgLeadEntity.getChildren();
		this.tentativeCost=tgLeadEntity.getTentativeCost();
		this.clientRemarks=tgLeadEntity.getClientRemarks();
		this.internalRemarks=tgLeadEntity.getInternalRemarks();
		this.childrenAgeInfo=tgLeadEntity.getChildrenAgeInfo();
		this.source=tgLeadEntity.getSource();
		
		this.landPackage=tgLeadEntity.isLandPackage();
		/*
		this.packageWithFlight=tgLeadEntity.isPackageWithFlight();
		this.packageWithoutFlight=tgLeadEntity.isPackageWithoutFlight();
		*/
		
		this.flight=tgLeadEntity.isFlight();
		this.hotel=tgLeadEntity.isHotel();
		this.transfers=tgLeadEntity.isTransfers();
		this.sightseeing=tgLeadEntity.isSightseeing();
		this.visa=tgLeadEntity.isVisa();
		this.insurance=tgLeadEntity.isInsurance();
		this.cruise=tgLeadEntity.isCruise();
		this.others = tgLeadEntity.isOthers();
		this.leadCreationClientInformed=tgLeadEntity.isLeadCreationClientInformed();
		this.destination=tgLeadEntity.getDestination();
		this.travelStartDate=tgLeadEntity.getTravelStartDate();
		this.travelEndDate=tgLeadEntity.getTravelEndDate();
		this.leadStatus=tgLeadEntity.getLeadStatus();
		this.resultReason=tgLeadEntity.getResultReason();
		this.isQualified=tgLeadEntity.isQualified();
		this.isFlagged=tgLeadEntity.isFlagged();
		this.leadOwner=tgLeadEntity.getLeadOwner();
		this.leadQuotationsList =tgLeadEntity.getLeadQuotationsList();
		this.setCreatedAt(tgLeadEntity.getCreatedAt());
	}
 	
	public TgLeadsRecorderVO(Tg_Leads_Recorder_Entity tgLeadEntity) {
		this.leadId=tgLeadEntity.getLeadId();
		this.contactId=tgLeadEntity.getContactId();
		this.leadSource=tgLeadEntity.getLeadSource();
		this.adults=tgLeadEntity.getAdults();
		this.children=tgLeadEntity.getChildren();
		this.tentativeCost=tgLeadEntity.getTentativeCost();
		this.clientRemarks=tgLeadEntity.getClientRemarks();
		this.internalRemarks=tgLeadEntity.getInternalRemarks();
		this.childrenAgeInfo=tgLeadEntity.getChildrenAgeInfo();
		this.source=tgLeadEntity.getSource();
		
		this.landPackage=tgLeadEntity.isLandPackage();
		/*
		this.packageWithFlight=tgLeadEntity.isPackageWithFlight();
		this.packageWithoutFlight=tgLeadEntity.isPackageWithoutFlight();
		*/
		
		this.flight=tgLeadEntity.isFlight();
		this.hotel=tgLeadEntity.isHotel();
		this.transfers=tgLeadEntity.isTransfers();
		this.sightseeing=tgLeadEntity.isSightseeing();
		this.visa=tgLeadEntity.isVisa();
		this.insurance=tgLeadEntity.isInsurance();
		this.cruise=tgLeadEntity.isCruise();
		this.others = tgLeadEntity.isOthers();
		this.leadCreationClientInformed=tgLeadEntity.isLeadCreationClientInformed();
		this.destination=tgLeadEntity.getDestination();
		this.travelStartDate=tgLeadEntity.getTravelStartDate();
		this.travelEndDate=tgLeadEntity.getTravelEndDate();
		this.leadStatus=tgLeadEntity.getLeadStatus();
		this.resultReason=tgLeadEntity.getResultReason();
		this.isQualified=tgLeadEntity.isQualified();
		this.isFlagged=tgLeadEntity.isFlagged();
		this.leadOwner=tgLeadEntity.getLeadOwner();
		this.leadQuotationsList =tgLeadEntity.getLeadQuotationsList(); 
		setCreatedAt(tgLeadEntity.getCreatedAt());
	}


	public String toString(){
		System.out.println(super.toString());
		String attrib = "LeadId :  " + leadId + ": Contact Name: " + contactName +"\n";
		attrib = attrib + "Source Name:  " + sourceName +"\n";
		attrib = attrib + "Destination Name:  " + destinationName +"\n";
		return attrib;
	
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getSourceName() {
		return sourceName;
	}


	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}


	public String getDestinationName() {
		return destinationName;
	}


	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}


	public String getMinOneserviceError() {
		return minOneserviceError;
	}


	public void setMinOneserviceError(String minOneserviceError) {
		this.minOneserviceError = minOneserviceError;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}



	public String getLeadSourceShortName() {
		return leadSourceShortName;
	}



	public void setLeadSourceShortName(String leadSourceShortName) {
		this.leadSourceShortName = leadSourceShortName;
	}



	public String getLeadSourceName() {
		return leadSourceName;
	}



	public void setLeadSourceName(String leadSourceName) {
		this.leadSourceName = leadSourceName;
	}

	public boolean isNotifyAgain() {
		return notifyAgain;
	}

	public void setNotifyAgain(boolean notifyAgain) {
		this.notifyAgain = notifyAgain;
	}

	public String getLeadOwnerName() {
		return leadOwnerName;
	}

	public void setLeadOwnerName(String leadOwnerName) {
		this.leadOwnerName = leadOwnerName;
	}
	   
	
	
}
