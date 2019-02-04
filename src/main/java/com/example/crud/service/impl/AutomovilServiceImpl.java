package com.example.crud.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
	private AutomovilRepository automovilRespository;
	
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
		auto.setFabricacion(request.getFabricacion());
		auto.setFechaCreacion(new Date());
		auto.setFechaActializacion(new Date());
		
		automovilRespository.save(auto);
		
		mapeo.put("id", id);
		return mapeo;
	}

	@Override
	public List<Automovil> findAll() {
		return automovilRespository.findAll();
	}

	@Override
	public Map<String, String> update(AutomovilRequest request) {
		String mensaje = "";
		Optional<Automovil> autos = automovilRespository.findById(request.getId());
		Map<String, String> mapeo = new HashMap<>();
		
		Automovil auto = null;
		if(autos.isPresent()) {
			auto = autos.get();
			auto.setModelo(request.getModelo());
			auto.setMarca(request.getMarca());
			auto.setColor(request.getColor());
			auto.setPlaca(request.getPlaca());
			auto.setFabricacion(request.getFabricacion());
			auto.setFechaActializacion(new Date());
			
			automovilRespository.save(auto);
			
			mensaje = "Se ha modificado";
		}else {
			mensaje = "No modificado/no existe";
		}
		
		mapeo.put("mensaje", mensaje);
		
		return mapeo;
	}

	@Override
	public Map<String, String> delete(String id) {
		Map<String, String> mapeo = new HashMap<>();
		String mensaje = null;
		if(automovilRespository.existsById(id)) {
			automovilRespository.deleteById(id);
			mensaje = "Se ha eliminado" + id;
		}else {
			mensaje  = "No existe";
		}
		mapeo.put("mensaje", mensaje);
		
		
		return mapeo;
	}

	@Override
	public Automovil findById(String id) {
		Optional<Automovil> automovil = automovilRespository.findById(id);
		return automovil.get();
	}
	
}
