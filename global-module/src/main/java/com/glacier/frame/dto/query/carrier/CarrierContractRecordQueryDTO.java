package com.glacier.frame.dto.query.carrier;

import java.util.Date;

import com.glacier.frame.entity.carrier.CarrierContractRecord;
import com.glacier.frame.entity.carrier.CarrierContractRecordExample.Criteria;


public class CarrierContractRecordQueryDTO extends CarrierContractRecord  {
	 
	   private Date contractTypeStartTime;
	   
	   private Date contractTypeEndTime;
	   
	   private  Date contractRemoveStartTime;
	   
	   private  Date contractTypeRemoveEndEndTime;

	public Date getContractTypeStartTime() {
		return contractTypeStartTime;
	}

	public void setContractTypeStartTime(Date contractTypeStartTime) {
		this.contractTypeStartTime = contractTypeStartTime;
	}

	public Date getContractTypeEndTime() {
		return contractTypeEndTime;
	}

	public void setContractTypeEndTime(Date contractTypeEndTime) {
		this.contractTypeEndTime = contractTypeEndTime;
	}

	public Date getContractRemoveStartTime() {
		return contractRemoveStartTime;
	}

	public void setContractRemoveStartTime(Date contractRemoveStartTime) {
		this.contractRemoveStartTime = contractRemoveStartTime;
	}

	public Date getContractTypeRemoveEndEndTime() {
		return contractTypeRemoveEndEndTime;
	}

	public void setContractTypeRemoveEndEndTime(Date contractTypeRemoveEndEndTime) {
		this.contractTypeRemoveEndEndTime = contractTypeRemoveEndEndTime;
	}
	   
	
	public void setQueryCondition(Criteria queryCriteria, String q){
		
		if(null != this.getStatus()){//状态Enum查询
	        queryCriteria.andStatusEqualTo(this.getStatus().toString());
	   	}
		
		if(null!=contractTypeStartTime&&null!=contractTypeEndTime){//创建时间段查询
	    	 queryCriteria.andEnableTimeBetween(contractTypeStartTime, contractTypeEndTime);
	      }else{
	    	 if(null != contractTypeStartTime){
	              queryCriteria.andEnableTimeGreaterThanOrEqualTo(contractTypeStartTime);
	          }
	          if(null != contractTypeEndTime){
	              queryCriteria.andEnableTimeLessThanOrEqualTo(contractTypeEndTime);
	          }
	     }
	     
	     if(null!=contractRemoveStartTime&&null!=contractTypeRemoveEndEndTime){//创建时间段查询
	    	 queryCriteria.andDisableTimeBetween(contractRemoveStartTime, contractTypeRemoveEndEndTime);
	      }else{
	    	 if(null != contractRemoveStartTime){
	              queryCriteria.andDisableTimeGreaterThanOrEqualTo(contractRemoveStartTime);
	          }
	          if(null != contractRemoveStartTime){
	              queryCriteria.andDisableTimeLessThanOrEqualTo(contractRemoveStartTime);
	          }
	     }
	}
	   
}
