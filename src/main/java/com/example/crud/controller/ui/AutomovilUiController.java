package com.example.crud.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.service.AutomovilService;

@Controller
@RequestMapping("/ui")
public class AutomovilUiController {

	@Autowired
	private AutomovilService service;
	
	@GetMapping(value = "/automovil")
	public String index(Model model) {
		model.addAttribute("automovilList", service.lista());
		return "automovil/index";
	}
}
