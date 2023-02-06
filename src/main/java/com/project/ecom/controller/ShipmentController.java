package com.project.ecom.controller;



import org.springframework.web.bind.annotation.*;

import com.project.ecom.model.Shipment;
import com.project.ecom.service.ShipmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    @GetMapping()
    public List<Shipment> getAllShipment() {

        return shipmentService.getAllShipment();
    }

    @PostMapping("/account/{accountId}/address/{addressId}")
    public String addShipment(@PathVariable("accountId") int accountId, @PathVariable("addressId") int addressId, @RequestBody Shipment shipment) {

        shipmentService.addShipment(accountId, addressId, shipment);

        return "Shipment is added.";
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getShipmentById(@PathVariable("id") int id) {

        return shipmentService.getShipmentById(id);
    }

    @PutMapping("/{id}")
    public String updateShipment(@PathVariable("id") int id, @RequestBody Shipment shipment) {

        shipmentService.updateShipment(id, shipment);
        return "Shipment is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteShipmentById(@PathVariable("id") int id) {

        shipmentService.deleteShipmentById(id);

        return "Shipment with Shipment Number " + id + " successfully deleted.";
    }

    @GetMapping("/accountId/{accountId}/date")
    public List<Shipment> getShipmentByAccountByDeliveryDate(@PathVariable("accountId") int accountId) {

        return shipmentService.getShipmentByAccountByDeliveryDat(accountId);
    }
}