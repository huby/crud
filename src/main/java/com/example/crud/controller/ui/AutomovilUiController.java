package com.example.crud.controller.ui;

import com.example.crud.beans.domain.Automovil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.service.AutomovilService;

import java.util.List;

@Controller
@RequestMapping("/ui")
public class AutomovilUiController {

	@Autowired
	private AutomovilService automovilService;
	
	@GetMapping(value = "/automovil")
	public String index(Model model) {
		List<Automovil> automovilList = automovilService.findAll();
		model.addAttribute("automovilList", automovilList);
		return "automovil/index";
	}
	
	@GetMapping(value = "/agregar_automovil")
	public String agregar() {
		return "automovil/agregar";
	}
	
	@GetMapping(value = "/compra_automovil")
	public String compra(Model model) {
		List<Automovil> automovilList = automovilService.findAll();
		model.addAttribute("automoviles", automovilList);
		return "automovil/compra";
	}
	
	@GetMapping(value = "/automovil/{id}")
	public String automovil(Model model, @PathVariable("id") String id) {
		Automovil auto = automovilService.findById(id);
		model.addAttribute("automovil", auto);
		return "automovil/automovil";
	}
}
