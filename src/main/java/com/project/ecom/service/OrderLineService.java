package com.project.ecom.service;


import org.springframework.stereotype.Service;

import com.project.ecom.model.OrderLineItems;
import com.project.ecom.repository.OrderLineItemsRepository;
import com.project.ecom.repository.ProductRepository;
import com.project.ecom.repository.ShipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    private OrderLineItemsRepository orderLineItemsRepository;
    private ProductRepository productRepository;
    private ShipmentRepository shipmentRepository;

    public OrderLineService(OrderLineItemsRepository orderLineItemsRepository, ProductRepository productRepository, ShipmentRepository shipmentRepository) {
        this.orderLineItemsRepository = orderLineItemsRepository;
        this.productRepository = productRepository;
        this.shipmentRepository = shipmentRepository;
    }

    public List<OrderLineItems> getAllOrderLine() {

        return orderLineItemsRepository.findAll();
    }

    public void addOrderLine(int productId, int shipmentId, OrderLineItems orderLineItems) {

        orderLineItems.setProduct(productRepository.getOne(productId));
        orderLineItems.setShipment(shipmentRepository.getOne(shipmentId));

        orderLineItemsRepository.save(orderLineItems);
    }

    public Optional<OrderLineItems> getOrderLineItemsById(int id) {

        return orderLineItemsRepository.findById(id);
    }


    public void updateOrderLineItemsById(int id, OrderLineItems orderLineItems) {

        orderLineItemsRepository.save(orderLineItems);
    }

    public void deleteOrderLineItemById(int id) {

        orderLineItemsRepository.deleteById(id);
    }
}