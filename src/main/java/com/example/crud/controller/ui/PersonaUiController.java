package com.example.crud.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import com.example.crud.beans.domain.Persona;
import com.example.crud.service.PersonaService;


@Controller
@RequestMapping("/ui")
public class PersonaUiController
{
	@Autowired
	private PersonaService personaService; 
	
    @GetMapping(path = "/persona")
    public String index(Model model) {
    	List<Persona> personaList = personaService.findAll();
    	model.addAttribute("personaList", personaList);
        return "persona/index";
    }
    
    @GetMapping(path = "/agregar_persona")
    public String agregar() {
        return "persona/agregar";
    }
}
