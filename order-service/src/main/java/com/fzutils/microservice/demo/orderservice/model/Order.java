package com.fzutils.microservice.demo.orderservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
	private Integer id;
	private Integer quantity;
	private Integer productId;
}
