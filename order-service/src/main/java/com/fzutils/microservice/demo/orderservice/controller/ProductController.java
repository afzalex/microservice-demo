package com.fzutils.microservice.demo.orderservice.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fzutils.microservice.demo.orderservice.model.ProductModel;

@RestController
@RequestMapping("/products")
public class ProductController {

	private List<ProductModel> productList = Arrays.asList(//
			ProductModel.builder().id(1).name("Prod1").category("Cat1").build(), //
			ProductModel.builder().id(2).name("Prod2").category("Cat1").build(), //
			ProductModel.builder().id(3).name("Prod3").category("Cat2").build()//
	);

	@PostConstruct
	public void postConstruct() {

	}

	@GetMapping
	public Object getProductList() {
		return productList;
	}

	@GetMapping("/{id}")
	public ProductModel getProductById(@PathVariable Integer id) {
		return productList.stream().filter(p -> id.equals(p.getId())).findFirst().get();
	}
}
