package com.caiomacedo.personaddresses.services;

import com.caiomacedo.personaddresses.entities.Address;
import com.caiomacedo.personaddresses.entities.Person;
import com.caiomacedo.personaddresses.exceptions.person.PersonAlreadyExistsException;
import com.caiomacedo.personaddresses.exceptions.person.PersonNotFoundException;
import com.caiomacedo.personaddresses.repositories.AddressRepository;
import com.caiomacedo.personaddresses.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonAddressService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    private PersonAddressService(
            PersonRepository personRepository,
            AddressRepository addressRepository
    ) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonById(Long id){
        return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
    }

    public void createPerson(Person person) {
        personRepository.findPersonByEmailOrCpf(person.getEmail(), person.getCpf()).ifPresent(p -> {
            throw new PersonAlreadyExistsException();
        });
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void createAddress(Long personId, Address address) {
        Person p = findPersonById(personId);
        address.setPerson(p);
        p.getAddresses().add(address);
        addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}
