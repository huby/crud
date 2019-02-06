package com.example.crud.beans.request;



import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpresaRequest {

	// modelo por solo Rest
	@JsonProperty
	private String id;
	@JsonProperty
	private String razonSocial;
	@JsonProperty
	private String numeroRuc;
	@JsonProperty
	private String fechaCreacion;
	@JsonProperty
	private String condicion;

	public EmpresaRequest() {
		super();
	}

	public EmpresaRequest(String id, String razonSocial, String numeroRuc, Integer tipoDoc, String fechaCreacion,
			String condicion) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.numeroRuc = numeroRuc;
		this.fechaCreacion = fechaCreacion;
		this.condicion = condicion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}
