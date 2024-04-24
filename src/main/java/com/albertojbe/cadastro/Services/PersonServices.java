package com.albertojbe.cadastro.Services;

import com.albertojbe.cadastro.Exceptions.ResourceNotFoundException;
import com.albertojbe.cadastro.Models.Person;
import com.albertojbe.cadastro.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){
        logger.info("Find one person.");
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person not foundd"));
    }
    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();
        logger.info("People find");
        return repository.findAll();
    }
    public Person create(Person person){
        logger.info("Creating new person.");
        return repository.save(person);
    }
    public Person update(Person person){
        logger.info("Updating person.");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setEmail(person.getEmail());
        entity.setGender(person.getGender());
        return entity;
    }
    public void delete(Long id){
        logger.info("Deleting person with id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        repository.delete(entity);
    }
}
