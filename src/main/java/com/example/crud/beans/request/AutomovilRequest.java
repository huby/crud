package com.example.crud.beans.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutomovilRequest {
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String marca;
	@JsonProperty
	private String modelo;
	@JsonProperty
	private String color;
	@JsonProperty
	private String placa;
	@JsonProperty
	private String fabricacion;
	
	public AutomovilRequest() {
		super();
	}

	public AutomovilRequest(String id, String marca, String modelo, String color, String placa, String anioFabricacion) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.placa = placa;
		this.fabricacion = anioFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
}
