package com.example.crud.beans.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaRequest {

	@JsonProperty
	private String id;
	@JsonProperty
	private String ruc;
	@JsonProperty
	private String razonsocial;
	@JsonProperty
	private String direccion;
	@JsonProperty
	private String telefono;
	@JsonProperty
	private String rubro;

	public EmpresaRequest() {
		super();
	}

	public EmpresaRequest(String id,String ruc,String razonsocial,String direccion,String telefono,String rubro) {
		super();
		this.id = id;
		this.ruc = ruc;
		this.razonsocial = razonsocial;
		this.direccion =  direccion;
		this.telefono = telefono;
		this.rubro = rubro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	
}
