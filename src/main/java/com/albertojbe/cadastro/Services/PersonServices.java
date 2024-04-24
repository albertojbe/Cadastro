package com.albertojbe.cadastro.Services;

import com.albertojbe.cadastro.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong idPerson = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Find one person.");
        Person person = new Person();
        person.setId(idPerson.incrementAndGet());
        person.setFirstName("Alberto");
        person.setLastName("Pinheiro");
        person.setEmail("alberto.pinheiro@gmail.com");
        person.setGender("Male");
        return person;
    }
    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Person person = new Person();
            person.setId(idPerson.incrementAndGet());
            person.setFirstName("First Name" + i);
            person.setLastName("Last Name" + i);
            person.setEmail("email" + i);
            person.setGender("Male");
            people.add(person);
        }
        logger.info("People find");
        return people;
    }
}
