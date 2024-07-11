package com.palani.PoultryAssist.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.palani.PoultryAssist.Component.JwtSecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	private JwtSecurityFilter jwtFilter;
	

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception
	{
		http
        .csrf().disable()
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/login/*","/species/*").permitAll()  // Allowing POST requests to /api/post
            .anyRequest().authenticated()

        );
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}

}
