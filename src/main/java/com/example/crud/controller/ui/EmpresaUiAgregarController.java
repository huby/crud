package com.example.crud.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/agregar")
public class EmpresaUiAgregarController {

	@GetMapping(value = "/empresa")
	public String agregar() {
		return "empresa/agregar";
	}
}
