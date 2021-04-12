package com.fzutils.microservice.demo.orderservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fzutils.microservice.demo.core.models.Product;

@FeignClient(name="product-service", path = "products")
public interface ProductFeignClient {

	@GetMapping
	public List<Product> getProductList();

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Integer id);
}
