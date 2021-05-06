package com.caiomacedo.personaddresses.controllers;

import com.caiomacedo.personaddresses.entities.Person;
import com.caiomacedo.personaddresses.services.PersonAddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonAddressService personAddressService;

    private PersonController(PersonAddressService personAddressService) {
        this.personAddressService = personAddressService;
    }

    @GetMapping("/all")
    public List<Person> findAll(){
        return personAddressService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id){
        return personAddressService.findPersonById(id);
    }

    @PostMapping
    public void createPerson(@RequestBody Person p) {
        personAddressService.createPerson(p);
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Long id){
        personAddressService.deletePerson(id);
    }

}
