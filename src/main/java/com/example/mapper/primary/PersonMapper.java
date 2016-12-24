package com.example.mapper.primary;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    String getNameById(Integer id);
    void  updateNameById(Integer id);
}
