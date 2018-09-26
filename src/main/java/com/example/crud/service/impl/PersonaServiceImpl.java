package com.example.crud.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.common.FileUtils;
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
	public List<Persona> getPersonaList() {
		return personaRepository.findAll();
	}

	@Override
	public Map<String,String> modificar(PersonaRequest request) {
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
	public Map<String, String> eliminar(String id) {
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
	public Persona listarPersona(String id) {
		Optional<Persona> personaOptional  = personaRepository.findById(id);
		return personaOptional.get();
	}

	@Override
	public Map<String, String> saveFromFile(FileInformationRequest request) {
		Map<String, String> result = new HashMap<>();
		List<String> listaPersona = new ArrayList<>();
		
		try {
			listaPersona = FileUtils.readLinesFromTxt(request.getDirectory(),request.getFileName());
			for(int i = 0; i<listaPersona.size();i++){
				Persona persona = new Persona();
			
				String personaStr = listaPersona.get(i); //recorre toda la nueva lista 
				persona.setId(personaStr.substring(0,50).trim());
				persona.setPrimerNombre(personaStr.substring(50,75).trim());
				persona.setSegundoNombre(personaStr.substring(75,100).trim());
				persona.setPrimerApellido(personaStr.substring(100,125).trim());
				persona.setSegundoApellido(personaStr.substring(125,150).trim());
				persona.setTipoDoc(Integer.parseInt(personaStr.substring(150, 160).trim().trim()));
				persona.setNumeroDoc(personaStr.substring(160,180).trim());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				persona.setFechaNacimiento(sdf.parse(personaStr.substring(180,200).trim()));
				persona.setFechaCreacion( new Date());
				persona.setEstado("1");
				
				personaRepository.save(persona);
				
				result.put("id", persona.getId());
				
			}
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
