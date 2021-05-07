package com.caiomacedo.personaddresses.services;

import com.caiomacedo.personaddresses.entities.Person;
import com.caiomacedo.personaddresses.exceptions.person.PersonAlreadyExistsException;
import com.caiomacedo.personaddresses.exceptions.person.PersonNotFoundException;
import com.caiomacedo.personaddresses.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    public void createPerson(Person person) {
        personRepository.findPersonByEmailOrCpf(person.getEmail(), person.getCpf()).ifPresent(p -> {
            throw new PersonAlreadyExistsException();
        });
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.delete(findById(id));
    }

}
