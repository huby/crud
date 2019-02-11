package com.example.crud.controller.ui;

import com.example.crud.beans.domain.Automovil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return "automovil/agregar";
	}

	/*
	 * 
	 * @GetMapping(value = "automovil") public String save (Model model) {
	 * 
	 * List<Automovil> automovilsave = automovilService.save();
	 * 
	 * }
	 * 
	 */
		
	@GetMapping(path ="/agregar_automovil")
	private String agregar(Model model)
	{
	List<Automovil> automovilList = automovilService.findAll();
	model.addAttribute("automovilList", automovilList);
		return "automovil/agregar";
	}
	
	
	@GetMapping(path="actualizar_automovil")
	 private String update()
	 {
		
		 return "automovil/actualizar";
	 }
	@GetMapping(path="eliminar_automovil")
	 private String delete()
	 {
		
		 return "automovil/eliminar";
	 }
}
