package com.fzutils.microservice.demo.orderservice.event;

import lombok.Data;

@Data
public class OrderConfirmedEvent {
	 
    private final String orderId;
 
}