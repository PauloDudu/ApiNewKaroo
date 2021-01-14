package br.com.dsn.pack.karoo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dsn.pack.karoo.domain.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    @Autowired
    private ObjectMapper mapper;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    private String key = "jsonwebtoken secret";

    public String generateToken(Funcionario funcionario) throws JsonProcessingException {
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(mapper.writeValueAsString(funcionario))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public String decodeToken(String token) {

        Claims claim = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        return claim.getSubject();
    }
}