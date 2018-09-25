package com.example.crud.beans.request;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonaRequest {
	
	//modelo por solo Rest
	@JsonProperty
	private String id;
	@JsonProperty
	private String primerNombre;
	@JsonProperty
	private String segundoNombre;
	@JsonProperty
	private String primerApellido;
	@JsonProperty
	private String segundoApellido;
	@JsonProperty
	private Integer tipoDoc;
	@JsonProperty
	private String numeroDoc;
	@JsonProperty
	private Date fechaNacimiento;
	
	public PersonaRequest() {
		super();
	}
	
	public PersonaRequest(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			Integer tipoDoc, String numeroDoc, Date fechaNacimiento) {
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Integer getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(Integer tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}
	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
