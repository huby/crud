package com.example.crud.beans.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteTestRequest {
	@JsonProperty
	private String id;
	@JsonProperty
	private String nombre;
	@JsonProperty
	private String apellidop;
	@JsonProperty
	private String apellidom;
	@JsonProperty
	private String telefono;
	@JsonProperty
	private String direccion;

	public ClienteTestRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteTestRequest(String id, String nombre, String apellidop, String apellidom, String telefono,
			String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.telefono = telefono;
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

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
