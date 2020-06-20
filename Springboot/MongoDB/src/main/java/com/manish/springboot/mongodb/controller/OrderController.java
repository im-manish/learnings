/*
 * Copyright (c) 19/06/20, 4:34 PM Written by Manish Kumar
 */

package com.manish.springboot.mongodb.controller;

import com.manish.springboot.mongodb.model.Order;
import com.manish.springboot.mongodb.repository.OrderRepository;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @GetMapping("")
    public ResponseEntity<List<Order>> getAllOrders() {
       List<Order> orderList = new ArrayList<>();
        try {
            orderRepository.findAll().forEach(orderList::add);
            if(CollectionUtils.isEmpty(orderList)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderList,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrdersById(@PathVariable("id") String orderId) {
        try {
            Optional<Order> order = orderRepository.findById(orderId);
            if(order.isPresent()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity(order,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        if(null == order){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Order savedOrder = orderRepository.save(order);
            return new ResponseEntity<>(savedOrder,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
