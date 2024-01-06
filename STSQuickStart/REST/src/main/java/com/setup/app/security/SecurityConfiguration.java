package com.setup.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.setup.app.security.jwt.JWTAuthEntryPoint;
import com.setup.app.security.jwt.JWTAuthenticationFilter;
import com.setup.app.utility.enums.UserRoles;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
    private JWTAuthEntryPoint authEntryPoint;
	    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exceptionHandling -> exceptionHandling
        		.authenticationEntryPoint(authEntryPoint))
        .sessionManagement(sessionManagement -> sessionManagement
        		.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorizeHttpRequests-> authorizeHttpRequests
        		.requestMatchers("/v1/auth/**").permitAll()
        		.requestMatchers("v1/user/**").hasRole(UserRoles.USER.toString())
        		.requestMatchers("v1/user/**").hasRole(UserRoles.ADMIN.toString())
        		.anyRequest().authenticated());     
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
