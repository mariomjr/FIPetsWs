package br.com.ufg.fipetsws.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
	
	@DBRef
	private List<Anuncio> listAnuncioSeguidos;
	
	private String uidFirebase;

	private String fotoUrl;

	private String cidade;
	
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

	public List<Anuncio> getListAnuncioSeguidos() {
		if(listAnuncioSeguidos == null) {
			listAnuncioSeguidos = new ArrayList<Anuncio>();
		}
		return listAnuncioSeguidos;
	}

	public void setListAnuncioSeguidos(List<Anuncio> listAnuncioSeguidos) {
		this.listAnuncioSeguidos = listAnuncioSeguidos;
	}
	
	public String getUidFirebase() {
		return uidFirebase;
	}

	public void setUidFirebase(String uidFirebase) {
		this.uidFirebase = uidFirebase;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
