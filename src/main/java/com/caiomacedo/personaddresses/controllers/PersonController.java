package com.caiomacedo.personaddresses.controllers;

import com.caiomacedo.personaddresses.entities.Person;
import com.caiomacedo.personaddresses.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    private PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Person findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@Valid @RequestBody Person p) {
        personService.createPerson(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePersonById(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
