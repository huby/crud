package com.example.crud.service;

import java.util.List;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.PersonaRequest;

public interface PersonaService {
	
	String save(PersonaRequest request);
	List<Persona> getPersonaList();
 }
