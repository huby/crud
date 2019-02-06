package com.example.crud.service;

import java.util.List;
import java.util.Map;
import com.example.crud.beans.domain.Paises;

import com.example.crud.beans.request.PaisesRequest;

public interface PaisesService {
	
	Map<String, String> save (PaisesRequest request);
	List<Paises> findAll ();
	Map<String , String > update (PaisesRequest request);
	Map<String, String> delete (String id);
	Paises findById(String id);
	
	
	
	

}
