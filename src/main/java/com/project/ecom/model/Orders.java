package com.project.ecom.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private Date orderDate;
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    @JsonIgnoreProperties(value = "account")
    private Address shippingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    @JsonIgnoreProperties(value = "orders")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lineId")
    private OrderLineItems orderLineItems;

    public Orders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderLineItems getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(OrderLineItems orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
}
