package com.example.crud.service;


import java.util.List;
import java.util.Map;

import com.example.crud.beans.domain.Celular;
import com.example.crud.beans.request.CelularRequest;

public interface CelularService {

	Map<String,String> save (CelularRequest request);
	List<Celular> findAll();
	Map<String, String> update(CelularRequest request);
	Map<String , String> delete(String id);
	
	Celular findById(String id);
	
	
	
	
}
