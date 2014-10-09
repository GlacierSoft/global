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


import com.glacier.basic.util.RandomGUID;
import com.glacier.frame.dao.member.MemberContractTypeMapper;
import com.glacier.frame.entity.member.MemberContractType;
import com.glacier.frame.entity.member.MemberContractTypeExample;
import com.glacier.frame.entity.system.User;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;
import com.glacier.jqueryui.util.JqReturnJson;


@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ContractManagerService {
	
	@Autowired
    private MemberContractTypeMapper memberContractTypeMapper;

    public Object listAsGrid(JqPager padvertisementr) {
        JqGridReturn returnResult = new JqGridReturn();
        MemberContractTypeExample memberContractTypExample = new MemberContractTypeExample();
        if (null != padvertisementr.getPage() && null != padvertisementr.getRows()) {// 设置排序信息
        	memberContractTypExample.setLimitStart((padvertisementr.getPage() - 1) * padvertisementr.getRows());
        	memberContractTypExample.setLimitEnd(padvertisementr.getRows());
        }
        if (StringUtils.isNotBlank(padvertisementr.getSort()) && StringUtils.isNotBlank(padvertisementr.getOrder())) {// 设置排序信息
        	memberContractTypExample.setOrderByClause(padvertisementr.getOrderBy("temp_member_contract_type_"));
        }
        List<MemberContractType>  memberContractTypes = memberContractTypeMapper.selectByExample(memberContractTypExample); // 查询所有广告列表
        int total = memberContractTypeMapper.countByExample(memberContractTypExample); // 查询总页数
        returnResult.setRows(memberContractTypes);
        returnResult.setTotal(total);
        return returnResult;// 返回ExtGrid表
    }
	
    public Object getContractManager(String contractTypeId) {
    	MemberContractType accountInvest = memberContractTypeMapper.selectByPrimaryKey(contractTypeId);
		return accountInvest;
	}
    
    @Transactional(readOnly = false)
    public Object addContractManager(MemberContractType memberContractType) {
        Subject pricipalSubject = SecurityUtils.getSubject();
        User pricipalUser = (User) pricipalSubject.getPrincipal(); 
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        memberContractType.setContractTypeId(RandomGUID.getRandomGUID());
        memberContractType.setCreater(pricipalUser.getUserId());
        memberContractType.setCreateTime(new Date());
        memberContractType.setUpdater(pricipalUser.getUserId());
        memberContractType.setUpdateTime(new Date());
        int count=0;
        count = memberContractTypeMapper.insert(memberContractType);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("新增合同类型操作成功");
        } else {
            returnResult.setMsg("发生未知错误，新增合同类型保存失败");
        }
        return returnResult;
    }
    
    @Transactional(readOnly = false)
    public Object editContractManager(MemberContractType memberContractType) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        Subject pricipalSubject = SecurityUtils.getSubject();
        User pricipalUser = (User) pricipalSubject.getPrincipal();
        memberContractType.setUpdater(pricipalUser.getUserId());
        memberContractType.setUpdateTime(new Date());
        count = memberContractTypeMapper.updateByPrimaryKeySelective(memberContractType);
        if (count == 1) {
            returnResult.setSuccess(true);
            returnResult.setMsg("合同类型修改操作成功");
         } else {
            returnResult.setMsg("发生未知错误，合同类型信息修改失败");
        }
        return returnResult;
    }
    
    @Transactional(readOnly = false)
    public Object delContractManager(List<String> contractTypeIds) {
    	JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        if (contractTypeIds.size() > 0) {
        	MemberContractTypeExample memberContractTypeExample = new MemberContractTypeExample();
        	memberContractTypeExample.createCriteria().andContractTypeIdIn(contractTypeIds);
            count = memberContractTypeMapper.deleteByExample(memberContractTypeExample);
            if (count > 0) {
                returnResult.setSuccess(true);
                returnResult.setMsg("成功删除了合同类型信息");
            } else {
                returnResult.setMsg("发生未知错误，合同类型信息删除失败");
            }
        }
        return returnResult;
    }
    
    
    @Transactional(readOnly = false)
    public Object auditWithdrawSet(MemberContractType memberContractType) {
        JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
        int count = 0;
        String type_name=memberContractType.getContractTypeName();
        Subject pricipalSubject = SecurityUtils.getSubject();
        User pricipalUser = (User) pricipalSubject.getPrincipal();
        memberContractType.setUpdater(pricipalUser.getUserId());
        memberContractType.setUpdateTime(new Date());
        count = memberContractTypeMapper.updateByPrimaryKeySelective(memberContractType);
        if (count == 1) {
            returnResult.setSuccess(true);
            if(memberContractType.getStatus().equals("enable"))
            	 returnResult.setMsg("【"+type_name+"】合同类型启用操作成功!");
            else
            	 returnResult.setMsg("【"+type_name+"】合同类型禁用操作成功!");
        } else {
        	 if(memberContractType.getStatus().equals("enable"))
        		 returnResult.setMsg("发生未知错误，【"+type_name+"】合同类型启用操作失败!");
            else
            	 returnResult.setMsg("发生未知错误，【"+type_name+"】合同类型禁用操作失败!");
            
        }
        return returnResult;
    }
	
}
