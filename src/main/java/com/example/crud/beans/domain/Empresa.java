package com.example.crud.beans.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPRESA")
public class Empresa {
	@Id
	private String id;
	
	@Column
	private String ruc;
	
	@Column
	private String razonsocial;
	
	@Column
	private String direccion;
	
	@Column 
	private String telefono;
	
	@Column 
	private String rubro;
	
	public Empresa() {
		super();
	}
	
	public Empresa(String id,String ruc,String razonsocial,String direccion,String telefono,String rubro) {
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
