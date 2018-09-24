package com.example.crud.controller.rest;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.service.PersonaService;

@RestController
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Persona>> getPersonaList() {
		return new ResponseEntity<>(personaService.getPersonaList(), HttpStatus.OK);
	}

	@PostMapping("/persona")
	public ResponseEntity<String> save(@Valid @RequestBody PersonaRequest request) {
		return new ResponseEntity<>(personaService.save(request), HttpStatus.OK);
	}
	
	@PutMapping("/modificar")
	public Persona modificar(@RequestBody Persona id){
		return personaService.modificar(id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") String id) {
		return personaService.eliminar(id);
	}

}
