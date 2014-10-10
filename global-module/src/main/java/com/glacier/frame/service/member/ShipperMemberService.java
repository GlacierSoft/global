/**
 * @Title: ShipperMemberService.java 
 * @Package com.glacier.global.service.member
 * @author songjundong   
 * @email 985776597@qq.com
 * @date 2014-10-08 下午1:40:53
 * @company (开发公司)    珠海市冰川软件有限公司
 * @copyright (版权)    本文件归属珠海市冰川软件有限公司所有
 * @version V1.00          
 * @Review (审核人) ：songjundong
 * 
 */
package com.glacier.frame.service.member; 
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional; 

import com.glacier.frame.dao.member.ShipperEnterpriseMemberMapper;
import com.glacier.frame.dao.member.ShipperIndividualityMemberMapper;
import com.glacier.frame.dao.member.ShipperMemberMapper; 
import com.glacier.frame.dto.query.member.ShipperMemberQueryDTO; 
import com.glacier.frame.entity.member.ShipperMember;
import com.glacier.frame.entity.member.ShipperMemberExample; 
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager; 
import com.glacier.jqueryui.util.JqReturnJson;
import com.glacier.frame.entity.member.ShipperMemberExample.Criteria;
/*** 
 * @ClassName:  ShipperMemberService
 * @Description: TODO(货主会员表业务类)
 * @author songjundong
 * @email 985776597@QQ.com
 * @date 2014-10-08 下午1:40:53
 */
@Service
@Transactional(readOnly = true ,propagation = Propagation.REQUIRED)
public class ShipperMemberService {

	@Autowired
	private ShipperMemberMapper shipperMemberMapper;
	
	@Autowired
	private ShipperEnterpriseMemberMapper shipperEnterpriseMemberMapper;
    
	@Autowired
	private ShipperIndividualityMemberMapper shipperIndividualityMemberMapper;
	
	/**
     * @Title: listAsGrid 
     * @Description: TODO(获取所有会员信息) 
     * @param @param pager
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */ 
    public Object listAsGrid(JqPager jqPager, ShipperMemberQueryDTO memberQueryDTO, String q) {
        JqGridReturn returnResult = new JqGridReturn();
        ShipperMemberExample memberExample = new ShipperMemberExample(); 
        Criteria queryCriteria = memberExample.createCriteria();
        memberQueryDTO.setQueryCondition(queryCriteria, q); 
        if (null != jqPager.getPage() && null != jqPager.getRows()) {// 设置排序信息
        	memberExample.setLimitStart((jqPager.getPage() - 1) * jqPager.getRows());
        	memberExample.setLimitEnd(jqPager.getRows());
        }
        if (StringUtils.isNotBlank(jqPager.getSort()) && StringUtils.isNotBlank(jqPager.getOrder())) {// 设置排序信息
        	memberExample.setOrderByClause(jqPager.getOrderBy("temp_shipper_member_"));
        }
        List<ShipperMember>  shippermembers = shipperMemberMapper.selectByExample(memberExample); // 查询所有会员列表
        int total = shipperMemberMapper.countByExample(memberExample); // 查询总页数
        returnResult.setRows(shippermembers);
        returnResult.setTotal(total);
        return returnResult;// 返回ExtGrid表
    }
     
    
    /**
	 * @Title: getMember 
	 * @Description: TODO(根据会员Id获取会员信息) 
	 * @param @param memberId
	 * @param @return    设定文件 
	 * @return Object    返回类型 
	 * @throws
	 */
    public List<Object> getMember(String memberId) {
    	List<Object> list=new ArrayList<Object>(); 
    	ShipperMember member = shipperMemberMapper.selectByPrimaryKey(memberId);
    	list.add(member);
    	 //根据会员类型，获取对应的数据，如果是个体会员，则查询个体的相关数据
    	if(member.getMemberType().equals("enterprise")){ //企业会员
    		list.add(shipperEnterpriseMemberMapper.selectByPrimaryKey(memberId));
    	}else{ //个体会员
    		list.add(shipperIndividualityMemberMapper.selectByPrimaryKey(memberId));
    	} 
        return list;
    } 
     
    
    /*** 
     * @Title: upStatus  
     * @Description: TODO(启用和禁用会员)  
     * @param @param shipperMemberId
     * @param @return    设定文件  
     * @return Object    返回类型  
     * @throws
     */ 
    @Transactional(readOnly = false)
    public Object upStatus(String shipperMemberId){
    	 JqReturnJson returnResult = new JqReturnJson();// 构建返回结果，默认结果为false
    	 ShipperMember shipperMember= shipperMemberMapper.selectByPrimaryKey(shipperMemberId);
    	 if(shipperMember.getStatus().equals("enable")){
    		 shipperMember.setStatus("disable");
    	 }else{
    		 shipperMember.setStatus("enable");
    	 } 
    	 int count = shipperMemberMapper.updateByPrimaryKeySelective(shipperMember);
    	 if(count == 1){
    		 returnResult.setSuccess(true);
    		 returnResult.setMsg("更改状态成功!");
    	 }else{
    		 returnResult.setMsg("发生未知错误，状态修改失败");
    	 }
    	return returnResult; 
    }
}
