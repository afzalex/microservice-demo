package com.fzutils.microservice.demo.orderservice.event;

import lombok.Data;

@Data
public class OrderShippedEvent { 

    private final String orderId; 

}