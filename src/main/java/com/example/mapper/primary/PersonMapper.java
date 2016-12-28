package com.example.mapper.primary;

import com.example.entity.primary.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {
    Person getById(Integer id);
    void  updateNameById(Integer id, String name);
}
