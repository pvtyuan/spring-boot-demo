package com.example.service;

import com.example.entity.primary.Person;
import com.example.exception.InternalException;
import com.example.mapper.primary.PersonMapper;
import com.example.repository.primary.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper personMapper;

    public String getName(Integer id) {
        return personMapper.getNameById(id);
    }


    @Transactional
    public String getName2(int i) {
        Person person = new Person();
        person.setName("bbb");
        repository.save(person);
        if (i == 1) throw new InternalException();
        personMapper.updateNameById(person.getId());
        if (i == 2 ) throw new InternalException();
        return "ok";
    }
}
