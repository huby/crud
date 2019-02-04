package com.example.crud.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Map<String, String> save(PersonaRequest request) {
		
		Persona persona = new Persona();
		Map<String, String> result = new HashMap<>();
		String id = UUID.randomUUID().toString();
		persona.setId(id);
		persona.setPrimerNombre(request.getPrimerNombre());
		persona.setSegundoNombre(request.getSegundoNombre());
		persona.setPrimerApellido(request.getPrimerApellido());
		persona.setSegundoApellido(request.getSegundoApellido());
		persona.setTipoDoc(1);
		persona.setNumeroDoc(request.getNumeroDoc());
		persona.setFechaNacimiento(request.getFechaNacimiento());
		persona.setEstado("1");
		persona.setFechaCreacion(new Date());
		persona.setFechaActualizacion(new Date());
		
		
		personaRepository.save(persona);
		result.put("id", id);
		return result;
	}

	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public Map<String,String> update(PersonaRequest request) {
		Optional<Persona> personaOptional = personaRepository.findById(request.getId());
		
		Map<String, String> result = new HashMap<>();
		
		Persona persona = null;
		String mensaje = "";
		
		if (personaOptional.isPresent()){
			
			persona = personaOptional.get();
			persona.setId(request.getId());
			persona.setPrimerNombre(request .getPrimerNombre());
			persona.setSegundoNombre(request.getSegundoNombre());
			persona.setPrimerApellido(request.getPrimerApellido());
			persona.setSegundoApellido(request.getSegundoApellido());
			persona.setTipoDoc(request.getTipoDoc());
			persona.setNumeroDoc(request.getNumeroDoc());
			persona.setFechaActualizacion(new Date());
			
			personaRepository.save(persona);
			mensaje = "OK";
			
		} else {
			mensaje = "No se encontro persona.";
			
		}
		
		result.put("mensaje", mensaje);
		
		return result;
	}
	@Override
	public Map<String, String> delete(String id) {
		String mensaje  = "";
		Map<String, String> result = new HashMap<>();
		if(personaRepository.existsById(id)) {
			personaRepository.deleteById(id);
			mensaje = "Se la eliminado";
		}else {
			mensaje = "No se ha eliminado/no existe";
		}
		result.put("mensaje", mensaje);
	
		return result;

	}

	@Override
	public Persona findById(String id) {
		Optional<Persona> personaOptional  = personaRepository.findById(id);
		return personaOptional.get();
	}

}
