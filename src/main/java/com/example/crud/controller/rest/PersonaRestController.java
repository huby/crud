package com.example.crud.controller.rest;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/")
	public ResponseEntity<List<Persona>> findAllPersona() {
		return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody PersonaRequest request) {
		return new ResponseEntity<>(personaService.save(request), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, String>> update(@RequestBody PersonaRequest request){
		return new ResponseEntity<>(personaService.update(request), HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> findPersona(@PathVariable ("id") String id) {
		return new ResponseEntity<>(personaService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable("id") String id){
		return new ResponseEntity<>(personaService.delete(id), HttpStatus.OK);
	}
	
}
