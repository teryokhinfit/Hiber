package com.example.hiber.repository;

import com.example.hiber.POJO.Persons;

import java.util.List;

public interface PersonsRepository {
   List<Persons> getPersonsByCity(String city);

}

