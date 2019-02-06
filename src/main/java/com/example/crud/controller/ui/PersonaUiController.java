package com.example.crud.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.service.PersonaService;

@Controller
@RequestMapping("/ui")
public class PersonaUiController
{
	@Autowired
	private PersonaService personaService;
	
    @GetMapping(path = "/persona")
    public String index(Model model) {
    	model.addAttribute("personaList", personaService.findAll());
        return "persona/index";
    }
    @GetMapping(path = "/agregarpersona")
    public String index() {
        return "persona/agregarpersona";
    }
}
