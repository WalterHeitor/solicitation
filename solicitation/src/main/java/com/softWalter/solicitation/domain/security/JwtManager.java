package com.softWalter.solicitation.domain.security;

import com.softWalter.solicitation.domain.security.constan.SecurityConstan;
import com.softWalter.solicitation.presentations.controller.dto.UserLoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.List;

@Component
public class JwtManager {

    public UserLoginResponse createToken(String email, List<String> roles) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, SecurityConstan.JWT_EXP_DAYS);
        String jwt = Jwts.builder()
                .setSubject(email)
                .setExpiration(calendar.getTime())
                .claim(SecurityConstan.JWT_ROLE_KEY, roles)
                .signWith(SignatureAlgorithm.HS512, SecurityConstan.API_KEY.getBytes(StandardCharsets.UTF_8))
                .compact();
        Long expireIn = calendar.getTimeInMillis();

        return new UserLoginResponse(jwt, expireIn, SecurityConstan.JWT_PROVIDER);
    }

    public Claims parseToken(String jwt) throws JwtException {

        return Jwts.parser()
                .setSigningKey(SecurityConstan.API_KEY.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwt)
                .getBody();
    }
}
