/*
 * Copyright (c) 19/06/20, 4:17 PM Written by Manish Kumar
 */

package com.manish.springboot.mongodb.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {

    private String orderItemId;
    private Long orderItemValue;
    private String orderItemDescription;

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderItemValue() {
        return orderItemValue;
    }

    public void setOrderItemValue(Long orderItemValue) {
        this.orderItemValue = orderItemValue;
    }

    public String getOrderItemDescription() {
        return orderItemDescription;
    }

    public void setOrderItemDescription(String orderItemDescription) {
        this.orderItemDescription = orderItemDescription;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", orderItemValue='" + orderItemValue + '\'' +
                ", orderItemDescription='" + orderItemDescription + '\'' +
                '}';
    }
}
