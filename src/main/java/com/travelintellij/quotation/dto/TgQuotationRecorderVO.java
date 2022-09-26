package com.travelintellij.quotation.dto;

import com.travelintellij.quotation.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class TgQuotationRecorderVO extends Tg_Quotation_Recorder_Entity {

	public TgQuotationRecorderVO() {
		
	}
	
	protected int hotelOptionNo;
	protected SortedSet<ManualFlightQuotationVO> manualQuotationsVoList = new TreeSet<ManualFlightQuotationVO>();
	protected SortedSet<ManualHotelQuotationVO> hotelVoList = new TreeSet<ManualHotelQuotationVO>();
	protected SortedSet<ManualTransferQuotationVO> transferVoList = new TreeSet<ManualTransferQuotationVO>();
	protected SortedSet<ManualSightSeeingQuotationVO> sightSeeingVoList = new TreeSet<ManualSightSeeingQuotationVO>();
	protected SortedSet<ManualVisaQuotationVO> visaVoList = new TreeSet<ManualVisaQuotationVO>();
	protected SortedSet<ManualPackageQuotationVO> tourPackageVoList = new TreeSet<ManualPackageQuotationVO>();
	protected SortedSet<ManualOtherQuotationVO> otherVoList = new TreeSet<ManualOtherQuotationVO>();
	protected SortedSet<ManualInsuranceQuotationVO> insuranceVoList = new TreeSet<ManualInsuranceQuotationVO>();
	protected SortedSet<ManualCruiseQuotationVO> cruiseVoList = new TreeSet<ManualCruiseQuotationVO>();
	protected Map<Integer, List<ManualHotelQuotationVO>> hotelOptionsWiseMap = new HashMap<Integer, List<ManualHotelQuotationVO>>();
	
	public TgQuotationRecorderVO(Tg_Quotation_Recorder_Entity tgQuotationEntity) {
		this.quotationId = tgQuotationEntity.getQuotationId();
		this.tourPackage=tgQuotationEntity.isTourPackage();
		this.flight=tgQuotationEntity.isFlight();
		this.hotel=tgQuotationEntity.isHotel();
		this.transfers=tgQuotationEntity.isTransfers();
		this.sightseeing=tgQuotationEntity.isSightseeing();
		this.visa=tgQuotationEntity.isVisa();
		this.insurance=tgQuotationEntity.isInsurance();
		this.cruise=tgQuotationEntity.isCruise();
		this.others=tgQuotationEntity.isOthers();
		this.version=tgQuotationEntity.getVersion();
		this.quotationName=tgQuotationEntity.getQuotationName();
		this.createdBy=tgQuotationEntity.getCreatedBy();
		this.lastUpdatedBy=tgQuotationEntity.getLastUpdatedBy();
		
	}
	
	public void setVoFromEntity(Tg_Quotation_Recorder_Entity tgQuotationEntity) {
		this.quotationId = tgQuotationEntity.getQuotationId();
		this.tourPackage=tgQuotationEntity.isTourPackage();
		this.flight=tgQuotationEntity.isFlight();
		this.hotel=tgQuotationEntity.isHotel();
		this.transfers=tgQuotationEntity.isTransfers();
		this.sightseeing=tgQuotationEntity.isSightseeing();
		this.visa=tgQuotationEntity.isVisa();
		this.insurance=tgQuotationEntity.isInsurance();
		this.cruise=tgQuotationEntity.isCruise();
		this.others=tgQuotationEntity.isOthers();
		this.version=tgQuotationEntity.getVersion();
		this.quotationName=tgQuotationEntity.getQuotationName();
		this.createdBy=tgQuotationEntity.getCreatedBy();
		this.lastUpdatedBy=tgQuotationEntity.getLastUpdatedBy();
		//this.manualQuotationsList = tgQuotationEntity.getManualQuotationsList();
		updateManualFlightVO(tgQuotationEntity.getManualQuotationsList());
		updateManualHotelVO(tgQuotationEntity.getHotelQuotationsList(),this.getHotelOptionNo());
		updateManualTransfersVO(tgQuotationEntity.getTransferQuotationList());
		updateSightSeeingVO(tgQuotationEntity.getSightSeeingQuotationList());
		updateVisaVO(tgQuotationEntity.getVisaQuotationList());
		updateManualPackageVO(tgQuotationEntity.getPackageQuotationsList());
		updateManualOtherVO(tgQuotationEntity.getOtherQuotationsList());
		updateManualInsuranceVO(tgQuotationEntity.getInsuranceQuotationsList());
		updateManualCruiseVO(tgQuotationEntity.getCruiseQuotationsList());
	}

	private void updateManualFlightVO(Set<Udn_Manual_Flight_Quotation_Entity> manualQuotationsList) {
		manualQuotationsList.forEach((e) -> { 
			ManualFlightQuotationVO manualFlightVo = new ManualFlightQuotationVO();
			manualFlightVo.updateManualFlightVoFromEntity(e);
			manualQuotationsVoList.add(manualFlightVo);
		});
	}
	
	private void updateManualHotelVO(Set<Udn_Manual_Hotel_Quotation_Entity> hotelQuotationsList, int hotelOptionNo) {
		hotelQuotationsList.forEach((e) -> { 
			ManualHotelQuotationVO manualHotelVo = new ManualHotelQuotationVO();
			manualHotelVo.updateManualHotelVoFromEntity(e);
			if(e.getOptionNo()==hotelOptionNo)
				hotelVoList.add(manualHotelVo);
		});
	}

	private void updateManualTransfersVO(Set<Udn_Manual_Transfer_Quotation_Entity> transferQuotationsList) {
		transferQuotationsList.forEach((e) -> { 
			ManualTransferQuotationVO manualTransferVo = new ManualTransferQuotationVO();
			manualTransferVo.updateManualTransferVoFromEntity(e);
			transferVoList.add(manualTransferVo);
		});
	}
	
	private void updateSightSeeingVO(Set<Udn_Manual_SightSeeing_Quotation_Entity> sightSeeingQuotationsList) {
		sightSeeingQuotationsList.forEach((e) -> { 
			ManualSightSeeingQuotationVO manualSightSeeingVo = new ManualSightSeeingQuotationVO();
			manualSightSeeingVo.updateManualSightSeeingVoFromEntity(e);
			sightSeeingVoList.add(manualSightSeeingVo);
		});
	}

	private void updateVisaVO(Set<Udn_Manual_Visa_Quotation_Entity> visaQuotationsList) {
		visaQuotationsList.forEach((e) -> { 
			ManualVisaQuotationVO manualVisaVo = new ManualVisaQuotationVO();
			manualVisaVo.updateManualVisaVoFromEntity(e);
			
			//updateManualVisaVoFromEntity(e);
			visaVoList.add(manualVisaVo);
		});
	}

	private void updateManualPackageVO(Set<Udn_Manual_Package_Quotation_Entity> packageQuotationsList) {
		packageQuotationsList.forEach((e) -> { 
			ManualPackageQuotationVO manualPackageVo = new ManualPackageQuotationVO();
			manualPackageVo.updateManualPackageVoFromEntity(e);
			tourPackageVoList.add(manualPackageVo);
		});
	}

	private void updateManualOtherVO(Set<Udn_Manual_Other_Quotation_Entity> otherQuotationsList) {
		otherQuotationsList.forEach((e) -> { 
			ManualOtherQuotationVO manualOtherVo = new ManualOtherQuotationVO();
			manualOtherVo.updateManualOtherVoFromEntity(e);
			otherVoList.add(manualOtherVo);
		});
	}
	private void updateManualInsuranceVO(Set<Udn_Manual_Insurance_Quotation_Entity> insuranceQuotationsList) {
		insuranceQuotationsList.forEach((e) -> { 
			ManualInsuranceQuotationVO manualInsuranceVo = new ManualInsuranceQuotationVO();
			manualInsuranceVo.updateManualInsuranceVoFromEntity(e);
			insuranceVoList.add(manualInsuranceVo);
		});
	}
	
	private void updateManualCruiseVO(Set<Udn_Manual_Cruise_Quotation_Entity> cruiseQuotationsList) {
		cruiseQuotationsList.forEach((e) -> { 
			ManualCruiseQuotationVO manualCruiseVo = new ManualCruiseQuotationVO();
			manualCruiseVo.updateManualCruiseVoFromEntity(e);
			cruiseVoList.add(manualCruiseVo);
		});
	}
	
	@Override
	public String toString() {
		return "TgQuotationRecorderVO [quotationId=" + quotationId + ", version=" + version + ", quotationName="
				+ quotationName + ", createdBy=" + createdBy + ", lastUpdatedBy=" + lastUpdatedBy + ", leadEntity="
				+ leadEntity + ", tourPackage=" + tourPackage + ",  flight=" + flight + ", hotel=" + hotel + ", transfers=" + transfers
				+ ", sightseeing=" + sightseeing + ", visa=" + visa + ", insurance=" + insurance + ", cruise=" + cruise
				+ ", others=" + others + ", getQuotationId()=" + getQuotationId() + ", getVersion()=" + getVersion()
				+ ", getQuotationName()=" + getQuotationName() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getLastUpdatedBy()=" + getLastUpdatedBy() + ", getLeadEntity()=" + getLeadEntity()
				+ ", toString()=" + super.toString() + ", isTourPackage()=" + isTourPackage() + ", isFlight()=" + isFlight()
				+ ", isHotel()=" + isHotel() + ", isTransfers()=" + isTransfers() + ", isSightseeing()="
				+ isSightseeing() + ", isVisa()=" + isVisa() + ", isInsurance()=" + isInsurance() + ", isCruise()="
				+ isCruise() + ", isOthers()=" + isOthers() + ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()="
				+ getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public Set<ManualFlightQuotationVO> getManualQuotationsVoList() {
		return manualQuotationsVoList;
	}

	public void setManualQuotationsVoList(SortedSet<ManualFlightQuotationVO> manualQuotationsVoList) {
		this.manualQuotationsVoList = manualQuotationsVoList;
	}

	public SortedSet<ManualHotelQuotationVO> getHotelVoList() {
		return hotelVoList;
	}

	public void setHotelVoList(SortedSet<ManualHotelQuotationVO> hotelVoList) {
		this.hotelVoList = hotelVoList;
	}

	public SortedSet<ManualTransferQuotationVO> getTransferVoList() {
		return transferVoList;
	}

	public void setTransferVoList(SortedSet<ManualTransferQuotationVO> transferVoList) {
		this.transferVoList = transferVoList;
	}

	public SortedSet<ManualSightSeeingQuotationVO> getSightSeeingVoList() {
		return sightSeeingVoList;
	}

	public void setSightSeeingVoList(SortedSet<ManualSightSeeingQuotationVO> sightSeeingVoList) {
		this.sightSeeingVoList = sightSeeingVoList;
	}

	public SortedSet<ManualVisaQuotationVO> getVisaVoList() {
		return visaVoList;
	}

	public void setVisaVoList(SortedSet<ManualVisaQuotationVO> visaVoList) {
		this.visaVoList = visaVoList;
	}

	public SortedSet<ManualPackageQuotationVO> getTourPackageVoList() {
		return tourPackageVoList;
	}

	public void setTourPackageVoList(SortedSet<ManualPackageQuotationVO> tourPackageVoList) {
		this.tourPackageVoList = tourPackageVoList;
	}

	public SortedSet<ManualOtherQuotationVO> getOtherVoList() {
		return otherVoList;
	}

	public void setOtherVoList(SortedSet<ManualOtherQuotationVO> otherVoList) {
		this.otherVoList = otherVoList;
	}

	public SortedSet<ManualInsuranceQuotationVO> getInsuranceVoList() {
		return insuranceVoList;
	}

	public void setInsuranceVoList(SortedSet<ManualInsuranceQuotationVO> insuranceVoList) {
		this.insuranceVoList = insuranceVoList;
	}

	public SortedSet<ManualCruiseQuotationVO> getCruiseVoList() {
		return cruiseVoList;
	}

	public void setCruiseVoList(SortedSet<ManualCruiseQuotationVO> cruiseVoList) {
		this.cruiseVoList = cruiseVoList;
	}

	public int getHotelOptionNo() {
		return hotelOptionNo;
	}

	public void setHotelOptionNo(int hotelOptionNo) {
		this.hotelOptionNo = hotelOptionNo;
	}

	public Map<Integer, List<ManualHotelQuotationVO>> getHotelOptionsWiseMap() {
		return hotelOptionsWiseMap;
	}

	public void setHotelOptionsWiseMap(Map<Integer, List<ManualHotelQuotationVO>> hotelOptionsWiseMap) {
		this.hotelOptionsWiseMap = hotelOptionsWiseMap;
	}

	

	
}
