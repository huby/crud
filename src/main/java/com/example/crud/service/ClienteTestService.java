package com.example.crud.service;

import java.util.List;
import java.util.Map;

import com.example.crud.beans.domain.ClienteTest;
import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.ClienteTestRequest;
import com.example.crud.beans.request.PersonaRequest;

public interface ClienteTestService {
	Map<String, String> save(ClienteTestRequest request);
	List<ClienteTest> findAll();
	Map<String, String> update(ClienteTestRequest request);
	Map<String, String> delete(String id);
	ClienteTest findById(String id);
}
