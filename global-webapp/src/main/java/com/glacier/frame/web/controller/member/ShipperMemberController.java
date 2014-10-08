package com.glacier.frame.web.controller.member;
 
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glacier.core.controller.AbstractController;
import com.glacier.jqueryui.util.JqPager; 
import com.glacier.frame.dto.query.member.ShipperMemberQueryDTO;
import com.glacier.frame.entity.member.ShipperMember;
import com.glacier.frame.service.member.ShipperMemberService;

/*** 
 * @ClassName:  ShipperMemberController
 * @Description: TODO(货主会员controller)
 * @author songjundong
 * @email 985776597@QQ.com
 * @date 2014-10-08  下午2:09:10
 */
@Controller
@RequestMapping(value = "/shippermember")
public class ShipperMemberController extends AbstractController{

	@Autowired
	private ShipperMemberService shippermemberService;
	
	// 进入会员列表展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPmember() {
        ModelAndView mav = new ModelAndView("member_mgr/shipperMember_mgr/shipperMember");
        return mav;
    } 
     
    
    // 获取表格结构的所有菜单数据
    @RequestMapping(value = "/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listActionAsGridByMenuId(JqPager jqPager, ShipperMemberQueryDTO memberQueryDTO, String q) {
        return shippermemberService.listAsGrid(jqPager, memberQueryDTO, q);
    }
      
    // 进入会员Detail信息页面
    @RequestMapping(value = "/intoDetail.htm")
    private Object intoMemberDetailPage(String memberId) { 
    	ModelAndView mav=null;  
    	if(StringUtils.isNotBlank(memberId)){
    		  List<Object> list=shippermemberService.getMember(memberId);
    	      //进行个体和企业会员信息页面切换
    	      ShipperMember shipperMember= (ShipperMember)list.get(0);
    	      if(shipperMember.getMemberType().equals("enterprise")){ //企业会员
        		  mav = new ModelAndView("member_mgr/shipperMember_mgr/shipperEnterpriseMember_detail");
        		  mav.addObject("enterpriseMemberData", list.get(1));
	           }else{  //个体会员
	        	  mav = new ModelAndView("member_mgr/shipperMember_mgr/shipperIndividualityMember_detail");
	      		  mav.addObject("individualityMemberData", list.get(1));
	           }
    	       mav.addObject("shipperMemberData", list.get(0));  
	     }
	     return mav;
    }
    
    
    
}
