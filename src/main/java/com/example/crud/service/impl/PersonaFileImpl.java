package com.example.crud.service.impl;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.beans.request.PersonaRequest;
import com.example.crud.common.FileUtils;
import com.example.crud.service.PersonaService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonaFileImpl implements PersonaService {

    @Value("directory.path")
    private String filePath;

    @Override
    public Map<String, String> save(FileInformationRequest fileInformationRequest) {

        Map<String, String> result = new HashMap<>();
        List<Persona> personaList = null;

        try {

            personaList = FileUtils.readLinesFromTxt(filePath, fileInformationRequest.getFileName()).stream()
                    .map(Persona::new).collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        result.put("ids", personaList.stream().map(item -> item.getId()).collect(Collectors.joining(", ")));

        return result;
    }

    @Override
    public Map<String, String> save(PersonaRequest request) {
        //TODO implementar la logica para el metodo
        return null;
    }

    @Override
    public List<Persona> findAll() {
        //TODO implementar la logica para el metodo
        return null;
    }

    @Override
    public Map<String, String> update(PersonaRequest request) {
        //TODO implementar la logica para el metodo
        return null;
    }

    @Override
    public Map<String, String> delete(String id) {
        //TODO implementar la logica para el metodo
        return null;
    }

    @Override
    public Persona findById(String id) {
        //TODO implementar la logica para el metodo
        return null;
    }
}
