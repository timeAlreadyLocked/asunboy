package cn.asunboy.auth.data;

import cn.asunboy.auth.entity.AcLogin;
import cn.asunboy.auth.entity.AcLoginExample;
import cn.asunboy.auth.entity.AcLoginKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcLoginMapper {
    int countByExample(AcLoginExample example);

    int deleteByExample(AcLoginExample example);

    int deleteByPrimaryKey(AcLoginKey key);

    int insert(AcLogin record);

    int insertSelective(AcLogin record);

    List<AcLogin> selectByExample(AcLoginExample example);

    AcLogin selectByPrimaryKey(AcLoginKey key);

    int updateByExampleSelective(@Param("record") AcLogin record, @Param("example") AcLoginExample example);

    int updateByExample(@Param("record") AcLogin record, @Param("example") AcLoginExample example);

    int updateByPrimaryKeySelective(AcLogin record);

    int updateByPrimaryKey(AcLogin record);
}