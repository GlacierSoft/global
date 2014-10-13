/**
 * @Title: CarrierContractService.java 
 * @Package com.glacier.frame.service.carrier 
 * @author junjie.zheng  
 * @email 1203807137@qq.com
 * @date 2014-10-11 下午1:32:04 
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
 * @Review (审核人) ：xichao.dong
 * 
 */
package com.glacier.frame.service.carrier;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.glacier.frame.dao.carrier.CarrierContractRecordMapper;
import com.glacier.frame.dto.query.carrier.CarrierContractRecordQueryDTO;
import com.glacier.frame.entity.carrier.CarrierContractRecord;
import com.glacier.frame.entity.carrier.CarrierContractRecordExample;
import com.glacier.frame.entity.carrier.CarrierContractRecordExample.Criteria;
import com.glacier.jqueryui.util.JqGridReturn;
import com.glacier.jqueryui.util.JqPager;

/**
 * @ClassName: CarrierContractService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author junjie.zheng
 * @email 1203807137@qq.com
 * @date 2014-10-11 下午1:32:04
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CarrierContractRecordService {
	/**
     * @Title: listAsGrid 
     * @Description: TODO(获取所有承运商合同记录信息) 
     * @param @param padvertisementr,contractRecordQueryDTO,q
     * @param @return    设定文件 
     * @return Object    返回类型 
     * @throws
     */ 
	@Autowired
	private CarrierContractRecordMapper carrierContractRecordMapper;
	
	
	public Object listAsGrid(JqPager jqPager, CarrierContractRecordQueryDTO contractRecordQueryDTO, String q) {
	    JqGridReturn returnResult = new JqGridReturn();
	    CarrierContractRecordExample carrierContractRecordExample = new CarrierContractRecordExample();
	    Criteria queryCriteria = carrierContractRecordExample.createCriteria();
	    contractRecordQueryDTO.setQueryCondition(queryCriteria, q);
	    if (null != jqPager.getPage() && null != jqPager.getRows()) {// 设置排序信息
	    	carrierContractRecordExample.setLimitStart((jqPager.getPage() - 1) * jqPager.getRows());
	    	carrierContractRecordExample.setLimitEnd(jqPager.getRows());
	    }
	    if (StringUtils.isNotBlank(jqPager.getSort()) && StringUtils.isNotBlank(jqPager.getOrder())) {// 设置排序信息
	    	carrierContractRecordExample.setOrderByClause(jqPager.getOrderBy("temp_carrier_contract_record_"));
	    }
	    List<CarrierContractRecord>  shipperMemberContractRecords = carrierContractRecordMapper.selectByExample(carrierContractRecordExample); // 查询所有广告列表
	    int total = carrierContractRecordMapper.countByExample(carrierContractRecordExample); // 查询总页数
	    returnResult.setRows(shipperMemberContractRecords);
	    returnResult.setTotal(total);
	    return returnResult;// 返回ExtGrid表
	 }
     
   /**
    * 
    * @Title: getContractPro 
    * @Description: TODO(获取承运商合同记录对象) 
    * @param  @param contractRecordId
    * @param  @return
    * @throws 
    * 备注<p>已检查测试:Green<p>
    */
	public Object getCarrierContractPro(String contractRecordId) {
	    CarrierContractRecord carrierContractRecord = carrierContractRecordMapper.selectByPrimaryKey(contractRecordId);
		return carrierContractRecord;
	}
	
	
}
