package com.setup.utility.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SecurityCode{
	AUTHENTICATIONERROR(200,SecurityLevel.ERROR,"Check the Credentials"),
	USERNAMEEXISTSERROR(202,SecurityLevel.WARN,"Enter a Unique Username"),
	PHONENUMBERERROR(204,SecurityLevel.ERROR,"Phone Number Already Exists"),
	EMAILERROR(205,SecurityLevel.ERROR,"Email Already Exists"),
	RUNTIMEERROR(201,SecurityLevel.ERROR,"Contact support team if problem still persists"),
	UNEXPECTEDERROR(203,SecurityLevel.ERROR,"Contact support team if problem still persists"),
	FORBIDDENACCESS(403,SecurityLevel.WARN,"Contact support team if you are a valid user"),
	INVALIDARGUMENTS(503,SecurityLevel.WARN,"Invalid Arguments sent Please send appropriate Data");
	
	
	private final int code;
	private final SecurityLevel level;
	private final String Description;

}
