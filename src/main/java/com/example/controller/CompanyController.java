package com.example.controller;

import com.example.entity.secondary.Company;
import com.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/company/name")
    public String name(@RequestParam("id") Integer id) {
        return companyService.getName(id);
    }


    @RequestMapping("/company/name2")
    public String name2(@RequestParam("i") Integer i) {
        companyService.getName2(i);
        return "ok";
    }
}
