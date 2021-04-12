package com.fzutils.microservice.demo.orderservice.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fzutils.microservice.demo.orderservice.dto.OrderDto;
import com.fzutils.microservice.demo.orderservice.model.Order;
import com.fzutils.microservice.demo.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostConstruct
	public void postConstruct() {

	}

	@GetMapping
	public List<Order> getOrderList() {
		return orderService.getOrderList();
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}

	@GetMapping("/{id}/desc")
	public OrderDto getOrderDescriptionById(@PathVariable Integer id) {
		return orderService.getOrderDescriptionById(id);
	}
}
