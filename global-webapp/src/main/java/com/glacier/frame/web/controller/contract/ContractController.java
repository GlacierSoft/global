package com.glacier.frame.web.controller.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.glacier.frame.service.contract.ContractService;
import com.glacier.jqueryui.util.JqPager;


@Controller
@RequestMapping(value="/contract")
public class ContractController {
	
	
   // 进入合同记录展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPservice() {
        ModelAndView mav = new ModelAndView("member_mgr/contract_mgr/contract");
        return mav;
    }
    
}
