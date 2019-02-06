package com.example.crud.beans.request;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteRequest {
	@JsonProperty
	private String id;
	@JsonProperty
	private String nombre;
	@JsonProperty
	private String direccion;

	@JsonProperty
	private String apellido;
	@JsonProperty
	private Date fechanac;
	@JsonProperty
	private String email;

	public ClienteRequest() {
		super();
	}

	public ClienteRequest(String id, String nombre, String direccion, String apellido, Date fechanac, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.apellido = apellido;
		this.fechanac = fechanac;
		this.email = email;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
