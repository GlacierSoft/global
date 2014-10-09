package com.glacier.frame.web.controller.contract;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/contractManager")
public class ContractManagerController {

    // 进入合同管理展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPservice() {
        ModelAndView mav = new ModelAndView("member_mgr/contractManager_mgr/contractManager");
        return mav;
    }
    
  
}