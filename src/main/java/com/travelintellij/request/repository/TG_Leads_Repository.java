package com.travelintellij.request.repository;

import com.travelintellij.request.entity.Tg_Leads_Recorder_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface TG_Leads_Repository extends JpaRepository<Tg_Leads_Recorder_Entity,Long>,JpaSpecificationExecutor{


} 
