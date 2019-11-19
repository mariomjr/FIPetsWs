package br.com.ufg.fipetsws.dto;

public class AnimalCreateDto {

	private String porte;
	
	private String nome;
	
	private String dadosComplementares;
	
	private ObjectIdDto usuario;
	
	private ObjectIdDto raca;
	
	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDadosComplementares() {
		return dadosComplementares;
	}

	public void setDadosComplementares(String dadosComplementares) {
		this.dadosComplementares = dadosComplementares;
	}

	public ObjectIdDto getUsuario() {
		return usuario;
	}

	public void setUsuario(ObjectIdDto usuario) {
		this.usuario = usuario;
	}

	public ObjectIdDto getRaca() {
		return raca;
	}

	public void setRaca(ObjectIdDto raca) {
		this.raca = raca;
	}

}
