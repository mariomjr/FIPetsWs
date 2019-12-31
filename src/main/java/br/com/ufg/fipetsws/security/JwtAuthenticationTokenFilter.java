package br.com.ufg.fipetsws.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.ufg.fipetsws.security.firebase.UsersResponse;
import br.com.ufg.fipetsws.services.AuthFirebaseService;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
	
	@Autowired
	AuthFirebaseService authFirebaseService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authToken = request.getHeader("Authorization");
		
		if(SecurityContextHolder.getContext().getAuthentication() == null) {
			UsersResponse users;
			try {
				users = authFirebaseService.getUser(authToken);
				if(users.getError() == null) {
					UserDetails userDetails = this.userDetailsService.loadUserByUsername(users.getUsers().get(0).getEmail());
					
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, null);
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					logger.info("authenticated user , setting security context");
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (Exception e) {
				
			}
			
		}
		filterChain.doFilter(request, response);
	}

}
