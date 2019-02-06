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
import com.example.crud.beans.domain.Cliente;
import com.example.crud.beans.request.AutomovilRequest;
import com.example.crud.beans.request.ClienteRequest;
import com.example.crud.service.ClienteService;
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
	@Autowired
	ClienteService clienteService;
	@GetMapping("/")
	public ResponseEntity<List<Cliente>> lista() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody ClienteRequest request){
		return new ResponseEntity<>(clienteService.save(request), HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") String id){
		return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarUno(@PathVariable("id") String id){
		return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
	}
	@PutMapping("/")
	public ResponseEntity<Map<String,String>> modificar(@RequestBody ClienteRequest request){
		return new ResponseEntity<>(clienteService.update(request), HttpStatus.OK);
	}
}
