package com.project.ecom.service;


import org.springframework.stereotype.Service;

import com.project.ecom.model.Orders;
import com.project.ecom.repository.AccountRepository;
import com.project.ecom.repository.AddressRepository;
import com.project.ecom.repository.OrderLineItemsRepository;
import com.project.ecom.repository.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;
    private AccountRepository accountRepository;
    private AddressRepository addressRepository;
    private OrderLineItemsRepository orderLineItemsRepository;

    public OrdersService(OrdersRepository ordersRepository, AccountRepository accountRepository, AddressRepository addressRepository, OrderLineItemsRepository orderLineItemsRepository) {
        this.ordersRepository = ordersRepository;
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.orderLineItemsRepository = orderLineItemsRepository;
    }

    public List<Orders> getAllOrders() {

        return ordersRepository.findAll();
    }

    public void addOrders(int accountId, int addressId, int orderLineId, Orders orders) {

        orders.setAccount(accountRepository.getOne(accountId));
        orders.setShippingAddress(addressRepository.getOne(addressId));
        orders.setOrderLineItems(orderLineItemsRepository.getOne(orderLineId));
        ordersRepository.save(orders);
    }

    public Optional<Orders> getOrderById(int id) {

        return ordersRepository.findById(id);
    }

    public void updateOrderById(int id, Orders orders) {

        ordersRepository.save(orders);
    }

    public void deleteOrderById(int id) {

        ordersRepository.deleteById(id);
    }

    public Orders getOrderForAccount(int accountId) {

        return ordersRepository.findAllByAccount_AccountId(accountId);
    }

    public List<Orders> getAllOrdersByAccountByDate(int accountId) {

        return ordersRepository.findAllByAccount_AccountIdOrderByOrderDate(accountId);
    }
}
