package com.example.crud.beans.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {

	// modelo total de implementacion automatica y por Rest
	@Id
	private String id;
	
	@Column
	private String primerNombre;
	
	@Column
	private String segundoNombre;
	
	@Column
	private String primerApellido;
	
	@Column
	private String segundoApellido;
	
	@Column
	private Integer tipoDoc;
	
	@Column
	private String numeroDoc;
	
	@Column
	private Date fechaNacimiento;
	
	@Column
	private String estado;
	
	@Column
	private Date fechaCreacion;
	
	@Column
	private Date fechaActualizacion;

	public Persona() {
		super();
	}
	
	public Persona(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			Integer tipoDoc, String numeroDoc, Date fechaNacimiento, String estado, Date fechaCreacion,
			Date fechaActualizacion) {
		super();
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoDoc = tipoDoc;
		this.numeroDoc = numeroDoc;
		this.fechaNacimiento = fechaNacimiento;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Persona(String line) {

		try {
			this.id = line.substring(0,50).trim();
			this.primerNombre =line.substring(50,75).trim();
			this.segundoNombre = line.substring(75,100).trim();
			this.primerApellido =line.substring(100,125).trim();
			this.segundoApellido = line.substring(125,150).trim();
			this.tipoDoc = Integer.parseInt(line.substring(150, 160).trim().trim());
			this.numeroDoc = line.substring(160,180).trim();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			this.fechaNacimiento = sdf.parse(line.substring(180,200).trim());
			this.fechaCreacion = new Date();
			this.estado = "1";
		} catch (ParseException pe) {

		} catch (Exception e) {

		}
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
