package com.example.crud.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.domain.Persona;
import com.example.crud.service.AutomovilService;
import com.example.crud.service.PersonaService;

@Controller
@RequestMapping("/ui")
public class PersonaUiController
{
	
	@Autowired
	private PersonaService personaservice;
	
	
   /* @GetMapping(path = "/persona")
    public String index() {
        return "persona/index";
    }*/
    
       
    
    @GetMapping(value = "/persona" )
    public String index(Model model) {
		List<Persona> personaList = personaservice.findAll();
		model.addAttribute("personaList", personaList);
		return "persona/index";
		
		
	}
    
    
    
    
}
