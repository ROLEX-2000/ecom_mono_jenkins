package com.project.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecom.model.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findAllByAccount_AccountIdOrderByOrderDate(int accountId);

    Orders findAllByAccount_AccountId(int accountId);
}

