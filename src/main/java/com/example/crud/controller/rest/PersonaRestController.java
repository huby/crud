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
import org.springframework.web.servlet.ModelAndView;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {
    
    @Autowired
	private PersonaService personaService;
	
    @GetMapping("/lista")
    public ModelAndView getPersonaList()
	{
        ModelAndView model = new ModelAndView("persona");
        model.addObject("lista", personaService.getPersonaList());
	    return model;	
	}
    /*   //REST
	public ResponseEntity<List<Persona>> getPersonaList() {
		return new ResponseEntity<>(personaService.getPersonaList(), HttpStatus.OK);
	}*/

	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody PersonaRequest request) {
		return new ResponseEntity<>(personaService.save(request), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, String>> modificar(@RequestBody PersonaRequest request){
		return new ResponseEntity<>(personaService.modificar(request), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPersona(@PathVariable ("id") String id) {
		return new ResponseEntity<>(personaService.listarPersona(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") String id){
		return new ResponseEntity<>(personaService.eliminar(id), HttpStatus.OK);
	}
	
	@PostMapping("/fromFile")
	public ResponseEntity<Map<String, List<String>>> saveFromFile(@RequestBody FileInformationRequest request){
		return new ResponseEntity<>(personaService.saveFromFile(request), HttpStatus.OK);
	}
}
