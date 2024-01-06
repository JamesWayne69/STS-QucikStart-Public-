package com.setup.app.service;

import com.setup.app.dto.AuthResponseDTO;
import com.setup.app.dto.LoginDTO;
import com.setup.app.dto.RegisterDTO;
import com.setup.app.utility.enums.UserRoles;

public interface AuthService {

	public AuthResponseDTO login (LoginDTO loginDTO);
	
	public String register(RegisterDTO registerDTO, UserRoles role);
	
}
