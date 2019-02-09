package com.example.crud.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ui")
public class ClienteTestUiController {
	@GetMapping(path = "/clientetest")
	public String index() {
		return "clientetest/index";
	}

	@GetMapping(path = "/agregar_clientetest")
	public String agregar() {
		return "clientetest/agregar";
	}
}
