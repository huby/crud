package com.example.crud.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.beans.domain.Empresa;
import com.example.crud.service.EmpresaService;

@Controller
@RequestMapping("/ui")
public class EmpresaUiController {
	@Autowired
	private EmpresaService empresaService;
	
    @GetMapping(value = "/empresa")
    public String index(Model model) {
    	List<Empresa> empresaList = empresaService.findAll();
		model.addAttribute("empresaList", empresaList);
        return "empresa/index";
    }
}
