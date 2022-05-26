package com.beaconfire.pp_webservice_restful.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    @Value("$security.jwt.token.key")
    private String key;


    // parse the token -> use the information in the token to create a userDetail object
    public Optional<AuthUserDetail> resolveToken(HttpServletRequest request){

        String prefixedToken = request.getHeader("Authorization"); // extract

        String token = prefixedToken.substring(7);
        System.out.println("Token::::  "+token);
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody(); // decode
        System.out.println("claims::::"+claims);
        String username = claims.getSubject();
        System.out.println("claims.get(permissions):::::"+ claims.get("permissions"));
        List<LinkedHashMap<String, String>> permissions = (List<LinkedHashMap<String, String>>) claims.get("permissions");

        List<GrantedAuthority> authorities = permissions.stream()
                .map(p -> new SimpleGrantedAuthority(p.get("authority")))
                .collect(Collectors.toList());
        System.out.println("autho.....:"+ authorities);
        return Optional.of(AuthUserDetail.builder()
                .username(username)
                .authorities(authorities)
                .build());

    }

}

