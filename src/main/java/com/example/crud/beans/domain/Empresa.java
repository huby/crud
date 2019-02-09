package com.example.crud.beans.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

	// modelo total de implementacion automatica y por Rest
	@Id
	private String id;

	@Column
	private String razonSocial;

	@Column
	private String numeroRuc;

	@Column
	private String fechaCreacion;

	@Column
	private String condicion;
	@Column
	private String estado;

	public Empresa() {
		super();
	}

	public Empresa(String id, String razonSocial, String numeroRuc, String fechaCreacion, String condicion, String estado) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.numeroRuc = numeroRuc;
		this.fechaCreacion = fechaCreacion;
		this.condicion = condicion;
		this.estado = estado;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
