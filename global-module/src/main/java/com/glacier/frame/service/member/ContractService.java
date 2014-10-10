/**
 * @Title: ContractService.java 
 * @Package com.glacier.global.service.member
 * @author zhengjunjie   
 * @email 1203807137@qq.com
 * @date 2014-10-08 下午1:40:53
 * @company (开发公司)    珠海市冰川软件有限公司
 * @copyright (版权)    本文件归属珠海市冰川软件有限公司所有
 * @version V1.00          
 * @Review (审核人) ：zhengjunjie
 * 
 */

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


/*** 
 * @ClassName:  ContractService
 * @Description: TODO(货主合同记录业务类)
 * @author zhengjunjie
 * @email 1203807137@QQ.com
 * @date 2014-10-08 下午1:40:53
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ContractService {
	
	@Autowired
    private ShipperMemberContractRecordMapper shipperMemberContractRecordMapper;
	  
	/**
     * @Title: listAsGrid 
     * @Description: TODO(获取所有会员合同记录信息) 
     * @param @param padvertisementr,contractRecordQueryDTO,q
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */ 
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
	
	/**
     * @Title: getContractPro 
     * @Description: TODO(获取单个会员合同记录信息) 
     * @param @param contractRecordId
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */ 
	public Object getContractPro(String contractRecordId) {
	    ShipperMemberContractRecord shipperMemberContractRecord = shipperMemberContractRecordMapper.selectByPrimaryKey(contractRecordId);
		return shipperMemberContractRecord;
	}
	
}
