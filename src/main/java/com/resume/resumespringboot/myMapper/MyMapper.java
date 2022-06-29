package com.resume.resumespringboot.myMapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@org.apache.ibatis.annotations.Mapper
public interface MyMapper <T> extends Mapper<T>, MySqlMapper<T> {
}
