package br.com.ufg.fipetsws.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.ufg.fipetsws.enums.EnumTipoAnuncio;

@Document
public class Anuncio{
	
	@Id
	private String id;
	
	@DBRef(lazy = true)
	private Usuario usuario;
	
	@DBRef
	private Animal animal;
	
	private EnumTipoAnuncio tipo;
	
	private String descricao;
	
	private Long latitude;
	
	private Long longitude;
	
	private String endereco;
	
	private String status;
	
	private Long dataEncontradoPerdido;
	
	private Long dataCriacao;
	
	private Long dataAtualizacao;
	
	private Long visualizacoes;
	
	private List<String> imagens;
	
	public Anuncio() {}
	
	public Anuncio(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public EnumTipoAnuncio getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoAnuncio tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDataEncontradoPerdido() {
		return dataEncontradoPerdido;
	}

	public void setDataEncontradoPerdido(Long dataEncontradoPerdido) {
		this.dataEncontradoPerdido = dataEncontradoPerdido;
	}

	public Long getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Long getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Long dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(Long visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}
	
}
