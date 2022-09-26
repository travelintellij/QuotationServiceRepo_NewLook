package com.travelintellij.quotation.dto;

import java.util.Map;

import com.travelintellij.quotation.entity.Udn_Configuration_Manual_Quotation_Entity;


public class ConfigurationQuotationVO extends Udn_Configuration_Manual_Quotation_Entity {


	private String partnerName;
	public void updateConfigurationVoFromEntity(Udn_Configuration_Manual_Quotation_Entity configurationEntity) {
		this.manualConfigurationQuotationId = configurationEntity.getManualConfigurationQuotationId();
		this.partnerId = configurationEntity.getPartnerId();
		this.flightShowConnections = configurationEntity.isFlightShowConnections();
		this.flightSeperateCostDisplay = configurationEntity.isFlightSeperateCostDisplay();
		this.flightGstBreakup = configurationEntity.isFlightGstBreakup();
		this.flightCancellationPolicyDisplay = configurationEntity.isFlightCancellationPolicyDisplay();
		this.flightCancellationPolicy = configurationEntity.getFlightCancellationPolicy();
		this.hotelSeperateCostDisplay = configurationEntity.isHotelSeperateCostDisplay();
		this.hotelGstBreakup = configurationEntity.isHotelGstBreakup();
		this.hotelCancellationPolicyDisplay = configurationEntity.isHotelCancellationPolicyDisplay();
		this.hotelCancellationPolicy = configurationEntity.getHotelCancellationPolicy();
		this.transfersSeperateCostDisplay = configurationEntity.isTransfersSeperateCostDisplay();
		this.transfersGstBreakup = configurationEntity.isTransfersGstBreakup();
		this.transfersCancellationPolicyDisplay = configurationEntity.isTransfersCancellationPolicyDisplay();
		this.transfersCancellationPolicy = configurationEntity.getTransfersCancellationPolicy();
		this.sightSeeingSeperateCostDisplay = configurationEntity.isSightSeeingSeperateCostDisplay();
		this.sightSeeingGstBreakup = configurationEntity.isSightSeeingGstBreakup();
		this.sightSeeingCancellationPolicyDisplay = configurationEntity.isSightSeeingCancellationPolicyDisplay();
		this.sightSeeingCancellationPolicy = configurationEntity.getSightSeeingCancellationPolicy();
		this.sightSeeingsIncludeMasterAppendix = configurationEntity.isSightSeeingsIncludeMasterAppendix();
		this.visaSeperateCostDisplay = configurationEntity.isVisaSeperateCostDisplay();
		this.visaGstBreakup = configurationEntity.isVisaGstBreakup();
		this.visaCancellationPolicyDisplay = configurationEntity.isVisaCancellationPolicyDisplay();
		this.visaCancellationPolicy = configurationEntity.getVisaCancellationPolicy();
		this.visaAdditionalDetailsDisplay = configurationEntity.isVisaAdditionalDetailsDisplay();
		this.visaAdditionalDetails = configurationEntity.getVisaAdditionalDetails();
		this.insuranceSeperateCostDisplay = configurationEntity.isInsuranceSeperateCostDisplay();
		this.insuranceGstBreakup = configurationEntity.isInsuranceGstBreakup();
		this.insuranceCancellationPolicyDisplay = configurationEntity.isInsuranceCancellationPolicyDisplay();
		this.insuranceCancellationPolicy = configurationEntity.getInsuranceCancellationPolicy();
		this.cruiseSeperateCostDisplay = configurationEntity.isCruiseSeperateCostDisplay();
		this.cruiseGstBreakup = configurationEntity.isCruiseGstBreakup();
		this.cruiseCancellationPolicyDisplay = configurationEntity.isCruiseCancellationPolicyDisplay();
		this.cruiseCancellationPolicy = configurationEntity.getCruiseCancellationPolicy();
		this.packageSeperateCostDisplay = configurationEntity.isPackageSeperateCostDisplay();
		this.packageGstBreakup = configurationEntity.isPackageGstBreakup();
		this.packageCancellationPolicyDisplay = configurationEntity.isPackageCancellationPolicyDisplay();
		this.packageCancellationPolicy = configurationEntity.getPackageCancellationPolicy();
		this.otherSeperateCostDisplay = configurationEntity.isOtherSeperateCostDisplay();
		this.otherGstBreakup = configurationEntity.isOtherGstBreakup();
		this.otherCancellationPolicyDisplay = configurationEntity.isOtherCancellationPolicyDisplay();
		this.otherCancellationPolicy = configurationEntity.getOtherCancellationPolicy();
		this.logoHeader=configurationEntity.isLogoHeader();
		this.completeAddress=configurationEntity.isCompleteAddress();
		this.active = configurationEntity.isActive();
		this.totalQuotationAmount = configurationEntity.getTotalQuotationAmount();
		this.remarks= configurationEntity.getRemarks();
		this.leftOverAmtDisplay=configurationEntity.isLeftOverAmtDisplay();
		this.showBankAccounts=configurationEntity.isShowBankAccounts();
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}



}
