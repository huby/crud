package com.example.crud.service;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;

import java.util.List;
import java.util.Map;

public interface PersonaService {
	Map<String, String> save(PersonaRequest request);
	List<Persona> findAll();
	Map<String, String> update(PersonaRequest request);
	Map<String, String> delete(String id);
	Persona findById(String id);
 }
