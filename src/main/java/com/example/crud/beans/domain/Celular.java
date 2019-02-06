package com.example.crud.beans.domain;


import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@Table(name ="CELULAR")
public class Celular {
	
	
	@Id
	public String id;
	
	@Column
	public String marca;
	
	@Column
	public String modelo;
	
	@Column
	public String descripcion;
	
	
	
	public Celular()
	{
		super();
		
	}
	
		
	public Celular(String id, String marca, String modelo, String descripcion) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
