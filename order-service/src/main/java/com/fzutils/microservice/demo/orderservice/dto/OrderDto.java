package com.fzutils.microservice.demo.orderservice.dto;

import com.fzutils.microservice.demo.core.models.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
	private Integer id;
	private Integer quantity;
	private Product product;
}
