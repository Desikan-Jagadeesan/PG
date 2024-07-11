package com.palani.PoultryAssist.Component;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.palani.PoultryAssist.Model.UserDetail;
import com.palani.PoultryAssist.Service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private UserService userService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authendication = request.getHeader("Authorization");
		
		if (authendication !=null && authendication.contains("Bearer") )
		{
			String token = authendication.substring(7);
			if(jwtTokenProvider.isTokenExpired(token))
			{
				throw new AccessDeniedException("User Not Found");
			}
			System.out.println("Good Request");
			Authentication auth = new ApplicationAuthentication((UserDetail)userService.loadUserByUsername(jwtTokenProvider.getUserNameFromToken(token)));
			auth.setAuthenticated(true);
			SecurityContextHolder.getContext().setAuthentication(auth);
			
		}
		System.out.println("Good Request end");
		filterChain.doFilter(request, response);
		
	}

}
