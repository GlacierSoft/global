package com.glacier.frame.service.member;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.frame.dao.member.ShipperMemberBankCardMapper;
import com.glacier.frame.dto.query.member.ShipperMemberBankCardQueryDTO;
import com.glacier.frame.entity.member.MemberContractType;
import com.glacier.frame.entity.member.ShipperMemberBankCard;
import com.glacier.frame.entity.member.ShipperMemberBankCardExample;
import com.glacier.frame.entity.member.ShipperMemberBankCardExample.Criteria;
import com.glacier.frame.entity.system.User;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;
import com.glacier.jqueryui.util.JqReturnJson;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ShipperMemberBankCardService {
	
	@Autowired
    private ShipperMemberBankCardMapper shipperMemberBankCardMapper;
	  
	public Object listAsGrid(JqPager padvertisementr, ShipperMemberBankCardQueryDTO shipperMemberBankCardQueryDTO, String q) {
	        JqGridReturn returnResult = new JqGridReturn();
	        ShipperMemberBankCardExample shipperMemberBankCardExample = new ShipperMemberBankCardExample();
	        Criteria queryCriteria = shipperMemberBankCardExample.createCriteria();
	        shipperMemberBankCardQueryDTO.setQueryCondition(queryCriteria, q);
	        if (null != padvertisementr.getPage() && null != padvertisementr.getRows()) {// 设置排序信息
	        	shipperMemberBankCardExample.setLimitStart((padvertisementr.getPage() - 1) * padvertisementr.getRows());
	        	shipperMemberBankCardExample.setLimitEnd(padvertisementr.getRows());
	        }
	        if (StringUtils.isNotBlank(padvertisementr.getSort()) && StringUtils.isNotBlank(padvertisementr.getOrder())) {// 设置排序信息
	        	shipperMemberBankCardExample.setOrderByClause(padvertisementr.getOrderBy("temp_shipper_member_bank_card_"));
	        }
	        List<ShipperMemberBankCard>  shipperMemberContractRecords = shipperMemberBankCardMapper.selectByExample(shipperMemberBankCardExample); // 查询所有广告列表
	        int total = shipperMemberBankCardMapper.countByExample(shipperMemberBankCardExample); // 查询总页数
	        returnResult.setRows(shipperMemberContractRecords);
	        returnResult.setTotal(total);
	        return returnResult;// 返回ExtGrid表
	    }
	
	public Object getBankCardPro(String bankCardId) {
	    ShipperMemberBankCard shipperMemberBankCard = shipperMemberBankCardMapper.selectByPrimaryKey(bankCardId);
		return shipperMemberBankCard;
    }
	
    @Transactional(readOnly = false)
    public Object auditBankCard(ShipperMemberBankCard shipperMemberBankCard) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        String type_name=shipperMemberBankCard.getMemberDisplay();
        Subject pricipalSubject = SecurityUtils.getSubject();
        User pricipalUser = (User) pricipalSubject.getPrincipal();
        shipperMemberBankCard.setUpdater(pricipalUser.getUserId());
        shipperMemberBankCard.setUpdateTime(new Date());
        count = shipperMemberBankCardMapper.updateByPrimaryKeySelective(shipperMemberBankCard);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("信用卡审核操作成功!");
        } else {
        	returnResult.setMsg("信用卡审核操作失败!");
        }
        return returnResult;
    }

}