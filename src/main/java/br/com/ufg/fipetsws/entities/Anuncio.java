package br.com.ufg.fipetsws.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
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
	
	private Double latitude;
	
	private Double longitude;
	
	private GeoJsonPoint location;
	
	private String endereco;
	
	private String status;
	
	private Long dataEncontradoPerdido;
	
	private Long dataCriacao;
	
	private Long dataAtualizacao;
	
	private Long visualizacoes;
	
	private List<String> imagens;

	public GeoJsonPoint getLocation() {
		return location;
	}

	public void setLocation(GeoJsonPoint location) {
		this.location = location;
	}

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
		Anuncio other = (Anuncio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
