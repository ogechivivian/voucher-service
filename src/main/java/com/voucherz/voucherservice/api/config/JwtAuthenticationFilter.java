package com.voucherz.voucherservice.api.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    //@Value("${app.jwtSecret}")
    final String jwtSecret="JWTSuperSecretKey";

    final String secretKey = Base64.getEncoder().encodeToString(jwtSecret.getBytes());

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        System.out.println(header);
        System.out.println("--------------------------------------hello world");
        logger.info(secretKey);

        if(header == null || !header.startsWith("Bearer")){
            filterChain.doFilter(request, response);

            return;
        }

        String token = header.substring(7, header.length());
        Claims claims_ = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
System.out.println(claims_.getSubject());
        try{

            logger.info(secretKey.toString());
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token).getBody();
            String userId = claims.getSubject();
            System.out.println("--------------Hello world");
            System.out.println(userId);

            if(userId != null){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        userId, null, null
                );


                SecurityContextHolder.getContext().setAuthentication(auth);

            }

        }
        catch (Exception e){
            SecurityContextHolder.clearContext();
        }
    }
}
