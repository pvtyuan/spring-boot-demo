package com.example.mapper.secondary;

import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface CompanyMapper {
    String getNameById(Integer id);
    void  updateNameById(Integer id);
}
