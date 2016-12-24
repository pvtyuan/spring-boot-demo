package com.example.controller;

import com.example.service.PersonService;
import com.example.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;

    @RequestMapping(path = "name", method = RequestMethod.GET)
    public String getName(@RequestParam("id") Integer id) {
        return service.getName(id);
    }

    @RequestMapping(path = "name2", method = RequestMethod.GET)
    public String getName2(@RequestParam("i") Integer i) {
        return service.getName2(i);
    }
}
