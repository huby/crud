package com.example.crud.beans.request;



import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaRequest {
	
	
	@JsonProperty
	public String id;
	
	@JsonProperty
	public String nombre;
	
	@JsonProperty 
	public String ruc;
	
	@JsonProperty 
	public String direccion;

	public EmpresaRequest() {
		super();
	}
	
	
	

	public EmpresaRequest(String id, String nombre, String ruc, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
	
	
	

}
