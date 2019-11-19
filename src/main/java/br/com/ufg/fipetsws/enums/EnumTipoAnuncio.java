package br.com.ufg.fipetsws.enums;

public enum EnumTipoAnuncio {

	ENCONTRADO("Encontrado"), 
	PERDIDO("Perdido");
	
	private String label;
	
	EnumTipoAnuncio(String label){
		this.label = label;
	}
	
	public String getLabe() {
		return label;
	}
	
}
