package br.com.nautilus;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.nautilus.security.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{
//public class SecurityFilter{
	
	@Autowired
	private TokenService tokenService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// se está tentando acessar a url de login, deixe passar
		if(request.getServletPath().equals("/login") && request.getMethod().equals("POST")) {
			filterChain.doFilter(request, response); //cuidaaaaado!!!!
		}else {			
			String tokenJWT = getToken(request);
			if(tokenService.verifyToken(tokenJWT)) {
				filterChain.doFilter(request, response); //cuidaaaaado!!!!
			}else {
				throw new RuntimeException();
			}
		}
	}
	
	
	private String getToken(HttpServletRequest request) {
		var authHeader = request.getHeader("Authorization");
		if(authHeader != null) {
			return authHeader.replace("Bearer ", "");
		}
		return null;
	}
	
	

}
