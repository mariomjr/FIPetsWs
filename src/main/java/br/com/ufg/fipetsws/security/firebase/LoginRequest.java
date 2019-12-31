package br.com.ufg.fipetsws.security.firebase;

public class LoginRequest {

	private String email;
	
	private String password;
	
	private Boolean returnSecureToken;
	

	public LoginRequest(String email, String password, Boolean returnSecureToken) {
		this.email = email;
		this.password = password;
		this.returnSecureToken = returnSecureToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getReturnSecureToken() {
		return returnSecureToken;
	}

	public void setReturnSecureToken(Boolean returnSecureToken) {
		this.returnSecureToken = returnSecureToken;
	}
	
}
