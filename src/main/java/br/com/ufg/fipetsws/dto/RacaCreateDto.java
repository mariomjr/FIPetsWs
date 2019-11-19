package br.com.ufg.fipetsws.dto;

import br.com.ufg.fipetsws.enums.EnumTipoAnimal;

public class RacaCreateDto {

	private String nomeRaca;
	
	private EnumTipoAnimal tipo;

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
