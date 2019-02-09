package com.example.crud.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.crud.beans.domain.ClienteTest;
import com.example.crud.beans.request.ClienteTestRequest;
import com.example.crud.dao.repository.ClienteTestRepository;
import com.example.crud.service.ClienteTestService;

@Service
public class ClienteTestServiceImpl implements ClienteTestService {

	private ClienteTestRepository clienteTestRepository;

	@Override
	public Map<String, String> save(ClienteTestRequest request) {
		ClienteTest clienteTest = new ClienteTest();
		Map<String, String> result = new HashMap<>();
		String id = UUID.randomUUID().toString();
		clienteTest.setId(id);
		clienteTest.setNombre(request.getNombre());
		clienteTest.setApellidom(request.getApellidom());
		clienteTest.setDireccion(request.getDireccion());
		clienteTest.setTelefono(request.getTelefono());
		clienteTest.setApellidop(request.getApellidop());

		clienteTestRepository.save(clienteTest);
		result.put("id", id);
		return result;
	}

	@Override
	public List<ClienteTest> findAll() {
		return clienteTestRepository.findAll();
	}

	@Override
	public Map<String, String> update(ClienteTestRequest request) {
		Optional<ClienteTest> clienteOptional = clienteTestRepository.findById(request.getId());

		Map<String, String> result = new HashMap<>();

		ClienteTest clienteTest = null;
		String mensaje = "";

		if (clienteOptional.isPresent()) {

			clienteTest = clienteOptional.get();
			clienteTest.setId(request.getId());
			clienteTest.setNombre(request.getNombre());
			clienteTest.setApellidom(request.getApellidom());
			clienteTest.setApellidop(request.getApellidop());
			clienteTest.setTelefono(request.getTelefono());
			clienteTest.setDireccion(request.getDireccion());

			clienteTestRepository.save(clienteTest);
			mensaje = "OK";

		} else {
			mensaje = "No se encontro clientetest.";

		}

		result.put("mensaje", mensaje);

		return result;
	}

	@Override
	public Map<String, String> delete(String id) {
		String mensaje = "";
		Map<String, String> result = new HashMap<>();
		if (clienteTestRepository.existsById(id)) {
			clienteTestRepository.deleteById(id);
			mensaje = "Se la eliminado";
		} else {
			mensaje = "No se ha eliminado/no existe";
		}
		result.put("mensaje", mensaje);

		return result;
	}

	@Override
	public ClienteTest findById(String id) {
		Optional<ClienteTest> clienteOPtional = clienteTestRepository.findById(id);
		return clienteOPtional.get();
	}

}
