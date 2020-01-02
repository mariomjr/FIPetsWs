package br.com.ufg.fipetsws.dto;

import javax.validation.constraints.NotNull;

public class RaioConsultaDto {

	@NotNull
	private Double km;

	@NotNull
	private Double latitude;

	@NotNull
	private Double longitude;

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

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}
}
