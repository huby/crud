package com.example.crud.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/actualizar")
public class EmpresaUiActualizar {
	@GetMapping(value = "/empresa")
	public String actualizar() {
		return "empresa/actualizar";
	}
}