package com.travelintellij.quotation.dto;

import java.util.ArrayList;

public class EmailMessageVO {
	
	private String emailToList;
	private String emailCcList;
	private String emailSubject;
	private String emailMessage;

	private String emailMessageFrom;
	
	private ArrayList emailToValidatedList;
	private ArrayList emailCcValidatedList;
	private boolean isReminderServiceMessage=false;
	
	public String getEmailToList() {
		return emailToList;
	}

	public void setEmailToList(String emailToList) {
		this.emailToList = emailToList;
	}

	public String getEmailCcList() {
		return emailCcList;
	}

	public void setEmailCcList(String emailCcList) {
		this.emailCcList = emailCcList;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailMessage() {
		return emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public ArrayList getEmailToValidatedList() {
		return emailToValidatedList;
	}

	public void setEmailToValidatedList(ArrayList emailToValidatedList) {
		this.emailToValidatedList = emailToValidatedList;
	}
	public ArrayList getEmailCcValidatedList() {
		return emailCcValidatedList;
	}
	public void setEmailCcValidatedList(ArrayList emailCcValidatedList) {
		this.emailCcValidatedList = emailCcValidatedList;
	}

	@Override
	public String toString() {
		return "EmailMessageVO{" +
				"emailToList='" + emailToList + '\'' +
				", emailCcList='" + emailCcList + '\'' +
				", emailSubject='" + emailSubject + '\'' +
				", emailMessage='" + emailMessage + '\'' +
				", emailMessageFrom='" + emailMessageFrom + '\'' +
				", emailToValidatedList=" + emailToValidatedList +
				", emailCcValidatedList=" + emailCcValidatedList +
				", isReminderServiceMessage=" + isReminderServiceMessage +
				'}';
	}

	public String getEmailMessageFrom() {
		return emailMessageFrom;
	}

	public void setEmailMessageFrom(String emailMessageFrom) {
		this.emailMessageFrom = emailMessageFrom;
	}

	public boolean isReminderServiceMessage() {
		return isReminderServiceMessage;
	}
	public void setReminderServiceMessage(boolean isReminderServiceMessage) {
		this.isReminderServiceMessage = isReminderServiceMessage;
	}
	
	
	
}
