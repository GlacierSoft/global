package com.glacier.frame.dto.query.member;



import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.glacier.frame.entity.member.ShipperMemberContractRecord;
import com.glacier.frame.entity.member.ShipperMemberContractRecordExample.Criteria;


public class ShipperMemberContractRecordQueryDTO extends ShipperMemberContractRecord {
    
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
		
		if(null!=contractTypeStartTime&&null!=contractTypeEndTime){//创建时间段查询
	    	 queryCriteria.andOperationTimeBetween(contractTypeStartTime, contractTypeEndTime);
	      }else{
	    	 if(null != contractTypeStartTime){
	              queryCriteria.andOperationTimeGreaterThanOrEqualTo(contractTypeStartTime);
	          }
	          if(null != contractTypeEndTime){
	              queryCriteria.andOperationTimeLessThanOrEqualTo(contractTypeEndTime);
	          }
	     }
	     
	     if(null!=contractRemoveStartTime&&null!=contractTypeRemoveEndEndTime){//创建时间段查询
	    	 queryCriteria.andCloseTimeBetween(contractRemoveStartTime, contractTypeRemoveEndEndTime);
	      }else{
	    	 if(null != contractRemoveStartTime){
	              queryCriteria.andCloseTimeGreaterThanOrEqualTo(contractRemoveStartTime);
	          }
	          if(null != contractRemoveStartTime){
	              queryCriteria.andCloseTimeLessThanOrEqualTo(contractRemoveStartTime);
	          }
	     }
	    
	}
	
       @Override
	   public String toString() {
	       return ReflectionToStringBuilder.toString(this);
	   } 
}
