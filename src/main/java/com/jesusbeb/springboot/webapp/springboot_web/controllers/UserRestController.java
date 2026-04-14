package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    // Este metodo retorna un Map que se mostrara como JSON
    @GetMapping("/details2")
    public Map<String, Object> details(){
        //Instanciamos un Map
        Map<String, Object> body = new HashMap<>();

        // Agregamos valores al Map que creamos
        body.put("title", "Hola Mundo Spring Boot");
        body.put("name", "JB");
        body.put("lastname", "Beltran");
        return body;
    }
}
