package com.setup.app.security.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

//import java.security.KeyPair;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {
	//private static final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
	//private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	private SecretKey key=Keys.hmacShaKeyFor(JWTConstants.SECRET_KEY.getBytes());
	
	public String generateToken(Authentication authentication) {
		String username = authentication.getName(); 
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt( new Date())
				.setExpiration(new Date(new Date().getTime() + JWTConstants.JWT_EXPIRATION))
				.signWith(key)
				.compact();
		return token;
	}
	public String getUsernameFromJWT(String token){
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token);
			return true;
		} catch (Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT was exprired or incorrect",ex.fillInStackTrace());
		}
	}

}
