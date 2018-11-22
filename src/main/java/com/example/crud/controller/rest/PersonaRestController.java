package com.example.crud.controller.rest;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {

    @Autowired
	private PersonaService personaService;
	
	private Model model;

    @GetMapping("/list")
	/**/public Model getPersonaList()
	{
	    Persona request = new Persona();
	    personaService.getPersonaList();
	    model.addAttribute("id",request.getId());
	    model.addAttribute("primerNombre",request.getPrimerNombre());
	    model.addAttribute("segundoNombre",request.getSegundoNombre());
	    model.addAttribute("primerApellido",request.getPrimerApellido());
	    model.addAttribute("segundoApellido",request.getSegundoApellido());
	    model.addAttribute("tipoDoc",request.getTipoDoc());
	    model.addAttribute("numeroDoc",request.getNumeroDoc());
	    model.addAttribute("fechaNacimiento", request.getFechaNacimiento());
	    model.addAttribute("estado", request.getEstado());
	    model.addAttribute("fechaCreacion", request.getFechaCreacion());
	    model.addAttribute("fechaActualizacion", request.getFechaActualizacion());
	    return model;	
	}/**/
	/*public ResponseEntity<List<Persona>> getPersonaList() {
	    
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") String id){
		return new ResponseEntity<>(personaService.eliminar(id), HttpStatus.OK);
	}
	
	@PostMapping("/fromFile")
	public ResponseEntity<Map<String, List<String>>> saveFromFile(@RequestBody FileInformationRequest request){
		return new ResponseEntity<>(personaService.saveFromFile(request), HttpStatus.OK);
	}
}
