package com.fzutils.microservice.demo.core.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
	private Integer id;
	private String name;
	private String category;
}

