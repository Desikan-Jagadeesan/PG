package com.palani.PoultryAssist.Component;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.palani.PoultryAssist.Model.UserDetail;

public class ApplicationAuthentication implements Authentication {

	private UserDetail userDetails;
	private boolean authenticated = false;
	public ApplicationAuthentication(UserDetail userDetail) {
		this.userDetails=userDetail;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return userDetails.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<SimpleGrantedAuthority>();
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return userDetails.getPassword();
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return userDetails;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return userDetails.getUsername();
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated=isAuthenticated;

	}

}
