package asunboy.service.lock.mapper;

import asunboy.service.lock.mapper.AppExample;
import asunboy.service.lock.model.App;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppMapper {
    long countByExample(AppExample example);

    int deleteByExample(AppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(App record);

    int insertSelective(App record);

    App selectOneByExample(AppExample example);

    List<App> selectByExample(AppExample example);

    App selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    int batchInsert(@Param("list") Collection<? extends App> list);

    int batchInsertSelective(@Param("list") Collection<? extends App> list, @Param("selective") App.Column ... selective);

    int updateBySelectiveBatch(@Param("list") Collection<? extends App> collection, @Param("selective") App.Column ... selective);

    int updateBatch(Collection<? extends App> collection);

    int updateNullByExampleSelective(@Param("example") AppExample example, @Param("columns") App.Column ... columns);
}