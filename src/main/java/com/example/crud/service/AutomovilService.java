package com.example.crud.service;

import java.util.List;
import java.util.Map;

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.request.AutomovilRequest;

public interface AutomovilService {
	Map<String,String> save(AutomovilRequest request);	
	List<Automovil> findAll();
	Map<String, String> update(AutomovilRequest request);
	Map<String, String> delete(String id);
	Automovil findById(String id);
}
