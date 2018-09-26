package com.example.crud.service;

import java.util.List;
import java.util.Map;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;

public interface PersonaService {
	
	Map<String, String> save(PersonaRequest request);   // para guardar 
	
	List<Persona> getPersonaList();    //mostrar lista
	
	Map<String,String> modificar(PersonaRequest request);  // para modificar 
	
	Map<String, String> eliminar(String id);
	
	Persona listarPersona(String id);
	
	Map<String, List<String>> saveFromFile(FileInformationRequest request);
 }
