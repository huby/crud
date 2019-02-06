package com.example.crud.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Celular;
import com.example.crud.beans.request.CelularRequest;
import com.example.crud.dao.repository.CelualrRepository;
import com.example.crud.service.CelularService;

@Service
public class CelularServiceImpl  implements CelularService {
	
	@Autowired
	private CelualrRepository celularRepository;

	@Override
	public Map<String, String> save(CelularRequest request) {
		
		Celular celular = new Celular();
		
		Map<String, String> mapeo = new HashMap<>();
		String id = UUID.randomUUID().toString();
		celular.setMarca(request.getMarca());
		celular.setModelo(request.getModelo());
		celular.setDescripcion(request.getDescripcion());
		
		celularRepository.save(celular);
		
		
		
		
		
		return null;
	}

	@Override
	public List<Celular> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> update(CelularRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Celular findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
