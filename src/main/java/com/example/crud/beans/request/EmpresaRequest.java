package com.example.crud.beans.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaRequest {

	@JsonProperty
	private String id;
	
	@JsonProperty
	private String ruc;
	
	@JsonProperty
	private String razonSocial;
	
	@JsonProperty
	private String direccion;
	
	@JsonProperty
	private String rubro;
	
	@JsonProperty
	private String telefonoContacto;
	
	@JsonProperty
	private Date fechaCreacion;

	public EmpresaRequest() {
		super();
	}
	
	public EmpresaRequest(String id, String ruc,String razonSocial, String direccion,
			String rubro, String telefonoContacto, Date fechaCreacion,
			Date fechaActualizacion) {
		super();
		this.id = id;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.rubro = rubro;
		this.telefonoContacto = telefonoContacto;
		this.fechaCreacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}
