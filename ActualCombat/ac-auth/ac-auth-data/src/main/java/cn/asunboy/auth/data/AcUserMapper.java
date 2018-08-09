package cn.asunboy.auth.data;

import cn.asunboy.auth.entity.AcUser;
import cn.asunboy.auth.entity.AcUserExample;
import java.util.List;

import cn.asunboy.lang.ModifiedOnSupport;
import cn.asunboy.lang.VersionSupport;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AcUserMapper{
    int countByExample(AcUserExample example);

    int deleteByExample(AcUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcUser record);

    int insertSelective(AcUser record);

    List<AcUser> selectByExampleWithBLOBs(AcUserExample example);

    List<AcUser> selectByExample(AcUserExample example);

    AcUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcUser record, @Param("example") AcUserExample example);

    int updateByExampleWithBLOBs(@Param("record") AcUser record, @Param("example") AcUserExample example);

    int updateByExample(@Param("record") AcUser record, @Param("example") AcUserExample example);

    int updateByPrimaryKeySelective(AcUser record);

    int updateByPrimaryKeyWithBLOBs(AcUser record);

    int updateByPrimaryKey(AcUser record);
}