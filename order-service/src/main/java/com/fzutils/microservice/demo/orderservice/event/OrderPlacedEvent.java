package com.fzutils.microservice.demo.orderservice.event;

import lombok.Data;

@Data
public class OrderPlacedEvent {
	 
    private final String orderId;
    private final String product;
 
}