package cn.asunboy.dao;

import cn.asunboy.entity.AcLoginType;
import cn.asunboy.entity.AcLoginTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcLoginTypeMapper {
    int countByExample(AcLoginTypeExample example);

    int deleteByExample(AcLoginTypeExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(AcLoginType record);

    int insertSelective(AcLoginType record);

    List<AcLoginType> selectByExample(AcLoginTypeExample example);

    AcLoginType selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") AcLoginType record, @Param("example") AcLoginTypeExample example);

    int updateByExample(@Param("record") AcLoginType record, @Param("example") AcLoginTypeExample example);

    int updateByPrimaryKeySelective(AcLoginType record);

    int updateByPrimaryKey(AcLoginType record);
}