package com.project.ecom.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecom.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
