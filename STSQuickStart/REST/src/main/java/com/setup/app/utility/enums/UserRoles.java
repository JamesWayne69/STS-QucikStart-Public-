package com.setup.app.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserRoles {
	ADMIN("Admin"),
	USER("User");
	
	@Getter
	private final String role;
	

}
