package cn.asunboy.dao;

import cn.asunboy.entity.AcSession;
import cn.asunboy.entity.AcSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcSessionMapper {
    int countByExample(AcSessionExample example);

    int deleteByExample(AcSessionExample example);

    int deleteByPrimaryKey(String token);

    int insert(AcSession record);

    int insertSelective(AcSession record);

    List<AcSession> selectByExample(AcSessionExample example);

    AcSession selectByPrimaryKey(String token);

    int updateByExampleSelective(@Param("record") AcSession record, @Param("example") AcSessionExample example);

    int updateByExample(@Param("record") AcSession record, @Param("example") AcSessionExample example);

    int updateByPrimaryKeySelective(AcSession record);

    int updateByPrimaryKey(AcSession record);
}