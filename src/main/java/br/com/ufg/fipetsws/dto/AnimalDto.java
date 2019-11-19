package br.com.ufg.fipetsws.dto;

public class AnimalDto {
	
	private String id;

	private String porte;
	
	private String nome;
	
	private String dadosComplementares;
	
	private UsuarioDto usuario;
	
	private RacaDto raca;
	
	private Long dataCriacao;

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

	public RacaDto getRaca() {
		return raca;
	}

	public void setRaca(RacaDto raca) {
		this.raca = raca;
	}

	public Long getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
