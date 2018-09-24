package com.example.crud.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.dao.repository.PersonaRepository;
import com.example.crud.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository; 
	
	@Override
	public String save(PersonaRequest request) {
		Persona persona = new Persona();
		String id = UUID.randomUUID().toString();
		persona.setId(id);
		persona.setPrimerNombre(request.getPrimerNombre());
		persona.setSegundoNombre(request.getSegundoNombre());
		persona.setPrimerApellido(request.getPrimerApellido());
		persona.setSegundoApellido(request.getSegundoApellido());
		persona.setTipoDoc(1);
		persona.setNumeroDoc(request.getNumeroDoc());
		persona.setEstado("1");
		persona.setFechaCreacion(new Date());
		persona.setFechaActualizacion(new Date());
		
		personaRepository.save(persona);
		
		return id;
	}

	@Override
	public List<Persona> getPersonaList() {
		return personaRepository.findAll();
	}

	@Override
	public Persona modificar(Persona id) {
		return personaRepository.save(id);
	}
	@Override
	public String eliminar(String id) {
		personaRepository.deleteById(id);
		return "Eliminado" + id;
	}

}
