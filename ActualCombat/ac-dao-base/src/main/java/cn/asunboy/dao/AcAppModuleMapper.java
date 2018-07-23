package cn.asunboy.dao;

import cn.asunboy.entity.AcAppModule;
import cn.asunboy.entity.AcAppModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AcAppModuleMapper {
    int countByExample(AcAppModuleExample example);

    int deleteByExample(AcAppModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AcAppModule record);

    int insertSelective(AcAppModule record);

    List<AcAppModule> selectByExample(AcAppModuleExample example);

    AcAppModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AcAppModule record, @Param("example") AcAppModuleExample example);

    int updateByExample(@Param("record") AcAppModule record, @Param("example") AcAppModuleExample example);

    int updateByPrimaryKeySelective(AcAppModule record);

    int updateByPrimaryKey(AcAppModule record);
}