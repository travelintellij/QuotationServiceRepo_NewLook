package com.travelintellij.quotation.dto;



public class QuotationEmailSendingRequestVO {
	private long leadId;
	private long  quotationId;
	private int version;
	private EmailMessageVO emailMessageVO;
	
	public long getLeadId() {
		return leadId;
	}
	public void setLeadId(long leadId) {
		this.leadId = leadId;
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
	public EmailMessageVO getEmailMessageVO() {
		return emailMessageVO;
	}
	public void setEmailMessageVO(EmailMessageVO emailMessageVO) {
		this.emailMessageVO = emailMessageVO;
	}
	@Override
	public String toString() {
		return "QuotationEmailSendingRequestVO [leadId=" + leadId + ", quotationId=" + quotationId + ", version="
				+ version + ", emailMessageVO=" + emailMessageVO + "]";
	}
	
	
	
	
	
	
	
}
