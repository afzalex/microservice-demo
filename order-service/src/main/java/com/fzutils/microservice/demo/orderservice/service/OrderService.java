package com.fzutils.microservice.demo.orderservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzutils.microservice.demo.orderservice.dto.OrderDto;
import com.fzutils.microservice.demo.orderservice.feignclient.ProductFeignClient;
import com.fzutils.microservice.demo.orderservice.model.Order;

@Service
public class OrderService {

	@Autowired
	private ProductFeignClient productFeignClient;

	private List<Order> orderList = Arrays.asList(//
			Order.builder().id(1).quantity(10).productId(2).build(), //
			Order.builder().id(2).quantity(15).productId(3).build(), //
			Order.builder().id(3).quantity(6).productId(1).build(), //
			Order.builder().id(4).quantity(4).productId(2).build(), //
			Order.builder().id(5).quantity(1).productId(1).build()//
	);

	public List<Order> getOrderList() {
		return orderList;
	}

	public Order getOrderById(Integer id) {
		return orderList.stream().filter(p -> id.equals(p.getId())).findFirst().get();
	}

	public OrderDto getOrderDescriptionById(Integer id) {
		return orderList.stream()//
				.filter(p -> id.equals(p.getId()))//
				.findFirst()//
				.map(o -> OrderDto.builder()//
						.id(o.getId())//
						.quantity(o.getQuantity())//
						.product(productFeignClient.getProductById(o.getProductId()))//
						.build()//
				).get();
	}
}
