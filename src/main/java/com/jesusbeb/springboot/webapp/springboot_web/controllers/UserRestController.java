package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // Este metodo retorna un Map que se mostrara como JSON
    // Inicializamos un objeto User para pasarlo al Map
    @GetMapping("/details")
    public Map<String, Object> details(){
        User user = new User("JB", "Beltran");
        //Instanciamos un Map
        Map<String, Object> body = new HashMap<>();

        // Agregamos valores al Map que creamos
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
