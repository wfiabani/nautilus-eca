package br.com.nautilus.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import br.com.nautilus.model.entity.User;

@Service
public class TokenService {
	
	@Value("${nautilus.jwt.secret}")
	private String secret;
	
	public String getToken(User user) {
		System.out.println(secret);
		try {
		    var algorithm = Algorithm.HMAC256(secret);
		    System.out.println("==> "+user.getUsr());
		    	return JWT.create()
		            .withIssuer("Nautilus ECA")
		            .withSubject(user.getUsr())
		            .withClaim("id", user.getId()) 
		            .withExpiresAt(expirationDate())
		            .sign(algorithm);
		} catch (JWTCreationException exception){
		    throw new RuntimeException("Erro ao gerar token", exception);
		}
	}
	
	
	public Boolean verifyToken(String tokenJWT) {
		DecodedJWT decodedJWT;
		try {
			var algorithm = Algorithm.HMAC256(secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("Nautilus ECA")
		        .build();
		    decodedJWT = verifier.verify(tokenJWT);
		    return true;
		} catch (JWTVerificationException exception){
			throw new RuntimeException("Invalid JWT Token", exception);
		}
	}
	
	
	public String getUser(String tokenJWT) {
		DecodedJWT decodedJWT;
		try {
			var algorithm = Algorithm.HMAC256(secret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer("Nautilus ECA")
		        .build();
		    decodedJWT = verifier.verify(tokenJWT);
		    return decodedJWT.getSubject();
		} catch (JWTVerificationException exception){
		    // Invalid signature/claims
			throw new RuntimeException("Invalid token", exception); 
		}
	}
	
	
	private Instant expirationDate() {
		return LocalDateTime.now().plusMinutes(1).toInstant(ZoneOffset.of("-03:00"));
	}

}
