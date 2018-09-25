package com.example.crud.beans.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutomovilRequest {
	
	@JsonProperty
	private String marca;
	@JsonProperty
	private String modelo;
	@JsonProperty
	private String color;
	@JsonProperty
	private String placa;
	@JsonProperty
	private String añoFabricacion;
	
	public AutomovilRequest() {
		super();
	}

	public AutomovilRequest(String marca, String modelo, String color, String placa, String añoFabricacion) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.placa = placa;
		this.añoFabricacion = añoFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAñoFabricacion() {
		return añoFabricacion;
	}

	public void setAñoFabricacion(String añoFabricacion) {
		this.añoFabricacion = añoFabricacion;
	}
	
	
}
