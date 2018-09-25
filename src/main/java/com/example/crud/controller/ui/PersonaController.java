package com.example.crud.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.crud.service.PersonaService;

@Controller
@RequestMapping("/ui")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/persona")
	public String index(Model model) {
		model.addAttribute("personaList", personaService.getPersonaList());
		return "persona/index";
	}
	
}
