package br.com.ufg.fipetsws.entities;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario{
	
	@Id
	private String id;
	
	private String nome;
	
	private String telefone;
	
	private Long dataNascimento;
	
	@Indexed(unique = true)
	@Email(message="E-mail inválido")
	private String email;
	
	private Long dataCadastro;
	
	private Long dataUltimaAtualizacao;
	
	private String redeSocialContato;
	
//	Endereço
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
