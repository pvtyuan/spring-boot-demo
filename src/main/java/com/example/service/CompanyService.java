package com.example.service;

import com.example.entity.secondary.Company;
import com.example.exception.InternalException;
import com.example.mapper.secondary.CompanyMapper;
import com.example.repository.secondary.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;
    @Autowired
    private CompanyMapper companyMapper;

    public String getName(int id) {
        return companyMapper.getNameById(id);
    }

    @Transactional(transactionManager = "secondaryTransactionManager")
    public String getName2(int i) {
        Company company = new Company();
        company.setName("bbb");
        repository.save(company);
        if (i == 1) throw new InternalException();
        companyMapper.updateNameById(company.getId());
        if (i == 2 ) throw new InternalException();
        return "ok";
    }
}
