package com.fzutils.microservice.demo.orderservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
	private Integer id;
	private String name;
	private String category;
}
