package com.glacier.frame.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/memberBankCard")
public class MemberBankCardController {
    
	@RequestMapping(value="index.htm")
	 private Object intoIndexPmember() {
      ModelAndView mav = new ModelAndView("member_mgr/bankCard_mgr/bankCard");
      return mav;
   }
}
