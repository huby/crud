package com.example.crud.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;

import com.example.crud.beans.domain.Persona;
import com.example.crud.beans.request.FileInformationRequest;
import com.example.crud.common.FileUtils;

public class PersonaFileImpl {

    @Value("directory.path")
    private String filePath;

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

}
