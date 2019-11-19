package br.com.ufg.fipetsws.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Denuncia{
	
	@Id
	private String id;
	
	@DBRef(lazy = true)
	private Anuncio anuncio;
	
	@DBRef(lazy = true)
	private Usuario usuarioDenunciante;
	
	@DBRef(lazy = true)
	private Usuario usuarioReportado;
	
	private String motivo;
	
	private String justificativa;
	
	private Long data;
	
	public Denuncia() {}
	
	public Denuncia(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Usuario getUsuarioDenunciante() {
		return usuarioDenunciante;
	}

	public void setUsuarioDenunciante(Usuario usuarioDenunciante) {
		this.usuarioDenunciante = usuarioDenunciante;
	}

	public Usuario getUsuarioReportado() {
		return usuarioReportado;
	}

	public void setUsuarioReportado(Usuario usuarioReportado) {
		this.usuarioReportado = usuarioReportado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}
}
