package br.com.ufg.fipetsws.services;

import org.springframework.stereotype.Component;

import br.com.ufg.fipetsws.security.firebase.AuthRequest;
import br.com.ufg.fipetsws.security.firebase.LoginResponse;
import br.com.ufg.fipetsws.security.firebase.UsersResponse;

@Component
public interface AuthFirebaseService {

	LoginResponse autenticar(AuthRequest authRequest)  throws Exception ;
	
	LoginResponse criarUsuario(AuthRequest authRequest)  throws Exception ;
		
	UsersResponse getUser(String token)  throws Exception ;
	
}
