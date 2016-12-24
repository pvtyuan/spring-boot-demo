package com.example.repository.primary;

import com.example.entity.primary.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    Person findById(Integer id);
}
