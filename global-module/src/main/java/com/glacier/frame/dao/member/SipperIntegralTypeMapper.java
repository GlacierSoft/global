package com.glacier.frame.dao.member;

import com.glacier.frame.entity.member.SipperIntegralType;
import com.glacier.frame.entity.member.SipperIntegralTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SipperIntegralTypeMapper {
    int countByExample(SipperIntegralTypeExample example);

    int deleteByExample(SipperIntegralTypeExample example);

    int deleteByPrimaryKey(String integralTypeId);

    int insert(SipperIntegralType record);

    int insertSelective(SipperIntegralType record);

    List<SipperIntegralType> selectByExample(SipperIntegralTypeExample example);

    SipperIntegralType selectByPrimaryKey(String integralTypeId);

    int updateByExampleSelective(@Param("record") SipperIntegralType record, @Param("example") SipperIntegralTypeExample example);

    int updateByExample(@Param("record") SipperIntegralType record, @Param("example") SipperIntegralTypeExample example);

    int updateByPrimaryKeySelective(SipperIntegralType record);

    int updateByPrimaryKey(SipperIntegralType record);
}