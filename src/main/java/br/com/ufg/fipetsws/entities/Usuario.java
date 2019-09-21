package br.com.ufg.fipetsws.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 8646918060853291092L;

	@Id
	private String id;
	
	private String nome;
	
	private String telefone;
	
	private Long dataNascimento;
	
	private String email;
	
	private Long dataCadastro;
	
	private Long dataUltimaAtualizacao;
	
	private String redeSocialContato;
	
//	Endereço
//	Rede social de contato
//	Notificações

	
	public Usuario() {}
	
	public Usuario(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
