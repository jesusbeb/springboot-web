package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.User;
import models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    // http://localhost:8080/api/var/baz/cualquier mensaje
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    // http://localhost:8080/api/var/mix/phone/1234
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixParhVar(@PathVariable String product, @PathVariable String id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {

        // Hacer algo con el usuario, como guardarlo en la base de datos
        user.setName(user.getName().toUpperCase()); // Ejemplo de procesamiento

        return user;
    }
}
