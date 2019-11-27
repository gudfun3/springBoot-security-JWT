package com.asu.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Primary
public class JwtUtil {

	private String SECRET_KEY="secret";
	
	/**
	 * this method extract username from the token 
	 * which is one of the claim in jwt token body 
	 * @param token
	 * @return
	 */
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	/**
	 * this method finds out whether the token provided is valid as 
	 * per the expiration time or not
	 * @param token
	 * @return
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	public <T> T extractClaim(String token,Function<Claims,T> claimsResolver) {
		final Claims claims=extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> map=new HashMap<>();
		return createToken(map,userDetails.getUsername());
	}
	/**
	 * create jwt token by
	 * setting username as subject and setting other claims along 
	 * with the expiration time. its better to set token expiration
	 * time from application.properties or message.properties file 
	 * Payload contains the claims.Primarily, there are three types of claims:
	 *  reserved, public, and private claims. Reserved claims are predefined 
	 *  claims such as iss (issuer), exp (expiration time), sub (subject),
	 *  aud (audience).In private claims, we can create some custom claims such as subject, role, and others.
	 *   Example structure of a payload
	 *   {
	 *      "sub": "Alex123",
	 *      "scopes": [
	 *             {
	 *               "authority": "ROLE_ADMIN"
	 *              }
	 *             ],
	 *        "iss": "http://errorsexceptions.blogspot.com/#",
	 *        "iat": 1508607322,
	 *        "exp": 1508625322
	 *    }
	 * @param map
	 * @param username
	 * @return
	 */
   private String createToken(Map<String,Object> claims, String username) {
	   return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
			   .setExpiration(new Date(System.currentTimeMillis()+1000*60*60)).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
   }
	
   public boolean validateToken(String token,UserDetails userDetails) {
	   String username=extractUsername(token);
	   return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
   }
	
	
	
	
	
	
	
}
