package br.com.ufg.fipetsws.enums;

public enum EnumTipoAnimal {

	GATO("Gato"), 
	CACHORRO("Cachorro"), 
	OUTRO("Outro");
	
	private String label;
	
	EnumTipoAnimal(String label){
		this.label = label;
	}
	
	public String getLabe() {
		return label;
	}
	
}
