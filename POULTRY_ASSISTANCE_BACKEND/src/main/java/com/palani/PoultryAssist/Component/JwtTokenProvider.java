package com.palani.PoultryAssist.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    public String secret;

    @Value("${jwt.expiration}")
    public long expiration;

    public String generateToken(String name) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "ADMIN");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    public boolean validateUser (String token, String name)
    {
    	String userName = getUserNameFromToken(token);
		if(name.equalsIgnoreCase(userName)&&!isTokenExpired(token))
    	{
    		return true;
    	}
		return false;
    	
    }
	public String getUserNameFromToken(String token) {
		String name= getClaim(token).getSubject();
		return name;
	}
	private Claims getClaim(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
	}
	public boolean isTokenExpired(String token)
	{
		Date expiration = getClaim(token).getExpiration();
		return expiration.before(new Date());
	}
	
}
