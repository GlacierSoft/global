package com.glacier.frame.dao.member;

import com.glacier.frame.entity.member.ShipperMember;
import com.glacier.frame.entity.member.ShipperMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShipperMemberMapper {
    int countByExample(ShipperMemberExample example);

    int deleteByExample(ShipperMemberExample example);

    int deleteByPrimaryKey(String memberId);

    int insert(ShipperMember record);

    int insertSelective(ShipperMember record);

    List<ShipperMember> selectByExample(ShipperMemberExample example);

    ShipperMember selectByPrimaryKey(String memberId);

    int updateByExampleSelective(@Param("record") ShipperMember record, @Param("example") ShipperMemberExample example);

    int updateByExample(@Param("record") ShipperMember record, @Param("example") ShipperMemberExample example);

    int updateByPrimaryKeySelective(ShipperMember record);

    int updateByPrimaryKey(ShipperMember record);
}