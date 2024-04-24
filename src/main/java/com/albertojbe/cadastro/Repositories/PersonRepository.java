package com.albertojbe.cadastro.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albertojbe.cadastro.Models.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
