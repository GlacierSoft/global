package com.glacier.frame.service.member;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.frame.dao.member.ShipperMemberContractRecordMapper;
import com.glacier.frame.dto.query.member.ShipperMemberContractRecordQueryDTO;

import com.glacier.frame.entity.member.ShipperMemberContractRecord;
import com.glacier.frame.entity.member.ShipperMemberContractRecordExample;
import com.glacier.frame.entity.member.ShipperMemberContractRecordExample.Criteria;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ContractService {
	
	@Autowired
    private ShipperMemberContractRecordMapper shipperMemberContractRecordMapper;
	  
	public Object listAsGrid(JqPager padvertisementr, ShipperMemberContractRecordQueryDTO contractRecordQueryDTO, String q) {
	        JqGridReturn returnResult = new JqGridReturn();
	        ShipperMemberContractRecordExample shipperMemberContractRecordExample = new ShipperMemberContractRecordExample();
	        Criteria queryCriteria = shipperMemberContractRecordExample.createCriteria();
	        contractRecordQueryDTO.setQueryCondition(queryCriteria, q);
	        if (null != padvertisementr.getPage() && null != padvertisementr.getRows()) {// 设置排序信息
	        	shipperMemberContractRecordExample.setLimitStart((padvertisementr.getPage() - 1) * padvertisementr.getRows());
	        	shipperMemberContractRecordExample.setLimitEnd(padvertisementr.getRows());
	        }
	        if (StringUtils.isNotBlank(padvertisementr.getSort()) && StringUtils.isNotBlank(padvertisementr.getOrder())) {// 设置排序信息
	        	shipperMemberContractRecordExample.setOrderByClause(padvertisementr.getOrderBy("temp_shipper_member_contract_record_"));
	        }
	        List<ShipperMemberContractRecord>  shipperMemberContractRecords = shipperMemberContractRecordMapper.selectByExample(shipperMemberContractRecordExample); // 查询所有广告列表
	        int total = shipperMemberContractRecordMapper.countByExample(shipperMemberContractRecordExample); // 查询总页数
	        returnResult.setRows(shipperMemberContractRecords);
	        returnResult.setTotal(total);
	        return returnResult;// 返回ExtGrid表
	    }
	
	
	public Object getContractPro(String contractRecordId) {
		    ShipperMemberContractRecord shipperMemberContractRecord = shipperMemberContractRecordMapper.selectByPrimaryKey(contractRecordId);
			return shipperMemberContractRecord;
	}
	
}
