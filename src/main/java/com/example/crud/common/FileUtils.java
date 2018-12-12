package com.example.crud.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /**
     * 
     * @param path /path/to/directory 
     * @param fileName txt file without extension
     * @return
     * @throws IOException
     */
    public static List<String> readLinesFromTxt(String path, String fileName) throws IOException {
        Path file = Paths.get(path + "/" + fileName + Constants.DOT + Constants.TXT_EXTENSION);
        return Files.readAllLines(file, StandardCharsets.UTF_8);
    }
    
    public static List<String> readLinesFromTxt(String path, String fileName, int longitud) throws IOException {
        Path file = Paths.get(path + "/" + fileName + Constants.DOT + Constants.TXT_EXTENSION);
        String line = Files.readAllLines(file, StandardCharsets.UTF_8).get(0);
        List<String> personaLista = new ArrayList<>();
        int counter = 0;
        
        while(line.length() > counter) {
        	String persona = line.substring(counter, (counter = counter + longitud));
        	personaLista.add(persona);
        }
        
        return personaLista;
    }
    
    
}
