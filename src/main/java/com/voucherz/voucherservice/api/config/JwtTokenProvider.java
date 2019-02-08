package com.voucherz.voucherservice.api.config;

import com.sun.security.auth.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import javax.annotation.PostConstruct;
import java.security.SignatureException;
import java.util.Base64;
import java.util.Date;

public class JwtTokenProvider {
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    //    @Value("${app.jwtSecret}")
    private String jwtSecret="JWTSuperSecretKey";

    //    @Value("${app.jwtExpirationInMs}")
    private long jwtExpirationInMs = 1000000000;

    @PostConstruct
    protected void init(){
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication){
        //downcasted
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        Date now = new Date();

        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

//        Claims claims = Jwts.claims().setSubject(userPrincipal.getEmail());
//        return Jwts.builder()
//                // set sub
////                .setSubject(userPrincipal.getUsername())
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
//                .compact();
        return null;
    }
//
//    // decrypting the token
    public String getUserIdFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
                .parseClaimsJws(token)
                .getBody();

        return (claims.getSubject());
    }

    public boolean validateToken(String authToken){
        try{
            Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes())).parseClaimsJws(authToken);
            return true;

        }catch(MalformedJwtException ex){
            logger.error("Invalid Jwt token");
        }catch(ExpiredJwtException ex){
            logger.error("Expired Jwt Token");
        }catch(UnsupportedJwtException ex){
            logger.error("Unsupported Jwt token");
        }catch(IllegalArgumentException ex){
            logger.error("JWT claims string is empty");
        }
        return false;
    }
}
