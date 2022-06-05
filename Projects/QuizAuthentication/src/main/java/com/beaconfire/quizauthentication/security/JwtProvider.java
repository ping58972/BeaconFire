package com.beaconfire.quizauthentication.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    @Value("$security.jwt.token.key")
    private String key;

    public String createToken(UserDetails userDetails){
        System.out.println(key);
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());// user identifier
        claims.put("permissions", userDetails.getAuthorities());//user permission
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, key).compact();//HS256 -> HS512
    }
}
