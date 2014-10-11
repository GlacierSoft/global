/**
 * @Title: CarrierContractController.java 
 * @Package com.glacier.frame.web.controller.carrier 
 * @author junjie.zheng  
 * @email 1203807137@qq.com
 * @date 2014-10-11 上午9:58:30 
 * @company (开发公司)    珠海市冰川软件有限公司
 * @copyright (版权)    本文件归属珠海市冰川软件有限公司所有
 * @version V1.0
 * @modify (修改) 
 *        	<p>
				第一次修改：
				时间：2014-10-11
				修改人：xichao.dong 
				修改内容简介 ：
			</p>              
 * @Review (审核人) ：郑俊杰
 * 
 */
package com.glacier.frame.web.controller.carrier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: CarrierContractController 
 * @Description: TODO(承运商合同记录信息) 
 * @author junjie.zheng
 * @email 1203807137@qq.com
 * @date 2014-10-11 上午9:58:30
 */
@Controller
@RequestMapping(value="/carrierContract")
public class CarrierContractController {
     
	
	//进入承运商合同记录展示页面
    @RequestMapping(value = "/index.htm")
    private Object intoIndexPservice() {
        ModelAndView mav = new ModelAndView("carrier_mgr/carrierContract_mgr/carrierContract");
        return mav;
    }
}
