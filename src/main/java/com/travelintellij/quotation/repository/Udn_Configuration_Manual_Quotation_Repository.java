package com.travelintellij.quotation.repository;

import java.util.Date;

import com.travelintellij.quotation.entity.Tg_Quotation_Recorder_Entity;
import com.travelintellij.quotation.entity.Udn_Configuration_Manual_Quotation_Entity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Udn_Configuration_Manual_Quotation_Repository extends JpaRepository<Udn_Configuration_Manual_Quotation_Entity,Long>,JpaSpecificationExecutor{

	Udn_Configuration_Manual_Quotation_Entity findByQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity);
	boolean existsByQuotationEntity(Tg_Quotation_Recorder_Entity quotationEntity);
	
	
	 
} 
