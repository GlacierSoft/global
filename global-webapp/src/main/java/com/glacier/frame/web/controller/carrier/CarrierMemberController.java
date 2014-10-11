package com.glacier.frame.web.controller.carrier;
 
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView; 
import com.glacier.core.controller.AbstractController;
import com.glacier.frame.dto.query.carrier.CarrierMemberQueryDTO;
import com.glacier.frame.entity.carrier.CarrierMember;
import com.glacier.frame.service.carrier.CarrierMemberService;
import com.glacier.jqueryui.util.JqPager;  

/*** 
 * @ClassName:  CarrierMemberController
 * @Description: TODO(承运商会员controller)
 * @author songjundong
 * @email 985776597@QQ.com
 * @date 2014-10-11  下午2:09:10
 */
@Controller
@RequestMapping(value = "/carrierMember")
public class CarrierMemberController extends AbstractController{

	@Autowired
	private CarrierMemberService carriermemberService;
	
	// 进入会员列表展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPmember() {
        ModelAndView mav = new ModelAndView("carrier_mgr/carrierMember_mgr/carrierMember");
        return mav;
    } 
      
    // 查询显示所有的承运商会员信息
    @RequestMapping(value = "/list.json", method = RequestMethod.POST)
    @ResponseBody
    private Object listActionAsGridByMenuId(JqPager jqPager, CarrierMemberQueryDTO memberQueryDTO, String q) {
        return carriermemberService.listAsGrid(jqPager, memberQueryDTO, q);
    }
      
    // 进入会员Detail信息页面
    @RequestMapping(value = "/intoDetail.htm")
    private Object intoMemberDetailPage(String carrierMemberId) { 
    	ModelAndView mav=null;  
    	if(StringUtils.isNotBlank(carrierMemberId)){
    		  List<Object> list=carriermemberService.getMember(carrierMemberId);
    	      //进行个体和企业会员信息页面切换
    	      CarrierMember carrierMember= (CarrierMember)list.get(0);
    	      if(carrierMember.getMemberType().equals("individuality")){ //个人会员
    	    	  mav = new ModelAndView("carrier_mgr/carrierMember_mgr/carrierIndividualityMember_detail");
	      		  mav.addObject("individualityMemberData", list.get(1));
	      	  }else{  //企业、集团会员
	        	  mav = new ModelAndView("carrier_mgr/carrierMember_mgr/carrierEnterpriseMember_detail");
        		  mav.addObject("enterpriseMemberData", list.get(1)); 
        	  }
    	       mav.addObject("carrierMemberData", list.get(0));  
	     }
	     return mav;
    }
    
    // 启用、禁用会员
    @RequestMapping(value = "/status.json", method = RequestMethod.POST)
    @ResponseBody
    private Object updateStatus(String  memberId) {
    	return carriermemberService.upStatus(memberId); 
    } 
    
}
