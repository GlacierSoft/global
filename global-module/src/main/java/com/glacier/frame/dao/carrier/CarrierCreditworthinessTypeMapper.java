package com.glacier.frame.dao.carrier;

import com.glacier.frame.entity.carrier.CarrierCreditworthinessType;
import com.glacier.frame.entity.carrier.CarrierCreditworthinessTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarrierCreditworthinessTypeMapper {
    int countByExample(CarrierCreditworthinessTypeExample example);

    int deleteByExample(CarrierCreditworthinessTypeExample example);

    int deleteByPrimaryKey(String creditworthinessTypeId);

    int insert(CarrierCreditworthinessType record);

    int insertSelective(CarrierCreditworthinessType record);

    List<CarrierCreditworthinessType> selectByExample(CarrierCreditworthinessTypeExample example);

    CarrierCreditworthinessType selectByPrimaryKey(String creditworthinessTypeId);

    int updateByExampleSelective(@Param("record") CarrierCreditworthinessType record, @Param("example") CarrierCreditworthinessTypeExample example);

    int updateByExample(@Param("record") CarrierCreditworthinessType record, @Param("example") CarrierCreditworthinessTypeExample example);

    int updateByPrimaryKeySelective(CarrierCreditworthinessType record);

    int updateByPrimaryKey(CarrierCreditworthinessType record);
}