package com.example.crud.controller.ui;

import com.example.crud.beans.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.service.PersonaService;

import java.util.List;

@Controller
@RequestMapping("/ui")
public class PersonaUiController
{
	@Autowired
	private PersonaService personaService;
	
    @GetMapping(value = "/persona")
    public String index(Model model) {
    	List<Persona> personaList = personaService.findAll();
		model.addAttribute("personaList", personaList);
        return "persona/index";
    }
    
}
