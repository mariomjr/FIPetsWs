package br.com.ufg.fipetsws.dto;

import br.com.ufg.fipetsws.enums.EnumTipoAnimal;

public class RacaDto {
	
	private String id;

	private String nomeRaca;
	
	private EnumTipoAnimal tipo;
	
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
