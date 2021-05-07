package com.caiomacedo.personaddresses.controllers;

import com.caiomacedo.personaddresses.dto.CepAddressDTO;
import com.caiomacedo.personaddresses.entities.Address;
import com.caiomacedo.personaddresses.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    private AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/{personId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddress(@PathVariable Long personId, @RequestBody Address address) {
        addressService.createAddress(personId, address);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAddressUsingZipCode(@RequestParam("personId") Long personId, @RequestBody CepAddressDTO dto){
        addressService.createAddressUsingZipCode(personId, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
