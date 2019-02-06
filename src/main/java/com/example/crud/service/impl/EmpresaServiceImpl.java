package com.example.crud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.domain.Empresa;
import com.example.crud.beans.request.EmpresaRequest;
import com.example.crud.dao.repository.EmpresaRepository;
import com.example.crud.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	EmpresaRepository empresarepository;

	@Override
	public Map<String, String> save(EmpresaRequest request) {

		Empresa emp = new Empresa();

		Map<String, String> mapeo = new HashMap<>();

		String id = UUID.randomUUID().toString();
		emp.setId(request.getId());
		emp.setId(id);
		emp.setDireccion(request.getDireccion());
		emp.setNombre(request.getNombre());
		emp.setRuc(request.getRuc());
		empresarepository.save(emp);

		mapeo.put("id", id);

		return mapeo;
	}

	@Override
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return empresarepository.findAll();
	}

	@Override
	public Map<String, String> update(EmpresaRequest request) {
		String mensaje = "";
		Optional<Empresa> empresa = empresarepository.findById(request.getId());
		Map<String, String> mapeo = new HashMap<>();

		Empresa emp = null;

		if (empresa.isPresent()) {
			emp = empresa.get();
			emp.setDireccion(request.getDireccion());
			emp.setNombre(request.getNombre());
			emp.setRuc(request.getRuc());
			empresarepository.save(emp);

			mensaje = "Se ha modicicado";
			

		}else
		{
			mensaje ="No se ha modificado";
		}
		
		mapeo.put("mensaje", mensaje);

		return mapeo;
	}

	@Override
	public Map<String, String> delete(String id) {
		// TODO Auto-generated method stub
		Map<String, String> mapeo = new HashMap<>();
		String mensaje = null;
		if(empresarepository.existsById(id)) {
			empresarepository.deleteById(id);
			mensaje = "Se ha eliminado" + id;
		}
		else
		{
			mensaje ="NO existe";
		}
		mapeo.put("mensaje", mensaje);
		return mapeo;
		
		
		
		
	}

	@Override
	public Empresa findById(String id) {
		Optional<Empresa> empresa = empresarepository.findById(id);
		return empresa.get();
	}

}
