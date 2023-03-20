package com.example.hiber.service;


import com.example.hiber.POJO.Persons;

import java.util.List;

public interface PersonsService {
   List<Persons> getPersonsByCity(String city);
}
