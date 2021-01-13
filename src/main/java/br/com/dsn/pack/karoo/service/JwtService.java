package br.com.dsn.pack.karoo.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.dsn.pack.karoo.domain.Funcionario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {
	
	private static final long EXPIRATION_TIME = 180000;
	private String key = "jsonwebtoken secret";
	
	public String generateToken(Funcionario funcionario) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(funcionario.toString())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, key)
				.compact();
	}
	
	public Claims decodeToken(String token) {
		
		return Jwts.parser()
				.setSigningKey(key)
				.parseClaimsJws(token)
				.getBody();
	}
}