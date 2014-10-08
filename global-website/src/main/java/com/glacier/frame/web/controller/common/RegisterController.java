package com.glacier.frame.web.controller.common; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView; 
import com.glacier.core.controller.AbstractController; 
import com.glacier.frame.service.website.WebsiteNavService; 

@Controller
public class RegisterController extends AbstractController { 
    
    @Autowired
	private WebsiteNavService NavService;//注入网站导航业务类
  
    // 转到“关于我们”页面
    @RequestMapping(value = "/aboutUs.htm")
    public Object aboutUs() {
        return "about_mgr/aboutUs";
    }

    // 转到“招纳贤士”页面
    @RequestMapping(value = "/hiring.htm")
    public Object hiring() {
        return "about_mgr/hiring";
    }

    // 转到“联系我们”页面
    @RequestMapping(value = "/contactUs.htm")
    public Object contactUs() {
    	ModelAndView mav = new ModelAndView("about_mgr/contactUs");
        return mav;
    }

    // 转到“新手引导、借款流程”页面
    @RequestMapping(value = "/borrowingProcess.htm")
    public Object borrowingProcess() {
        return "newbie_mgr/borrowingProcess";
    }

    // 转到“投资流程”页面
    @RequestMapping(value = "/investmentProcess.htm")
    public Object investmentProcess() {
        return "newbie_mgr/investmentProcess";
    }

    // 转到“风险保障”页面
    @RequestMapping(value = "/riskGuarantee.htm")
    public Object riskGuarantee() {
        return "newbie_mgr/riskGuarantee";
    }

    // 转到“我要借款”页面
    @RequestMapping(value = "/borrow.htm")
    public Object borrow() {
        return "borrow_mgr/borrow";
    }

    // 转到'找回密码'页面
    @RequestMapping(value = "/retrievePasswordEmail.htm")
    public String retrievePasswordEmail() {
        return "retrievePassword/retrievePasswordEmail";
    }
}
