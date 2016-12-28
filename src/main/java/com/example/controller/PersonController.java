package com.example.controller;

import com.example.entity.primary.Person;
import com.example.response.BasicResponse;
import com.example.service.PersonService;
import com.example.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
    @Autowired
    private PersonService service;

    @RequestMapping(path = "/name2", method = RequestMethod.GET)
    public String getName2(@RequestParam("i") Integer i) {
        return service.getName2(i);
    }

    @RequestMapping(path = "/mb", method = RequestMethod.GET)
    public Person mbname(@RequestParam("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(path = "/mb/{person_id}", method = RequestMethod.PATCH)
    public BasicResponse patch() {
        return null;
    }
}
