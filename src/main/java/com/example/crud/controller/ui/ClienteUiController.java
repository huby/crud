package com.example.crud.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.crud.beans.domain.Cliente;
import com.example.crud.service.ClienteService;

@Controller
@RequestMapping("/ui")
public class ClienteUiController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/cliente")
	public String index(Model model) {
		List<Cliente> clientelList = clienteService.findAll();
		model.addAttribute("clientelList", clientelList);
		return "cliente/index";
	}
//	@GetMapping(path= "/agregar_cliente")
//	public String agregar() {
//		return "cliente/agregar";
//	}
}
