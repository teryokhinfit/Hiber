package com.example.hiber.controller;


import com.example.hiber.POJO.Persons;
import com.example.hiber.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonsController {

    @Autowired
    private PersonsService service;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(@RequestParam(value = "city") String city) {
        System.out.println(city);
       return service.getPersonsByCity(city);

    }
}
