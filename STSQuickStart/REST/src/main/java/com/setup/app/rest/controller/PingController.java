package com.setup.app.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/Ping")
public class PingController {
	
	@GetMapping("")
    public String sayHello() {
        return "System Active";
    }
    
}