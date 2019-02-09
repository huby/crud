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

import com.example.crud.beans.domain.ClienteTest;
import com.example.crud.beans.request.ClienteTestRequest;
import com.example.crud.service.ClienteTestService;

@RestController
@RequestMapping("/clientetest")
public class ClienteTestRestController {

	@Autowired
	private ClienteTestService clienteTestService;

	@GetMapping("/")
	public ResponseEntity<List<ClienteTest>> findAllPersona() {
		return new ResponseEntity<>(clienteTestService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Map<String, String>> save(@RequestBody ClienteTestRequest request) {
		return new ResponseEntity<>(clienteTestService.save(request), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Map<String, String>> update(@RequestBody ClienteTestRequest request) {
		return new ResponseEntity<>(clienteTestService.update(request), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteTest> findPersona(@PathVariable("id") String id) {
		return new ResponseEntity<>(clienteTestService.findById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable("id") String id) {
		return new ResponseEntity<>(clienteTestService.delete(id), HttpStatus.OK);
	}

}
