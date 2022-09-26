package com.travelintellij.quotation.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.travelintellij.quotation.dto.Udn_Visa_Doc_Map_Obj;


@Entity
@Table(name = "udn_visa_doc_map")
public class Udn_Visa_Doc_Map_Entity extends AuditModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visaDocId;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="visaId", nullable=false)
	@JsonManagedReference
    private Udn_Visa_Master_Entity visaId;
	
	
	private String documentTitle;
	private String description;


	
	public Udn_Visa_Doc_Map_Entity() {}

	public Udn_Visa_Doc_Map_Entity(Udn_Visa_Doc_Map_Obj visaDocObj) {
		this.visaDocId=visaDocObj.getVisaDocId();
		this.visaId=visaDocObj.getVisaId();
		this.documentTitle=visaDocObj.getDocumentTitle();
		this.description=visaDocObj.getDescription();
	}
	
	public String toString() {
		String attrib = " Displaying Visa Doc Entity :- \n";
		attrib = attrib +" visaDocId -> " + visaDocId + "\n";
		attrib = attrib +" visaId-> " +visaId+ "\n";
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



	public void setVisaIdentifier(Udn_Visa_Master_Entity visaId) {
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