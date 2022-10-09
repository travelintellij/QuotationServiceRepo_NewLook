package com.travelintellij.quotation.entity;

import java.sql.Date;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.ConfigurationQuotationVO;

@Entity
@Table(name = "udn_configuration_manual_quotation")
public class Udn_Configuration_Manual_Quotation_Entity extends AuditModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long manualConfigurationQuotationId;

	protected int partnerId=1; 
	protected boolean flightShowConnections;
	protected boolean flightSeperateCostDisplay;
	protected boolean  flightGstBreakup;
	protected boolean flightCancellationPolicyDisplay;
	protected String flightCancellationPolicy;
	protected boolean hotelSeperateCostDisplay;
	protected boolean hotelGstBreakup;
	protected boolean hotelCancellationPolicyDisplay;
	protected String hotelCancellationPolicy;
	protected boolean transfersSeperateCostDisplay;
	protected boolean transfersGstBreakup;
	protected boolean transfersCancellationPolicyDisplay;
	protected String transfersCancellationPolicy;
	protected boolean sightSeeingSeperateCostDisplay;
	protected boolean sightSeeingGstBreakup;
	protected boolean sightSeeingCancellationPolicyDisplay;
	protected String sightSeeingCancellationPolicy;
	protected boolean sightSeeingsIncludeMasterAppendix;
	protected boolean visaSeperateCostDisplay;
	protected boolean visaGstBreakup;
	protected boolean visaCancellationPolicyDisplay; 
	protected String visaCancellationPolicy;
	protected boolean visaAdditionalDetailsDisplay;
	protected String visaAdditionalDetails;
	protected boolean insuranceSeperateCostDisplay;
	protected boolean insuranceGstBreakup;
	protected boolean insuranceCancellationPolicyDisplay;
	protected String insuranceCancellationPolicy;
	protected boolean cruiseSeperateCostDisplay;
	protected boolean cruiseGstBreakup;
	protected boolean cruiseCancellationPolicyDisplay;
	protected String cruiseCancellationPolicy;
	protected boolean packageSeperateCostDisplay;
	protected boolean packageGstBreakup;
	protected boolean packageCancellationPolicyDisplay;
	protected String packageCancellationPolicy;
	protected boolean otherSeperateCostDisplay;
	protected boolean otherGstBreakup;
	protected boolean otherCancellationPolicyDisplay;
	protected String otherCancellationPolicy;
	protected boolean active;
	protected boolean logoHeader=true;
	protected boolean completeAddress=true;
	protected String remarks;
	protected int totalQuotationAmount;
	protected boolean leftOverAmtDisplay;
	protected boolean showBankAccounts=true;
	
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="quotationId", nullable=false)
	@JsonManagedReference
	protected Tg_Quotation_Recorder_Entity quotationEntity;
	
	
	public Udn_Configuration_Manual_Quotation_Entity(ConfigurationQuotationVO configureQtnVO) {
		this.manualConfigurationQuotationId = configureQtnVO.getManualConfigurationQuotationId();
		this.partnerId = configureQtnVO.getPartnerId();
		this.flightShowConnections = configureQtnVO.isFlightShowConnections();
		this.flightSeperateCostDisplay = configureQtnVO.isFlightSeperateCostDisplay();
		this.flightGstBreakup = configureQtnVO.isFlightGstBreakup();
		this.flightCancellationPolicyDisplay = configureQtnVO.isFlightCancellationPolicyDisplay();
		this.flightCancellationPolicy = configureQtnVO.getFlightCancellationPolicy();
		this.hotelSeperateCostDisplay = configureQtnVO.isHotelSeperateCostDisplay();
		this.hotelGstBreakup = configureQtnVO.isHotelGstBreakup();
		this.hotelCancellationPolicyDisplay = configureQtnVO.isHotelCancellationPolicyDisplay();
		this.hotelCancellationPolicy = configureQtnVO.getHotelCancellationPolicy();
		this.transfersSeperateCostDisplay = configureQtnVO.isTransfersSeperateCostDisplay();
		this.transfersGstBreakup = configureQtnVO.isTransfersGstBreakup();
		this.transfersCancellationPolicyDisplay = configureQtnVO.isTransfersCancellationPolicyDisplay();
		this.transfersCancellationPolicy = configureQtnVO.getTransfersCancellationPolicy();
		this.sightSeeingSeperateCostDisplay = configureQtnVO.isSightSeeingSeperateCostDisplay();
		this.sightSeeingGstBreakup = configureQtnVO.isSightSeeingGstBreakup();
		this.sightSeeingCancellationPolicyDisplay = configureQtnVO.isSightSeeingCancellationPolicyDisplay();
		this.sightSeeingCancellationPolicy = configureQtnVO.getSightSeeingCancellationPolicy();
		this.sightSeeingsIncludeMasterAppendix = configureQtnVO.isSightSeeingsIncludeMasterAppendix();
		this.visaSeperateCostDisplay = configureQtnVO.isVisaSeperateCostDisplay();
		this.visaGstBreakup = configureQtnVO.isVisaGstBreakup();
		this.visaCancellationPolicyDisplay = configureQtnVO.isVisaCancellationPolicyDisplay();
		this.visaCancellationPolicy = configureQtnVO.getVisaCancellationPolicy();
		this.visaAdditionalDetailsDisplay = configureQtnVO.isVisaAdditionalDetailsDisplay();
		this.visaAdditionalDetails = configureQtnVO.getVisaAdditionalDetails();
		this.insuranceSeperateCostDisplay = configureQtnVO.isInsuranceSeperateCostDisplay();
		this.insuranceGstBreakup = configureQtnVO.isInsuranceGstBreakup();
		this.insuranceCancellationPolicyDisplay = configureQtnVO.isInsuranceCancellationPolicyDisplay();
		this.insuranceCancellationPolicy = configureQtnVO.getInsuranceCancellationPolicy();
		this.cruiseSeperateCostDisplay = configureQtnVO.isCruiseSeperateCostDisplay();
		this.cruiseGstBreakup = configureQtnVO.isCruiseGstBreakup();
		this.cruiseCancellationPolicyDisplay = configureQtnVO.isCruiseCancellationPolicyDisplay();
		this.cruiseCancellationPolicy = configureQtnVO.getCruiseCancellationPolicy();
		this.packageSeperateCostDisplay = configureQtnVO.isPackageSeperateCostDisplay();
		this.packageGstBreakup = configureQtnVO.isPackageGstBreakup();
		this.packageCancellationPolicyDisplay = configureQtnVO.isPackageCancellationPolicyDisplay();
		this.packageCancellationPolicy = configureQtnVO.getPackageCancellationPolicy();
		this.otherSeperateCostDisplay = configureQtnVO.isOtherSeperateCostDisplay();
		this.otherGstBreakup = configureQtnVO.isOtherGstBreakup();
		this.otherCancellationPolicyDisplay = configureQtnVO.isOtherCancellationPolicyDisplay();
		this.otherCancellationPolicy = configureQtnVO.getOtherCancellationPolicy();
		this.logoHeader=configureQtnVO.isLogoHeader();
		this.completeAddress=configureQtnVO.isCompleteAddress();
		this.active = configureQtnVO.isActive();
		this.totalQuotationAmount =configureQtnVO.getTotalQuotationAmount(); 
		this.remarks=configureQtnVO.getRemarks();
		this.leftOverAmtDisplay =configureQtnVO.isLeftOverAmtDisplay(); 
		this.showBankAccounts=configureQtnVO.isShowBankAccounts();
		
	}

	

	public Udn_Configuration_Manual_Quotation_Entity() {}

	public long getManualConfigurationQuotationId() {
		return manualConfigurationQuotationId;
	}

	public void setManualConfigurationQuotationId(long manualConfigurationQuotationId) {
		this.manualConfigurationQuotationId = manualConfigurationQuotationId;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public boolean isFlightShowConnections() {
		return flightShowConnections;
	}

	public void setFlightShowConnections(boolean flightShowConnections) {
		this.flightShowConnections = flightShowConnections;
	}

	public boolean isFlightSeperateCostDisplay() {
		return flightSeperateCostDisplay;
	}

	public void setFlightSeperateCostDisplay(boolean flightSeperateCostDisplay) {
		this.flightSeperateCostDisplay = flightSeperateCostDisplay;
	}

	public boolean isFlightGstBreakup() {
		return flightGstBreakup;
	}

	public void setFlightGstBreakup(boolean flightGstBreakup) {
		this.flightGstBreakup = flightGstBreakup;
	}

	public boolean isFlightCancellationPolicyDisplay() {
		return flightCancellationPolicyDisplay;
	}

	public void setFlightCancellationPolicyDisplay(boolean flightCancellationPolicyDisplay) {
		this.flightCancellationPolicyDisplay = flightCancellationPolicyDisplay;
	}

	public String getFlightCancellationPolicy() {
		return flightCancellationPolicy;
	}

	public void setFlightCancellationPolicy(String flightCancellationPolicy) {
		this.flightCancellationPolicy = flightCancellationPolicy;
	}

	public boolean isHotelSeperateCostDisplay() {
		return hotelSeperateCostDisplay;
	}

	public void setHotelSeperateCostDisplay(boolean hotelSeperateCostDisplay) {
		this.hotelSeperateCostDisplay = hotelSeperateCostDisplay;
	}

	public boolean isHotelGstBreakup() {
		return hotelGstBreakup;
	}

	public void setHotelGstBreakup(boolean hotelGstBreakup) {
		this.hotelGstBreakup = hotelGstBreakup;
	}

	public boolean isHotelCancellationPolicyDisplay() {
		return hotelCancellationPolicyDisplay;
	}

	public void setHotelCancellationPolicyDisplay(boolean hotelCancellationPolicyDisplay) {
		this.hotelCancellationPolicyDisplay = hotelCancellationPolicyDisplay;
	}

	public String getHotelCancellationPolicy() {
		return hotelCancellationPolicy;
	}

	public void setHotelCancellationPolicy(String hotelCancellationPolicy) {
		this.hotelCancellationPolicy = hotelCancellationPolicy;
	}

	public boolean isTransfersSeperateCostDisplay() {
		return transfersSeperateCostDisplay;
	}

	public void setTransfersSeperateCostDisplay(boolean transfersSeperateCostDisplay) {
		this.transfersSeperateCostDisplay = transfersSeperateCostDisplay;
	}

	public boolean isTransfersGstBreakup() {
		return transfersGstBreakup;
	}

	public void setTransfersGstBreakup(boolean transfersGstBreakup) {
		this.transfersGstBreakup = transfersGstBreakup;
	}

	public boolean isTransfersCancellationPolicyDisplay() {
		return transfersCancellationPolicyDisplay;
	}

	public void setTransfersCancellationPolicyDisplay(boolean transfersCancellationPolicyDisplay) {
		this.transfersCancellationPolicyDisplay = transfersCancellationPolicyDisplay;
	}

	public String getTransfersCancellationPolicy() {
		return transfersCancellationPolicy;
	}

	public void setTransfersCancellationPolicy(String transfersCancellationPolicy) {
		this.transfersCancellationPolicy = transfersCancellationPolicy;
	}

	public boolean isSightSeeingSeperateCostDisplay() {
		return sightSeeingSeperateCostDisplay;
	}

	public void setSightSeeingSeperateCostDisplay(boolean sightSeeingSeperateCostDisplay) {
		this.sightSeeingSeperateCostDisplay = sightSeeingSeperateCostDisplay;
	}

	public boolean isSightSeeingGstBreakup() {
		return sightSeeingGstBreakup;
	}

	public void setSightSeeingGstBreakup(boolean sightSeeingGstBreakup) {
		this.sightSeeingGstBreakup = sightSeeingGstBreakup;
	}

	public boolean isSightSeeingCancellationPolicyDisplay() {
		return sightSeeingCancellationPolicyDisplay;
	}

	public void setSightSeeingCancellationPolicyDisplay(boolean sightSeeingCancellationPolicyDisplay) {
		this.sightSeeingCancellationPolicyDisplay = sightSeeingCancellationPolicyDisplay;
	}

	public String getSightSeeingCancellationPolicy() {
		return sightSeeingCancellationPolicy;
	}

	public void setSightSeeingCancellationPolicy(String sightSeeingCancellationPolicy) {
		this.sightSeeingCancellationPolicy = sightSeeingCancellationPolicy;
	}

	public boolean isSightSeeingsIncludeMasterAppendix() {
		return sightSeeingsIncludeMasterAppendix;
	}

	public void setSightSeeingsIncludeMasterAppendix(boolean sightSeeingsIncludeMasterAppendix) {
		this.sightSeeingsIncludeMasterAppendix = sightSeeingsIncludeMasterAppendix;
	}

	public boolean isVisaSeperateCostDisplay() {
		return visaSeperateCostDisplay;
	}

	public void setVisaSeperateCostDisplay(boolean visaSeperateCostDisplay) {
		this.visaSeperateCostDisplay = visaSeperateCostDisplay;
	}

	public boolean isVisaGstBreakup() {
		return visaGstBreakup;
	}

	public void setVisaGstBreakup(boolean visaGstBreakup) {
		this.visaGstBreakup = visaGstBreakup;
	}

	public boolean isVisaCancellationPolicyDisplay() {
		return visaCancellationPolicyDisplay;
	}

	public void setVisaCancellationPolicyDisplay(boolean visaCancellationPolicyDisplay) {
		this.visaCancellationPolicyDisplay = visaCancellationPolicyDisplay;
	}

	public String getVisaCancellationPolicy() {
		return visaCancellationPolicy;
	}

	public void setVisaCancellationPolicy(String visaCancellationPolicy) {
		this.visaCancellationPolicy = visaCancellationPolicy;
	}

	public boolean isVisaAdditionalDetailsDisplay() {
		return visaAdditionalDetailsDisplay;
	}

	public void setVisaAdditionalDetailsDisplay(boolean visaAdditionalDetailsDisplay) {
		this.visaAdditionalDetailsDisplay = visaAdditionalDetailsDisplay;
	}

	public String getVisaAdditionalDetails() {
		return visaAdditionalDetails;
	}

	public void setVisaAdditionalDetails(String visaAdditionalDetails) {
		this.visaAdditionalDetails = visaAdditionalDetails;
	}

	public boolean isInsuranceSeperateCostDisplay() {
		return insuranceSeperateCostDisplay;
	}

	public void setInsuranceSeperateCostDisplay(boolean insuranceSeperateCostDisplay) {
		this.insuranceSeperateCostDisplay = insuranceSeperateCostDisplay;
	}

	public boolean isInsuranceGstBreakup() {
		return insuranceGstBreakup;
	}

	public void setInsuranceGstBreakup(boolean insuranceGstBreakup) {
		this.insuranceGstBreakup = insuranceGstBreakup;
	}

	public boolean isInsuranceCancellationPolicyDisplay() {
		return insuranceCancellationPolicyDisplay;
	}

	public void setInsuranceCancellationPolicyDisplay(boolean insuranceCancellationPolicyDisplay) {
		this.insuranceCancellationPolicyDisplay = insuranceCancellationPolicyDisplay;
	}

	public String getInsuranceCancellationPolicy() {
		return insuranceCancellationPolicy;
	}

	public void setInsuranceCancellationPolicy(String insuranceCancellationPolicy) {
		this.insuranceCancellationPolicy = insuranceCancellationPolicy;
	}

	public boolean isCruiseSeperateCostDisplay() {
		return cruiseSeperateCostDisplay;
	}

	public void setCruiseSeperateCostDisplay(boolean cruiseSeperateCostDisplay) {
		this.cruiseSeperateCostDisplay = cruiseSeperateCostDisplay;
	}

	public boolean isCruiseGstBreakup() {
		return cruiseGstBreakup;
	}

	public void setCruiseGstBreakup(boolean cruiseGstBreakup) {
		this.cruiseGstBreakup = cruiseGstBreakup;
	}

	public boolean isCruiseCancellationPolicyDisplay() {
		return cruiseCancellationPolicyDisplay;
	}

	public void setCruiseCancellationPolicyDisplay(boolean cruiseCancellationPolicyDisplay) {
		this.cruiseCancellationPolicyDisplay = cruiseCancellationPolicyDisplay;
	}

	public String getCruiseCancellationPolicy() {
		return cruiseCancellationPolicy;
	}

	public void setCruiseCancellationPolicy(String cruiseCancellationPolicy) {
		this.cruiseCancellationPolicy = cruiseCancellationPolicy;
	}

	public boolean isPackageSeperateCostDisplay() {
		return packageSeperateCostDisplay;
	}

	public void setPackageSeperateCostDisplay(boolean packageSeperateCostDisplay) {
		this.packageSeperateCostDisplay = packageSeperateCostDisplay;
	}

	public boolean isPackageGstBreakup() {
		return packageGstBreakup;
	}

	public void setPackageGstBreakup(boolean packageGstBreakup) {
		this.packageGstBreakup = packageGstBreakup;
	}

	public boolean isPackageCancellationPolicyDisplay() {
		return packageCancellationPolicyDisplay;
	}

	public void setPackageCancellationPolicyDisplay(boolean packageCancellationPolicyDisplay) {
		this.packageCancellationPolicyDisplay = packageCancellationPolicyDisplay;
	}

	public String getPackageCancellationPolicy() {
		return packageCancellationPolicy;
	}

	public void setPackageCancellationPolicy(String packageCancellationPolicy) {
		this.packageCancellationPolicy = packageCancellationPolicy;
	}

	public boolean isOtherSeperateCostDisplay() {
		return otherSeperateCostDisplay;
	}

	public void setOtherSeperateCostDisplay(boolean otherSeperateCostDisplay) {
		this.otherSeperateCostDisplay = otherSeperateCostDisplay;
	}

	public boolean isOtherGstBreakup() {
		return otherGstBreakup;
	}

	public void setOtherGstBreakup(boolean otherGstBreakup) {
		this.otherGstBreakup = otherGstBreakup;
	}

	public boolean isOtherCancellationPolicyDisplay() {
		return otherCancellationPolicyDisplay;
	}

	public void setOtherCancellationPolicyDisplay(boolean otherCancellationPolicyDisplay) {
		this.otherCancellationPolicyDisplay = otherCancellationPolicyDisplay;
	}

	public String getOtherCancellationPolicy() {
		return otherCancellationPolicy;
	}

	public void setOtherCancellationPolicy(String otherCancellationPolicy) {
		this.otherCancellationPolicy = otherCancellationPolicy;
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



	public boolean isLogoHeader() {
		return logoHeader;
	}



	public void setLogoHeader(boolean logoHeader) {
		this.logoHeader = logoHeader;
	}





	public boolean isCompleteAddress() {
		return completeAddress;
	}



	public void setCompleteAddress(boolean completeAddress) {
		this.completeAddress = completeAddress;
	}
	


	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public int getTotalQuotationAmount() {
		return totalQuotationAmount;
	}



	public void setTotalQuotationAmount(int totalQuotationAmount) {
		this.totalQuotationAmount = totalQuotationAmount;
	}



	public boolean isLeftOverAmtDisplay() {
		return leftOverAmtDisplay;
	}



	public void setLeftOverAmtDisplay(boolean leftOverAmtDisplay) {
		this.leftOverAmtDisplay = leftOverAmtDisplay;
	}



	public boolean isShowBankAccounts() {
		return showBankAccounts;
	}



	public void setShowBankAccounts(boolean showBankAccounts) {
		this.showBankAccounts = showBankAccounts;
	}

	@Override
	public String toString() {
		return "Udn_Configuration_Manual_Quotation_Entity{" +
				"manualConfigurationQuotationId=" + manualConfigurationQuotationId +
				", partnerId=" + partnerId +
				", flightShowConnections=" + flightShowConnections +
				", flightSeperateCostDisplay=" + flightSeperateCostDisplay +
				", flightGstBreakup=" + flightGstBreakup +
				", flightCancellationPolicyDisplay=" + flightCancellationPolicyDisplay +
				", flightCancellationPolicy='" + flightCancellationPolicy + '\'' +
				", hotelSeperateCostDisplay=" + hotelSeperateCostDisplay +
				", hotelGstBreakup=" + hotelGstBreakup +
				", hotelCancellationPolicyDisplay=" + hotelCancellationPolicyDisplay +
				", hotelCancellationPolicy='" + hotelCancellationPolicy + '\'' +
				", transfersSeperateCostDisplay=" + transfersSeperateCostDisplay +
				", transfersGstBreakup=" + transfersGstBreakup +
				", transfersCancellationPolicyDisplay=" + transfersCancellationPolicyDisplay +
				", transfersCancellationPolicy='" + transfersCancellationPolicy + '\'' +
				", sightSeeingSeperateCostDisplay=" + sightSeeingSeperateCostDisplay +
				", sightSeeingGstBreakup=" + sightSeeingGstBreakup +
				", sightSeeingCancellationPolicyDisplay=" + sightSeeingCancellationPolicyDisplay +
				", sightSeeingCancellationPolicy='" + sightSeeingCancellationPolicy + '\'' +
				", sightSeeingsIncludeMasterAppendix=" + sightSeeingsIncludeMasterAppendix +
				", visaSeperateCostDisplay=" + visaSeperateCostDisplay +
				", visaGstBreakup=" + visaGstBreakup +
				", visaCancellationPolicyDisplay=" + visaCancellationPolicyDisplay +
				", visaCancellationPolicy='" + visaCancellationPolicy + '\'' +
				", visaAdditionalDetailsDisplay=" + visaAdditionalDetailsDisplay +
				", visaAdditionalDetails='" + visaAdditionalDetails + '\'' +
				", insuranceSeperateCostDisplay=" + insuranceSeperateCostDisplay +
				", insuranceGstBreakup=" + insuranceGstBreakup +
				", insuranceCancellationPolicyDisplay=" + insuranceCancellationPolicyDisplay +
				", insuranceCancellationPolicy='" + insuranceCancellationPolicy + '\'' +
				", cruiseSeperateCostDisplay=" + cruiseSeperateCostDisplay +
				", cruiseGstBreakup=" + cruiseGstBreakup +
				", cruiseCancellationPolicyDisplay=" + cruiseCancellationPolicyDisplay +
				", cruiseCancellationPolicy='" + cruiseCancellationPolicy + '\'' +
				", packageSeperateCostDisplay=" + packageSeperateCostDisplay +
				", packageGstBreakup=" + packageGstBreakup +
				", packageCancellationPolicyDisplay=" + packageCancellationPolicyDisplay +
				", packageCancellationPolicy='" + packageCancellationPolicy + '\'' +
				", otherSeperateCostDisplay=" + otherSeperateCostDisplay +
				", otherGstBreakup=" + otherGstBreakup +
				", otherCancellationPolicyDisplay=" + otherCancellationPolicyDisplay +
				", otherCancellationPolicy='" + otherCancellationPolicy + '\'' +
				", active=" + active +
				", logoHeader=" + logoHeader +
				", completeAddress=" + completeAddress +
				", remarks='" + remarks + '\'' +
				", totalQuotationAmount=" + totalQuotationAmount +
				", leftOverAmtDisplay=" + leftOverAmtDisplay +
				", showBankAccounts=" + showBankAccounts +
				", quotationEntity=" + quotationEntity +
				'}';
	}


}
