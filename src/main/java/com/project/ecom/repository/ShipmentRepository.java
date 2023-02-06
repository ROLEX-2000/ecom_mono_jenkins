package com.project.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecom.model.Shipment;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    List<Shipment> findAllByAccount_AccountIdOrderByDeliveryDate(int accountId);
}
