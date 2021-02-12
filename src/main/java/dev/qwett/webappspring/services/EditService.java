package dev.qwett.webappspring.services;


import dev.qwett.webappspring.entities.model.Person;

public interface EditService {


    Person getPerson();

    void savePerson(Person personBean);
}
