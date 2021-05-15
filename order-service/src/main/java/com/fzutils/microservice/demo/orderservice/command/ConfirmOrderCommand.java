package com.fzutils.microservice.demo.orderservice.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Data;

@Data
public class ConfirmOrderCommand {
	 
    @TargetAggregateIdentifier
    private final String orderId;
    
}