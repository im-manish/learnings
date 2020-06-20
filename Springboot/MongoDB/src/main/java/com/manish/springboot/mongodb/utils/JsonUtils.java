/*
 * Copyright (c) 19/06/20, 8:06 PM Written by Manish Kumar
 */

package com.manish.springboot.mongodb.utils;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.manish.springboot.mongodb.model.Order;
import com.manish.springboot.mongodb.model.OrderItem;

public class JsonUtils {
    public static String convertToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static String convertToJson(Object object, Type type) {
        Gson gson = new Gson();
        return gson.toJson(object, type);
    }

    public static <T> T restoreFromJson(Reader reader, Class<T> classObject) {
        Gson gson = new Gson();
        return gson.fromJson(reader, classObject);
    }

    public static <T> T restoreFromJson(String jsonString, Class<T> classObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, classObject);

    }

    public static <T> T restoreFromJson(String jsonString, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, type);

    }

    public static void main(String[] args) {
        OrderItem orderItem = OrderItem.builder().orderItemDescription("1 St Order Item").orderItemId("123").orderItemValue(220L).build();
        Order order = Order.builder().orderId("901902").orderNumber("IC-123").orderTotal(200L)
                .discount(20L).orderItem(Stream.of(orderItem).collect(Collectors.toList())).build();
        System.out.println(JsonUtils.convertToJson(order));

    }
}
