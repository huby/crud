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
import com.example.crud.beans.domain.Cliente;
import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.ClienteRequest;
import com.example.crud.dao.repository.ClienteRepository;
import com.example.crud.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Map<String, String> save(ClienteRequest request) {
		Cliente cliente = new Cliente();
		Map<String, String> mapeo = new HashMap<>();
		String id = UUID.randomUUID().toString();
		cliente.setId(id);
		cliente.setDireccion(request.getDireccion());
		cliente.setApellido(request.getApellido());
		cliente.setNombre(request.getNombre());
		cliente.setFechanac(request.getFechanac());
		cliente.setEmail(request.getEmail());
		clienteRepository.save(cliente);

		mapeo.put("id", id);
		
		return mapeo;
	}

	@Override
	public Map<String, String> update(ClienteRequest request) {
		String mensaje = "";
		Optional<Cliente> clientes = clienteRepository.findById(request.getId());
		Map<String, String> mapeo = new HashMap<>();
		
		Cliente cliente = null;
		if(clientes.isPresent()) {
			cliente = clientes.get();
			cliente.setApellido(request.getApellido());
			cliente.setEmail(request.getEmail());
			cliente.setDireccion(request.getDireccion());
			cliente.setNombre(request.getNombre());
			cliente.setFechanac(new Date());

			clienteRepository.save(cliente);
			mensaje = "Se ha modificado";
			
		}else {
			mensaje = "No modificado/no existe";
		}
		
		mapeo.put("mensaje", mensaje);
		
		return null;
	}

	@Override
	public Map<String, String> delete(String id) {
		String mensaje = "";
		Map<String, String> result = new HashMap<>();
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			mensaje = "Se la eliminado";
		} else {
			mensaje = "No se ha eliminado/no existe";
		}
		result.put("mensaje", mensaje);

		return result;
	}

	@Override
	public Cliente findById(String id) {
		Optional<Cliente> personaOptional = clienteRepository.findById(id);
		return personaOptional.get();
	}

}
