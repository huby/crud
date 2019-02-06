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

import com.example.crud.beans.domain.Empresa;
import com.example.crud.beans.request.EmpresaRequest;
import com.example.crud.service.EmpresaService;


@RestController
@RequestMapping("/empresa")
public class EmpresaRestController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/")
	public ResponseEntity<List<Empresa>> findAllEmpresa(){
		return new ResponseEntity<>(empresaService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody EmpresaRequest request){
		return new ResponseEntity<>(empresaService.save(request), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Map<String, String>> update(@RequestBody EmpresaRequest request){
		return new ResponseEntity<>(empresaService.update(request), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empresa> findEmpresa(@PathVariable ("id") String id){
		return new ResponseEntity<>(empresaService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable ("id") String id){
		return new ResponseEntity<>(empresaService.delete(id), HttpStatus.OK);
	}
}
