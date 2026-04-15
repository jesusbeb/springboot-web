package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.User;
import models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {


    @GetMapping("/details")
    public UserDto details(){

        User user = new User("JB", "Beltran");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");

        return userDto;
    }



    // Este metodo retorna un Map que se mostrara como JSON
    // Inicializamos un objeto User para pasarlo al Map
    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){
        User user = new User("JB", "Beltran");
        //Instanciamos un Map
        Map<String, Object> body = new HashMap<>();

        // Agregamos valores al Map que creamos
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
