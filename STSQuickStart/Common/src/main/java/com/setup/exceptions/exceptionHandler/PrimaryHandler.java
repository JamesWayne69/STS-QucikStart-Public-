package com.setup.exceptions.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import com.setup.exceptions.EmailException;
import com.setup.exceptions.UserNameExistsException;
import com.setup.model.ErrorResponse;
import com.setup.utility.enums.SecurityCode;

@RestControllerAdvice
public class PrimaryHandler extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthenticationException.class,AuthenticationCredentialsNotFoundException.class,UsernameNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleAuthenticationException(Exception ex,WebRequest Request) {
        return new ResponseEntity<>(Generator(SecurityCode.AUTHENTICATIONERROR), HttpStatus.UNAUTHORIZED);
    }
	

	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNameExistsException.class})
    public ResponseEntity<ErrorResponse> handleUserExistsException(Exception ex,WebRequest Request) {
        return new ResponseEntity<>(Generator(SecurityCode.USERNAMEEXISTSERROR), HttpStatus.BAD_REQUEST);
    }
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmailException.class})
    public ResponseEntity<ErrorResponse> handleEmailException(Exception ex,WebRequest Request) {
        return new ResponseEntity<>(Generator(SecurityCode.EMAILERROR), HttpStatus.BAD_REQUEST);
    }
    	
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex,WebRequest Request) {
        return new ResponseEntity<>(Generator(SecurityCode.RUNTIMEERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    public ErrorResponse Generator(SecurityCode Code) {
		ErrorResponse responseModel = new ErrorResponse(Code.getCode(),Code.getLevel(),Code.getDescription());
		return responseModel;
	}
}
