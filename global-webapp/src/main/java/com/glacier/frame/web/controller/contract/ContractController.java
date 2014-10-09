package com.glacier.frame.web.controller.contract;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glacier.frame.dto.query.member.ShipperMemberContractRecordQueryDTO;
import com.glacier.frame.service.member.ContractService;
import com.glacier.jqueryui.util.JqPager;


@Controller
@RequestMapping(value="/contract")
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	
   // 进入合同记录展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPservice() {
        ModelAndView mav = new ModelAndView("member_mgr/contract_mgr/contract");
        return mav;
    }
    
    //获取表格结构的所有菜单数据
   	@RequestMapping(value = "/list.json", method = RequestMethod.POST)
   	@ResponseBody
   	private Object listActionAsGridByMenuId(JqPager jqPager, ShipperMemberContractRecordQueryDTO contractRecordQueryDTO, String q) {
   	     return contractService.listAsGrid(jqPager, contractRecordQueryDTO, q);
   	}
   	
    //投资统计详情页
	@RequestMapping(value = "/intoDetail.htm")
	private Object intoContractManagerDetailPage(String contractRecordId) {
	     ModelAndView mav = new ModelAndView("member_mgr/contract_mgr/contract_detail");
	     if(StringUtils.isNotBlank(contractRecordId)){
	          mav.addObject("contractData", contractService.getContractPro(contractRecordId));
	     }
	     return mav;
	  }

}
