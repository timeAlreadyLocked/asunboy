package org.asunboy.demo.datasource.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface CustomerMapper {
//    @Select("select * from hr limit 1")
    Map get();

    @Select("select * from hr limit 1")
    Map get2();

    @Select("select * from tenant limit 1")
    Map get3();
}
