package com.example.crud.service.impl;

import java.util.Date;
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
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public Map<String, String> save(EmpresaRequest request){
		
		Empresa empresa = new Empresa();
		Map<String, String> result = new HashMap<String, String>();
		String id = UUID.randomUUID().toString();
		empresa.setId(id);
		empresa.setRuc(request.getRuc());
		empresa.setRazonSocial(request.getRazonSocial());
		empresa.setDireccion(request.getDireccion());
		empresa.setRubro(request.getRubro());
		empresa.setTelefonoContacto(request.getTelefonoContacto());
		empresa.setFechaCreacion(request.getFechaCreacion());
		empresa.setFechaActualizacion(new Date());
		
		empresaRepository.save(empresa);
		result.put("id", id);
		return result;
	}
	
	@Override
	public List<Empresa> findAll(){
		return empresaRepository.findAll();
	}
	
	@Override
	public Map<String,String> update(EmpresaRequest request) {
		Optional<Empresa> empresaOptional = empresaRepository.findById(request.getId());
		
		Map<String, String> result = new HashMap<>();
		
		Empresa empresa = null;
		String mensaje = "";
		
		if(empresaOptional.isPresent()) {
			empresa = empresaOptional.get();
			empresa.setId(request.getId());
			empresa.setRuc(request.getRuc());
			empresa.setRazonSocial(request.getRazonSocial());
			empresa.setDireccion(request.getDireccion());
			empresa.setRubro(request.getRubro());
			empresa.setTelefonoContacto(request.getTelefonoContacto());
			empresa.setFechaCreacion(request.getFechaCreacion());
			empresa.setFechaActualizacion(new Date());
			
			empresaRepository.save(empresa);
			mensaje = "OK";
		}else {
			mensaje = "No se encontro la empresa";
		}
		
		result.put("mensaje", mensaje);
		return result;
	}
	
	@Override
	public Map<String, String> delete(String id){
		String mensaje = "";
		Map<String, String> result = new HashMap<>();
		
		if(empresaRepository.existsById(id)) {
			empresaRepository.deleteById(id);
			mensaje = "Se ha eliminado";
		}else {
			mensaje = "No existe";
		}
		result.put("mensaje", mensaje);
		return result;
	}
	
	@Override
	public Empresa findById(String id) {
		Optional<Empresa> empreOptional  = empresaRepository.findById(id);
		return empreOptional.get();
	}
}