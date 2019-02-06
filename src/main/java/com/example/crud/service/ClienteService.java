package com.example.crud.service;

import java.util.List;
import java.util.Map;
import com.example.crud.beans.domain.Cliente;
import com.example.crud.beans.request.ClienteRequest;

public interface ClienteService {

	Map<String,String> save(ClienteRequest request);	
	List<Cliente> findAll();
	Map<String, String> update(ClienteRequest request);
	Map<String, String> delete(String id);
	Cliente findById(String id);
}
