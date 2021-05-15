package com.fzutils.microservice.demo.orderservice.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.fzutils.microservice.demo.orderservice.command.ConfirmOrderCommand;
import com.fzutils.microservice.demo.orderservice.command.PlaceOrderCommand;
import com.fzutils.microservice.demo.orderservice.command.ShipOrderCommand;
import com.fzutils.microservice.demo.orderservice.event.OrderConfirmedEvent;
import com.fzutils.microservice.demo.orderservice.event.OrderPlacedEvent;
import com.fzutils.microservice.demo.orderservice.event.OrderShippedEvent;
import com.fzutils.microservice.demo.orderservice.exception.UnconfirmedOrderException;

import lombok.Data;

@Aggregate
@Data
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;
	private boolean orderConfirmed;

	@CommandHandler
	public OrderAggregate(PlaceOrderCommand command) {
		apply(new OrderPlacedEvent(command.getOrderId(), command.getProduct()));
	}

	@EventSourcingHandler
	public void on(OrderPlacedEvent event) {
		this.orderId = event.getOrderId();
		orderConfirmed = false;
	}
	
	@CommandHandler 
	public void handle(ConfirmOrderCommand command) { 
	    apply(new OrderConfirmedEvent(orderId)); 
	} 

	@CommandHandler 
	public void handle(ShipOrderCommand command) throws UnconfirmedOrderException { 
	    if (!orderConfirmed) { 
	        throw new UnconfirmedOrderException(); 
	    } 
	    apply(new OrderShippedEvent(orderId)); 
	} 

	@EventSourcingHandler 
	public void on(OrderConfirmedEvent event) { 
	    orderConfirmed = true; 
	}
}