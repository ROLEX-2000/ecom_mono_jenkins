package com.project.ecom.service;


import org.springframework.stereotype.Service;

import com.project.ecom.model.Shipment;
import com.project.ecom.repository.AccountRepository;
import com.project.ecom.repository.AddressRepository;
import com.project.ecom.repository.ShipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;
    private AddressRepository addressRepository;
    private AccountRepository accountRepository;

    public ShipmentService(ShipmentRepository shipmentRepository, AddressRepository addressRepository, AccountRepository accountRepository) {
        this.shipmentRepository = shipmentRepository;
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }


    @SuppressWarnings("deprecation")
	public void addShipment(int accountId, int addressId, Shipment shipment) {

        shipment.setAccount(accountRepository.getOne(accountId));
        shipment.setShippingAddress(addressRepository.getOne(addressId));

        shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(int id) {

        return shipmentRepository.findById(id);
    }

    public void updateShipment(int id, Shipment shipment) {

        shipmentRepository.save(shipment);
    }

    public void deleteShipmentById(int id) {

        shipmentRepository.deleteById(id);
    }

    public List<Shipment> getAllShipment() {

        return shipmentRepository.findAll();
    }

    public List<Shipment> getShipmentByAccountByDeliveryDat(int accountId) {

        return shipmentRepository.findAllByAccount_AccountIdOrderByDeliveryDate(accountId);
    }
}
