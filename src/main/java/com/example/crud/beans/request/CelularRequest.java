package com.example.crud.beans.request;



import com.fasterxml.jackson.annotation.JsonProperty;

public class CelularRequest {

	
	@JsonProperty
	public String id;
	@JsonProperty
	public String marca;
	@JsonProperty
	public String modelo;
	@JsonProperty
	public String descripcion;
	
	
	public CelularRequest() {
		super();
		
	}


	public CelularRequest(String id, String marca, String modelo, String descripcion) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	
	
}
