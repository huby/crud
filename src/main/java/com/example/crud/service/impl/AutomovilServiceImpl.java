package com.example.crud.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.Automovil;
import com.example.crud.beans.request.AutomovilRequest;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.common.FileUtils;
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

	@Override
	public Map<String, String> saveFileAuto(FileInformationRequest request) {
		Map<String, String> result = new HashMap<>();
		List<String> listaAuto =  new ArrayList<>();
		
		try {
			listaAuto  = FileUtils.readLinesFromTxt(request.getDirectory(), request.getFileName());
			for(int i = 0; i < listaAuto.size(); i++) {
				Automovil automovil = new Automovil();
				String listaAutoRead  = listaAuto.get(i);
				automovil.setId(listaAutoRead.substring(0, 50));
				automovil.setMarca(listaAutoRead.substring(50,60));
				automovil.setModelo(listaAutoRead.substring(60, 70));
				automovil.setColor(listaAutoRead.substring(70,80));
				automovil.setPlaca(listaAutoRead.substring(80,90));
				automovil.setFabricacion(listaAutoRead.substring(90,100));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				automovil.setFechaCreacion(sdf.parse(listaAutoRead.substring(101,150)));

			}
			
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}	
	
}
