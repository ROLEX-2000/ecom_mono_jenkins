package com.project.ecom.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipmentId;
    @OneToOne
    @JoinColumn(name = "addressId")
    @JsonIgnoreProperties(value = "account")
    private Address shippingAddress;
  
    @OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "shipment")
    private Set<OrderLineItems> orderLineItems;
    
    private Date shippedDate;
    private Date deliveryDate;


    @OneToOne
    @JoinColumn(name = "accountId")
    @JsonIgnoreProperties(value = "orders")
    private Account account;

    public Shipment() {
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<OrderLineItems> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItems> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
