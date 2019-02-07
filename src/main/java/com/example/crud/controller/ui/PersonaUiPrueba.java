package com.example.crud.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/persona")
public class PersonaUiPrueba {
	@GetMapping(value = "/prueba")
	public String agregar() {
		return "persona/prueba";
	}
}
