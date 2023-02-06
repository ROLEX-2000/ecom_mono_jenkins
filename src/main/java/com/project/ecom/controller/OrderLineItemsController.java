package com.project.ecom.controller;


import org.springframework.web.bind.annotation.*;

import com.project.ecom.model.OrderLineItems;
import com.project.ecom.service.OrderLineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderLine")
public class OrderLineItemsController {

    private OrderLineService orderLineService;

    public OrderLineItemsController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;

    }

    @GetMapping
    public List<OrderLineItems> getAllOrderLine() {

        return orderLineService.getAllOrderLine();
    }

    @PostMapping("/product/{productId}/shipment/{shipmentId}")
    public void addOrderLine(@PathVariable("productId") int productId, @PathVariable("shipmentId") int shipmentId, @RequestBody OrderLineItems orderLineItems) {

        orderLineService.addOrderLine(productId, shipmentId, orderLineItems);
    }

    @GetMapping("/{id}")
    public Optional<OrderLineItems> getOrderLineItemsById(@PathVariable("id") int id) {

        return orderLineService.getOrderLineItemsById(id);
    }

    @PutMapping("/{id}")
    public String updateOrderLineItemsById(@PathVariable("id") int id, @RequestBody OrderLineItems orderLineItems) {

        orderLineService.updateOrderLineItemsById(id, orderLineItems);
        return "Order Line Item is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderLineItemById(@PathVariable("id") int id) {

        orderLineService.deleteOrderLineItemById(id);

        return "Order with " + id + " successfully deleted.";
    }
}