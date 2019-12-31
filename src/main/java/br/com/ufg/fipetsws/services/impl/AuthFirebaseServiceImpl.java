package br.com.ufg.fipetsws.services.impl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.ufg.fipetsws.security.firebase.AuthRequest;
import br.com.ufg.fipetsws.security.firebase.LoginRequest;
import br.com.ufg.fipetsws.security.firebase.LoginResponse;
import br.com.ufg.fipetsws.security.firebase.TokenRequest;
import br.com.ufg.fipetsws.security.firebase.UsersResponse;
import br.com.ufg.fipetsws.services.AuthFirebaseService;

@Service
public class AuthFirebaseServiceImpl implements AuthFirebaseService{
	
	private static final String BASE_URL = "https://identitytoolkit.googleapis.com";	
	private static final String ENDPOINT_AUTH = "/v1/accounts:signInWithPassword?key=";
	private static final String ENDPOINT_CREATE = "/v1/accounts:signUp?key=";
	private static final String ENDPOINT_CONSULTA = "/v1/accounts:lookup?key=";
//	private static final String APIKEY = "";	
//	private static FirebaseAppp firebaseApp;
	
	public String getApiKey(){
		return System.getProperty("apiKeyFirebase");
	}
	
	@Override
	public LoginResponse autenticar(AuthRequest authRequest) throws Exception {
		
		LoginRequest loginRequest = new LoginRequest(authRequest.getEmail(), authRequest.getPassword(), true);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		Gson gson = new Gson();
		HttpPost httpPost = new HttpPost(BASE_URL+ENDPOINT_AUTH+getApiKey());
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		HttpEntity entity = new ByteArrayEntity(gson.toJson(loginRequest).getBytes("UTF-8"));
		httpPost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httpPost);
		String apiOutput = EntityUtils.toString(httpresponse.getEntity());
		
		LoginResponse loginResponse =  gson.fromJson(apiOutput, LoginResponse.class);
		if(loginResponse.getError() != null) {
			throw new Exception(loginResponse.getError().getMessage());
		}
		return loginResponse;
	}


	@Override
	public LoginResponse criarUsuario(AuthRequest authRequest) throws Exception {
		LoginRequest loginRequest = new LoginRequest(authRequest.getEmail(), authRequest.getPassword(), true);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		Gson gson = new Gson();
		HttpPost httpPost = new HttpPost(BASE_URL+ENDPOINT_CREATE+getApiKey());
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		HttpEntity entity = new ByteArrayEntity(gson.toJson(loginRequest).getBytes("UTF-8"));
		httpPost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httpPost);
		String apiOutput = EntityUtils.toString(httpresponse.getEntity());
		
		LoginResponse loginResponse =  gson.fromJson(apiOutput, LoginResponse.class);
		if(loginResponse.getError() != null) {
			throw new Exception(loginResponse.getError().getMessage());
		}
		return loginResponse;
	}


	@Override
	public UsersResponse getUser(String token) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		Gson gson = new Gson();
		HttpPost httpPost = new HttpPost(BASE_URL+ENDPOINT_CONSULTA+getApiKey());
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		HttpEntity entity = new ByteArrayEntity(gson.toJson(new TokenRequest(token)).getBytes("UTF-8"));
		httpPost.setEntity(entity);
		HttpResponse httpresponse = httpclient.execute(httpPost);
		String apiOutput = EntityUtils.toString(httpresponse.getEntity());
		
		UsersResponse usersResponse =  gson.fromJson(apiOutput, UsersResponse.class);
		if(usersResponse.getError() != null) {
			throw new Exception(usersResponse.getError().getMessage());
		}
		return usersResponse;
	}


}	
