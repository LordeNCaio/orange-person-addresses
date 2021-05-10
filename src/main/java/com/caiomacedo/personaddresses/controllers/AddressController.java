package com.caiomacedo.personaddresses.controllers;

import com.caiomacedo.personaddresses.dto.CepAddressDTO;
import com.caiomacedo.personaddresses.entities.Address;
import com.caiomacedo.personaddresses.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    private AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{personId}")
    public List<Address> getPersonAddresses(@PathVariable Long personId){
        return addressService.getAddressesFromPerson(personId);
    }

    @PostMapping("/complete/{personId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@PathVariable Long personId, @Valid @RequestBody Address address) {
        addressService.createAddress(personId, address);
    }

    @PostMapping("/zipcode")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddressUsingZipCode(
            @Valid @RequestBody CepAddressDTO dto){
        addressService.createAddressUsingZipCode(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }

}