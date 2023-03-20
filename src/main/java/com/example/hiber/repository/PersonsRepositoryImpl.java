package com.example.hiber.repository;


import com.example.hiber.POJO.Persons;
import com.example.hiber.POJO.PersonsId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository

public class PersonsRepositoryImpl implements PersonsRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Persons> getPersonsByCity(String city) {
        createPersons();
        Query query = entityManager.createQuery("select p from Persons p where p.city= :city",Persons.class);
        query.setParameter("city",city);
        var resultList = query.getResultList();
        return resultList;


    }

    public void createPersons() {
        List<Persons> personsList = new ArrayList<>();
        Persons persons1 = new Persons(new PersonsId
                ("'Kolya", "'Tolstiy'", 34), "555-555", "Ryazan");
        Persons persons2 = new Persons(new PersonsId
                ("'Dima'", "'Potniy'", 48), "444-444", "MOSCOW");
        Persons persons3 = new Persons(new PersonsId
                ("'Vasya'", "'Pupkin'", 56), "333-333", "Samara");
        Persons persons4 = new Persons(new PersonsId
                ("'Sveta'", "'Sladkaya'", 15), "222-222", "SPB");

        personsList.add(persons1);
        personsList.add(persons2);
        personsList.add(persons3);
        personsList.add(persons4);

        for (Persons persons : personsList) {
            entityManager.persist(persons);
        }

    }
}
