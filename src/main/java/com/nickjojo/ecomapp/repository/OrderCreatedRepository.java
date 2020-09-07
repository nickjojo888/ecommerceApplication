package com.nickjojo.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nickjojo.ecomapp.entity.OrderCreated;

@Repository
public interface OrderCreatedRepository extends JpaRepository<OrderCreated, Long>{

}
