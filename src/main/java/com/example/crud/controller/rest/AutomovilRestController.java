package com.example.crud.controller.rest;

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

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.request.AutomovilRequest;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.service.AutomovilService;

@RestController
@RequestMapping("/automovil")
public class AutomovilRestController {
	
	@Autowired
	AutomovilService automovilService;
	
	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody AutomovilRequest request){
		return new ResponseEntity<>(automovilService.save(request), HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public ModelAndView lista()
	{
	    ModelAndView mode = new ModelAndView("automovil");
	    mode.addObject("automovilList", automovilService.lista());
	    return mode;
	}
	/*
	public ResponseEntity<List<Automovil>> lista() {
		return new ResponseEntity<>(automovilService.lista(), HttpStatus.OK);
	}*/
	
	@PutMapping("/")
	public ResponseEntity<Map<String,String>> modificar(@RequestBody AutomovilRequest request){
		return new ResponseEntity<>(automovilService.modificar(request), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") String id){
		return new ResponseEntity<>(automovilService.eliminar(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Automovil> listarUno(@PathVariable("id") String id){
		return new ResponseEntity<>(automovilService.listarUno(id), HttpStatus.OK);
	}
	
	@PostMapping("/fileAuto")
	public ResponseEntity<Map<String, String>> saveFilaAuto(@RequestBody FileInformationRequest request){
		return new ResponseEntity<>(automovilService.saveFileAuto(request), HttpStatus.OK);
	}

}
