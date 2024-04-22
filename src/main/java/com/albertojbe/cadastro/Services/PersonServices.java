package com.albertojbe.cadastro.Services;

import com.albertojbe.cadastro.models.Person;
import org.springframework.stereotype.Service;

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
}
