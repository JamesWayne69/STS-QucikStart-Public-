package com.setup.app.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.setup.app.dto.AuthResponseDTO;
import com.setup.app.dto.LoginDTO;
import com.setup.app.dto.RegisterDTO;
import com.setup.app.service.impl.AuthServiceImplementation;
import com.setup.app.utility.enums.UserRoles;


@RestController
@RequestMapping("/v1/auth")
public class AuthController {

	@Autowired
	private AuthServiceImplementation authServiceImplementation;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDto){
      	return new ResponseEntity<>(authServiceImplementation.login(loginDto), HttpStatus.OK);
    }

    @PostMapping("/register/{role}")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto, @PathVariable UserRoles role) {
    	return new ResponseEntity<>(authServiceImplementation.register(registerDto, role), HttpStatus.OK);
    }

}
