package com.myRestApi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api1")
public class DemoRestController1 {

	@GetMapping("/rest1")
	public String sayHello()
	{
		return " Hey ";
	}
}
