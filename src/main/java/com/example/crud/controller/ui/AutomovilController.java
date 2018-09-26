package com.example.crud.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.crud.service.AutomovilService;

@Controller
@RequestMapping("/ui")
public class AutomovilController {

	@Autowired
	AutomovilService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/automovil")
	public String index(Model model) {
		model.addAttribute("automovilList", service.lista());
		return "automovil/index";
	}
}
