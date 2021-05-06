package com.caiomacedo.personaddresses.controllers;

import com.caiomacedo.personaddresses.entities.Address;
import com.caiomacedo.personaddresses.services.PersonAddressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final PersonAddressService personAddressService;

    private AddressController(PersonAddressService personAddressService){
        this.personAddressService = personAddressService;
    }

    @PostMapping("/{personId}")
    public void createAddress(@PathVariable Long personId, @RequestBody Address address){
        personAddressService.createAddress(personId, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id){
        personAddressService.deleteAddress(id);
    }
}
