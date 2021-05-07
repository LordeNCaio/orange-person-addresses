package com.caiomacedo.personaddresses.services;

import com.caiomacedo.personaddresses.dto.CepAddressDTO;
import com.caiomacedo.personaddresses.entities.Address;
import com.caiomacedo.personaddresses.entities.Person;
import com.caiomacedo.personaddresses.repositories.AddressRepository;
import com.caiomacedo.personaddresses.utils.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;

    private PersonService personService;

    private AddressService(AddressRepository addressRepository, ViaCepService viaCepService) {
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    public void createAddress(Long personId, Address address) {
        Person p = personService.findById(personId);
        address.setPerson(p);
        p.getAddresses().add(address);
        addressRepository.save(address);
    }

    public void createAddressUsingZipCode(Long personId, CepAddressDTO dto) {
        Person p = personService.findById(personId);
        Address a = viaCepService.getZipCodeDetails(dto.getZipcode());
        a.setHouseNumber(dto.getHouseNumber());
        a.setComplement(
                !dto.getComplement().isBlank() ? dto.getComplement() : a.getComplement()
        );
        a.setPerson(p);
        p.getAddresses().add(a);
        addressRepository.save(a);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Autowired
    private void getPersonService(PersonService personService) {
        this.personService = personService;
    }
}
