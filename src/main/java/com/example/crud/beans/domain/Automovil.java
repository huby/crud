package com.example.crud.beans.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTOMOVIL")
public class Automovil {
	
	@Id
	private String id;
	@Column
	private String marca;
	@Column
	private String modelo;
	@Column
	private String color;
	@Column
	private String placa;
	@Column
	private String fabricacion;
	@Column
	private Date fechaCreacion;
	@Column
	private Date fechaActializacion;
	
	public Automovil() {
		super();
	}
	
	public Automovil(String id, String marca, String modelo, String color, String placa, String fabricacion,
			Date fechaCreacion, Date fechaActializacion) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.placa = placa;
		this.fabricacion = fabricacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActializacion = fechaActializacion;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(String fabricacion) {
		this.fabricacion = fabricacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActializacion() {
		return fechaActializacion;
	}

	public void setFechaActializacion(Date fechaActializacion) {
		this.fechaActializacion = fechaActializacion;
	}
	
	

	

	
}
