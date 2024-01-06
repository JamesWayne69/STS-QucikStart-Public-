package com.setup.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SecurityLevel {
	WARN("Warn"),
	ERROR("Error");
	
	@Getter
	private final String Level;
	
	
    

}