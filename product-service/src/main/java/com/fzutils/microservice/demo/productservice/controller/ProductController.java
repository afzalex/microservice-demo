package com.fzutils.microservice.demo.productservice.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fzutils.microservice.demo.core.models.Product;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> productList = Arrays.asList(//
            Product.builder().id(1).name("Prod1").category("Cat1").build(), //
            Product.builder().id(2).name("Prod2").category("Cat1").build(), //
            Product.builder().id(3).name("Prod3").category("Cat2").build()//
    );

    @PostConstruct
    public void postConstruct() {
    }

    @GetMapping
    public List<Product> getProductList() {
        log.debug("Request to get product list 2");
        return productList;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productList.stream().filter(p -> id.equals(p.getId())).findFirst().get();
    }
}
