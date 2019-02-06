package com.example.crud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Empresa;
import com.example.crud.beans.request.EmpresaRequest;
import com.example.crud.dao.repository.EmpresaRepository;
import com.example.crud.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaRepository empresaRespository;
	
	@Override
	public Map<String, String> save(EmpresaRequest request) {
		Empresa auto = new Empresa();
		Map<String, String> mapeo = new HashMap<>();
		String id = UUID.randomUUID().toString();
		auto.setId(id);
		auto.setRuc(request.getRuc());
		auto.setRazonsocial(request.getRazonsocial());
		auto.setDireccion(request.getDireccion());
		auto.setTelefono(request.getTelefono());
		auto.setRubro(request.getRubro());
		
		empresaRespository.save(auto);
		
		mapeo.put("id", id);
		return mapeo;
	}

	@Override
	public List<Empresa> findAll() {
		return empresaRespository.findAll();
	}

	@Override
	public Map<String, String> update(EmpresaRequest request) {
		String mensaje = "";
		Optional<Empresa> autos = empresaRespository.findById(request.getId());
		Map<String, String> mapeo = new HashMap<>();
		
		Empresa auto = null;
		if(autos.isPresent()) {
			auto = autos.get();
			auto.setRuc(request.getRuc());
			auto.setRazonsocial(request.getRazonsocial());
			auto.setDireccion(request.getDireccion());
			auto.setTelefono(request.getTelefono());
			auto.setRubro(request.getRubro());
			
			empresaRespository.save(auto);
			
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
		if(empresaRespository.existsById(id)) {
			empresaRespository.deleteById(id);
			mensaje = "Se ha eliminado";
		}else {
			mensaje  = "No existe";
		}
		mapeo.put("mensaje", mensaje);
		
		return mapeo;
	}

	@Override
	public Empresa findById(String id) {
		Optional<Empresa> empresa = empresaRespository.findById(id);
		return empresa.get();
	}
}
