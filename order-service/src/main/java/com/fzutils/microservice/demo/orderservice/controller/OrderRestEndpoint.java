package com.fzutils.microservice.demo.orderservice.controller;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fzutils.microservice.demo.orderservice.command.ConfirmOrderCommand;
import com.fzutils.microservice.demo.orderservice.command.PlaceOrderCommand;
import com.fzutils.microservice.demo.orderservice.command.ShipOrderCommand;
import com.fzutils.microservice.demo.orderservice.model.OrderedProduct;
import com.fzutils.microservice.demo.orderservice.query.FindAllOrderedProductsQuery;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor_={@Autowired})
@RestController
@RequestMapping("/orders")
public class OrderRestEndpoint {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
	
	@PostMapping("/ship-order")
	public void shipOrder() {
	    String orderId = UUID.randomUUID().toString();
	    commandGateway.send(new PlaceOrderCommand(orderId, "Deluxe Chair"));
	    commandGateway.send(new ConfirmOrderCommand(orderId));
	    commandGateway.send(new ShipOrderCommand(orderId));
	}
	
	@GetMapping("/all-orders")
	public List<OrderedProduct> findAllOrderedProducts() {
	    return queryGateway.query(new FindAllOrderedProductsQuery(), 
	      ResponseTypes.multipleInstancesOf(OrderedProduct.class)).join();
	}
}
