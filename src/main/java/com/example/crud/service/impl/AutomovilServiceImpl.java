package com.example.crud.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.request.AutomovilRequest;
import com.example.crud.dao.repository.AutomovilRepository;
import com.example.crud.service.AutomovilService;

@Service
public class AutomovilServiceImpl implements AutomovilService  {

	@Autowired
	AutomovilRepository automovilRespository;
	
	@Override
	public Map<String, String> save(AutomovilRequest request) {
		Automovil auto = new Automovil();
		
		Map<String, String> mapeo = new HashMap<>();
		
		String id = UUID.randomUUID().toString();
		auto.setId(id);
		auto.setModelo(request.getModelo());
		auto.setMarca(request.getMarca());
		auto.setColor(request.getColor());
		auto.setPlaca(request.getPlaca());
		auto.setAñoFabricacion(request.getAñoFabricacion());
		auto.setFechaCreacion(new Date());
		auto.setFechaActializacion(new Date());
		
		automovilRespository.save(auto);
		
		mapeo.put("id", id);
		return mapeo;
	}

	@Override
	public List<Automovil> Lista() {
		
		return null;
	}
	
	
}
