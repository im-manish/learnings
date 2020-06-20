/*
 * Copyright (c) 19/06/20, 4:30 PM Written by Manish Kumar
 */

package com.manish.springboot.mongodb.repository;

import com.manish.springboot.mongodb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    Order findByOrderId(String orderId);
}
