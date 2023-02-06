package com.project.ecom.controller;


import org.springframework.web.bind.annotation.*;

import com.project.ecom.model.Address;
import com.project.ecom.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping()
    public List<Address> getAllAddresses() {

        return addressService.getAllAddresses();
    }

    @PostMapping()
    public void addAccount(@RequestBody Address address) {

        addressService.addAddress(address);
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable("id") int id) {

        return addressService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public String updateAddress(@PathVariable("id") int id, @RequestBody Address address) {

        addressService.updateAddress(id, address);
        return "Address is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteAddressById(@PathVariable("id") int id) {

        addressService.deleteAddressById(id);

        return "Address with ID Number " + id + " successfully deleted.";
    }
}
