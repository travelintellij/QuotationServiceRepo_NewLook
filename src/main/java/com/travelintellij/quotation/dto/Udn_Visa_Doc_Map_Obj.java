package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.Udn_Visa_Doc_Map_Entity;
import com.travelintellij.quotation.entity.Udn_Visa_Master_Entity;


public class Udn_Visa_Doc_Map_Obj  {
	
	private int visaDocId;
    private Udn_Visa_Master_Entity visaId;
	private String documentTitle;
	private String description;
	
	
	public Udn_Visa_Doc_Map_Obj() {}
	
	public Udn_Visa_Doc_Map_Obj(Udn_Visa_Doc_Map_Entity visaDocEntity) {
		this.visaDocId=visaDocEntity.getVisaDocId();
		this.visaId=visaDocEntity.getVisaId();
		this.documentTitle=visaDocEntity.getDocumentTitle();
		this.description=visaDocEntity.getDescription();
	}
	
	public String toString() {
		String attrib = " Displaying Visa Doc Obj :- \n";
		attrib = attrib +" visaDocId -> " + visaDocId + "\n";
		//attrib = attrib +" visaId-> " +visaId + "\n";
		attrib = attrib +" documentTitle-> " + documentTitle+ "\n";
		attrib = attrib +" description -> " + description+ "\n";
		
		return attrib;
		
	}

	public int getVisaDocId() {
		return visaDocId;
	}

	public void setVisaDocId(int visaDocId) {
		this.visaDocId = visaDocId;
	}

	public Udn_Visa_Master_Entity getVisaId() {
		return visaId;
	}

	public void setVisaId(Udn_Visa_Master_Entity visaId) {
		this.visaId = visaId;
	}

	public String getDocumentTitle() {
		return documentTitle;
	}

	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}