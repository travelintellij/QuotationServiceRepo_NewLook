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
	private long mobile ;
	private long cityId ;
	private String email;
	private String gstNumber;
	private String remarks;
	private boolean active;


	@Override
	public String toString() {
		return "TI_B2bPartnersDTO{" +
				"partnerId=" + partnerId +
				", partnerShortName='" + partnerShortName + '\'' +
				", partnerName='" + partnerName + '\'' +
				", address='" + address + '\'' +
				", mobile=" + mobile +
				", cityId=" + cityId +
				", email='" + email + '\'' +
				", gstNumber='" + gstNumber + '\'' +
				", remarks='" + remarks + '\'' +
				", active=" + active +
				'}';
	}
}