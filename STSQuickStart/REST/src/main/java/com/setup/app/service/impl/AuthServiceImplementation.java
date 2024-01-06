package com.setup.app.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.setup.app.dto.AuthResponseDTO;
import com.setup.app.dto.LoginDTO;
import com.setup.app.dto.RegisterDTO;
import com.setup.app.models.Role;
import com.setup.app.models.UserEntity;
import com.setup.app.repository.RoleRepository;
import com.setup.app.repository.UserRepository;
import com.setup.app.security.jwt.JWTGenerator;
import com.setup.app.service.AuthService;
import com.setup.app.utility.enums.UserRoles;
import com.setup.exceptions.UserNameExistsException;

@Service
public class AuthServiceImplementation implements AuthService {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JWTGenerator jwtGenerator;


	@Override
	public AuthResponseDTO login(LoginDTO loginDTO) {
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDTO.getUsername(),
                loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new AuthResponseDTO(jwtGenerator.generateToken(authentication));
		
	}

	@Override
	public String register(RegisterDTO registerDTO, UserRoles role) {
		if (userRepository.existsByUsername(registerDTO.getUsername())) {
			throw new UserNameExistsException();
			//Assuming username is unique, can also be email
		}

        UserEntity user = new UserEntity();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode((registerDTO.getPassword())));

        Role roles = roleRepository.findByName(role.toString()).get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);

        return "User registered successfully!";
    }
	

}
