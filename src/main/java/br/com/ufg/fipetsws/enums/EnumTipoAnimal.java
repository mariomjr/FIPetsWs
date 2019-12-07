package br.com.ufg.fipetsws.enums;

public enum EnumTipoAnimal {

	GATO("Gato"), 
	CACHORRO("Cachorro");
	
	private String label;
	
	EnumTipoAnimal(String label){
		this.label = label;
	}
	
	public String getLabe() {
		return label;
	}
	
}
