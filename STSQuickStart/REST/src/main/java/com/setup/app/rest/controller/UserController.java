package com.setup.app.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setup.app.security.jwt.JWTConstants;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	
	@GetMapping("")
    public String userOnly(@RequestHeader(JWTConstants.JWT_HEADER) String jwt) {
        return "This can be access only by the user";
    }
	


}