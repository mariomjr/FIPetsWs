package br.com.ufg.fipetsws.dto;

public class UsuarioCreateDto {

	private String nome;
	
	private String telefone;
	
	private Long dataNascimento;
	
	private String email;
	
	private Long dataCadastro;
	
	private Long dataUltimaAtualizacao;
	
	private String redeSocialContato;
	
	private String password;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Long dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Long dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public String getRedeSocialContato() {
		return redeSocialContato;
	}

	public void setRedeSocialContato(String redeSocialContato) {
		this.redeSocialContato = redeSocialContato;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
