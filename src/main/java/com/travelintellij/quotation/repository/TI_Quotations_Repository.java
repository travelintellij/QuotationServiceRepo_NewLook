package com.travelintellij.quotation.repository;

import com.travelintellij.quotation.entity.Tg_Quotation_Recorder_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TI_Quotations_Repository extends JpaRepository<Tg_Quotation_Recorder_Entity,Long>,JpaSpecificationExecutor{

	@Query("SELECT COALESCE(Max(version),0) FROM Tg_Quotation_Recorder_Entity a where a.leadEntity.leadId=?1")
	int max_QuotationVersionGenerated(long leadId); 
	
	
	
} 
