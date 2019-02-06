package com.example.crud.service;

import java.util.List;
import java.util.Map;

import com.example.crud.beans.domain.Empresa;
import com.example.crud.beans.request.EmpresaRequest;

public interface EmpresaService {

	Map<String , String> save(EmpresaRequest request);
	List<Empresa> findAll();
	Map<String, String > update(EmpresaRequest request);
	Map<String , String > delete(String id);
	Empresa findById(String id);
	
	
	
	
}
