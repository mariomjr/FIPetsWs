package br.com.ufg.fipetsws.security.firebase;

import java.util.List;

public class UsersResponse {

	private List<UserFire> users;
	
	private ErrorWs error;

	public List<UserFire> getUsers() {
		return users;
	}

	public void setUsers(List<UserFire> users) {
		this.users = users;
	}

	public ErrorWs getError() {
		return error;
	}

	public void setError(ErrorWs error) {
		this.error = error;
	}
	
	
	
}
