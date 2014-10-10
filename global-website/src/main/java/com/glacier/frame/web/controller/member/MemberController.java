package com.glacier.frame.web.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.glacier.core.controller.AbstractController;

@Controller
@RequestMapping(value = "member")
public class MemberController extends AbstractController{

	// 进入会员个人主页展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexMember(HttpServletRequest request,HttpSession session) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
    
}
