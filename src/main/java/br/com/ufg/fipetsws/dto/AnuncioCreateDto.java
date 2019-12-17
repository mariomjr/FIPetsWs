package br.com.ufg.fipetsws.dto;

import java.util.List;

import br.com.ufg.fipetsws.enums.EnumTipoAnuncio;

public class AnuncioCreateDto {

	private ObjectIdDto usuario;
	
	private AnimalCreateDto animal;
	
	private EnumTipoAnuncio tipo;
	
	private String descricao;
	
	private Double latitude;
	
	private Double longitude;
	
	private String endereco;
	
	private String status;
	
	private Long dataEncontradoPerdido;
	
	private List<String> imagens;
	
	public ObjectIdDto getUsuario() {
		return usuario;
	}

	public void setUsuario(ObjectIdDto usuario) {
		this.usuario = usuario;
	}

	public AnimalCreateDto getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalCreateDto animal) {
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

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
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

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}
	

}
