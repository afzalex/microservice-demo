package com.fzutils.microservice.demo.orderservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import com.fzutils.microservice.demo.orderservice.event.OrderPlacedEvent;
import com.fzutils.microservice.demo.orderservice.model.OrderedProduct;
import com.fzutils.microservice.demo.orderservice.query.FindAllOrderedProductsQuery;

@Service
public class OrderedProductsEventHandler {

    private final Map<String, OrderedProduct> orderedProducts = new HashMap<>();

    @EventHandler
    public void on(OrderPlacedEvent event) {
        String orderId = event.getOrderId();
        orderedProducts.put(orderId, new OrderedProduct(orderId, event.getProduct()));
    }

    // Event Handlers for OrderConfirmedEvent and OrderShippedEvent...
    
    @QueryHandler
    public List<OrderedProduct> handle(FindAllOrderedProductsQuery query) {
        return new ArrayList<>(orderedProducts.values());
    }
}