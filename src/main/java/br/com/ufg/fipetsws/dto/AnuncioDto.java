package br.com.ufg.fipetsws.dto;

import java.util.List;

import br.com.ufg.fipetsws.enums.EnumTipoAnuncio;

public class AnuncioDto {
	
	private String id;

	private UsuarioDto usuario;
	
	private AnimalDto animal;
	
	private EnumTipoAnuncio tipo;
	
	private String descricao;
	
	private Long latitude;
	
	private Long longitude;
	
	private String endereco;
	
	private String status;
	
	private Long dataEncontradoPerdido;
	
	private Long dataCriacao;
	
	private Long dataAtualizacao;
	
	private List<String> imagens;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public AnimalDto getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDto animal) {
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

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}
	
}
