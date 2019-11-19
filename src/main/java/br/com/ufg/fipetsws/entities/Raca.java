package br.com.ufg.fipetsws.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.ufg.fipetsws.enums.EnumTipoAnimal;

@Document
public class Raca{
	
	@Id
	private String id;
	
	private String nomeRaca;
	
	private EnumTipoAnimal tipo;
	
	public Raca() {}
	
	public Raca(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeRaca() {
		return nomeRaca;
	}

	public void setNomeRaca(String nomeRaca) {
		this.nomeRaca = nomeRaca;
	}

	public EnumTipoAnimal getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoAnimal tipo) {
		this.tipo = tipo;
	}

}
