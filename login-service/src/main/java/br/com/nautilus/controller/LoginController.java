package br.com.nautilus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nautilus.entities.AuthenticationData;
import br.com.nautilus.model.entity.User;
import br.com.nautilus.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(
			@RequestBody AuthenticationData data) {
		var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		Authentication authentication = manager.authenticate(token);
		var generatedToken = tokenService.getToken( (User) authentication.getPrincipal() );
		try {
			tokenService.verifyToken(generatedToken);
			return ResponseEntity.ok( "{'token': '"+generatedToken+"'}");
		}catch(Exception e) {
			throw new RuntimeException("Erro ao validar token", e);
		}
	}
	
	
	@GetMapping("/verify")
	public ResponseEntity verify() {
		return ResponseEntity.ok("User authorized!");
	}
	
	@GetMapping("/get-user")
	public ResponseEntity getUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			var authHeader = request.getHeader("Authorization");
			if(authHeader != null) {
				var token = authHeader.replace("Bearer ", "");
				var user = tokenService.getUser(token);
				return ResponseEntity.ok("{'user': '"+user+"'}");
			}
		}catch(Exception e) {
			throw new RuntimeException("Erro ao recuperar usuário", e);
		}
		return ResponseEntity.ok("Talvez outro dia, tiozinho...");
		
	}
	
}
