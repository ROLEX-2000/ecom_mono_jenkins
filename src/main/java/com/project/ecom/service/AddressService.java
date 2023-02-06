package com.project.ecom.service;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ecom.model.Address;
import com.project.ecom.repository.AddressRepository;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Optional<Address> getAddressById(int id) {

        return addressRepository.findById(id);
    }

    public List<Address> getAllAddresses() {

        return addressRepository.findAll();
    }

    public void addAddress(Address address) {

        addressRepository.save(address);
    }

    public void updateAddress(int id, Address address) {

        addressRepository.save(address);
    }

    public void deleteAddressById(int id) {

        addressRepository.deleteById(id);
    }
}

