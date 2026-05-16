package com.travelintellij.quotation.dto;


import lombok.Getter;
import lombok.Setter;

public class TI_B2bPartnersDTO {
	public TI_B2bPartnersDTO() {}
	private int partnerId;
	private String partnerShortName;

	private String partnerBrandName;
	private String partnerName ;
	private String address ;
	private long contactNumber ;
	private long cityId ;
	private String email;
	private String gstNumber;
	private String remarks;
	private boolean active;

	private String beneficiaryName;
	private String bankName;
	private String bankAccountNumber;
	private String bankIFSCCode;
	private String bankBranch;
	private String upiId;

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerShortName() {
		return partnerShortName;
	}

	public void setPartnerShortName(String partnerShortName) {
		this.partnerShortName = partnerShortName;
	}

	public String getPartnerBrandName() {
		return partnerBrandName;
	}

	public void setPartnerBrandName(String partnerBrandName) {
		this.partnerBrandName = partnerBrandName;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
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

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIFSCCode() {
		return bankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public String toString() {
		return "TI_B2bPartnersDTO{" +
				"partnerId=" + partnerId +
				", partnerShortName='" + partnerShortName + '\'' +
				", partnerBrandName='" + partnerBrandName + '\'' +
				", partnerName='" + partnerName + '\'' +
				", address='" + address + '\'' +
				", contactNumber=" + contactNumber +
				", cityId=" + cityId +
				", email='" + email + '\'' +
				", gstNumber='" + gstNumber + '\'' +
				", remarks='" + remarks + '\'' +
				", active=" + active +
				", beneficiaryName='" + beneficiaryName + '\'' +
				", bankName='" + bankName + '\'' +
				", bankAccountNumber='" + bankAccountNumber + '\'' +
				", bankIFSCCode='" + bankIFSCCode + '\'' +
				", bankBranch='" + bankBranch + '\'' +
				", upiId='" + upiId + '\'' +
				'}';
	}
}