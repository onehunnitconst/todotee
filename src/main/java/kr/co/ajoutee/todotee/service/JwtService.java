package kr.co.ajoutee.todotee.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import kr.co.ajoutee.todotee.domain.UserEntity;
import kr.co.ajoutee.todotee.dto.JwtPayloadDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtService {
    @Value("${todotee.jwt.access.public-key}")
    private String publicKey;

    @Value("${todotee.jwt.access.private-key}")
    private String privateKey;

    public String sign(UserEntity user) {
        String jwt = Jwts.builder()
                .header()
                .and()
                .subject(user.getId().toString())
                .id(UUID.randomUUID().toString())
                .compact();

        return jwt;
    }

    public JwtPayloadDto verify(String token) {
        Claims payload = Jwts.parser().build().parseSignedClaims(token).getPayload();

        return new JwtPayloadDto(payload.getSubject(), payload.getId());
    }
}
