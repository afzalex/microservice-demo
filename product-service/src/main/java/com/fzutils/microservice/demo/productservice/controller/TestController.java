package com.fzutils.microservice.demo.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired 
	private String testBean01;
	
    @GetMapping
    public String getProductList() {
    	return testBean01;
    }

}
