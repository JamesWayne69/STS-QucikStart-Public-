package com.setup.model;

import com.setup.utility.enums.SecurityLevel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse{
	
	private int code;
	private SecurityLevel level;
	private String Description;
	
}
