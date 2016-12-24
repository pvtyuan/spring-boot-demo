package com.example.repository.secondary;

import com.example.entity.secondary.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Integer> {

    Company findById(Integer id);
}
