package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}

/*  INGRESAR DATOS - PERSONA
{
    "primerNombre" : "miguel",
    "segundoNombre": "angel",
    "primerApellido": "bazan",
    "segundoApellido" : "cerna",
    "tipoDoc" : 1,
    "numeroDoc" : "74539297",
    "fechaNAcimiento" : "16/07/1995"
}
/*
{
    "marca" : "Kia",
    "modelo": "Rio 2018",
    "color": "Rojo",
    "placa" : "LI - 584",
    "fabricacion" : "2018"
}
 */

