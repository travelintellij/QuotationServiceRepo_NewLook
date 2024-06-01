package com.travelintellij.quotation.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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