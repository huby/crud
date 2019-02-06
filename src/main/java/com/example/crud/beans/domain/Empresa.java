package com.example.crud.beans.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPRESA")
public class Empresa {
	
	@Id
	public String id;
	
		
	@Column 
	public String direccion;
	
	
	@Column
	public String nombre;
	
	
	@Column 
	public String ruc;
	
	public Empresa() {
		super();
	}

	public Empresa(String id, String direccion, String nombre, String ruc) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.ruc = ruc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	
	
	
	
	


	
	
	

}
