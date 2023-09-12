package com.jamersondev.eletroshop.jwt;

import com.jamersondev.eletroshop.domain.UserSystem;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);
    @Value("${jwtKey}")
    private String jwtSecret;

    @Value("${jwtTimeExpiration}")
    private Integer jwtExpirationTime;

    private String generateToken(Authentication auth){
        //get user current
        UserSystem user = (UserSystem) auth.getPrincipal();

        try {
            //Generate key
            Key secretkey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));

            return Jwts.builder() //here generate token
                    .setSubject(user.getLogin())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime))
                    .signWith(secretkey)
                    .compact();
        }catch (Exception e){
            LOGGER.error("Error: ", e);
            return "";
        }
    }

    private Claims getClaims(String token){
        try {
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));
            return Jwts.parserBuilder().setSigningKey(secretKey).build()
                    .parseClaimsJws(token).getBody();
        }catch (Exception e){
            LOGGER.error("Error: ", e);
            return null;
        }
    }

    //method for valid token
    public boolean validatedToken(String token){
        Claims claims = getClaims(token);
        if(claims == null) {
            return false;
        }
        String login = claims.getSubject();
        Date dateExpiration = claims.getExpiration();
        Date dateNow = new Date(System.currentTimeMillis());
        if(login != null && dateNow.before(dateExpiration)){
            return true;
        }
        return false;
    }

}
