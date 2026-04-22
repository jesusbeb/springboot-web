package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    // @Value inyecta el valor de la propiedad "config.username" del application.properties
    @Value("${config.username}")
    private String username;
    
    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("${config.code}")
    private Integer code;

    // Lenguaje de expresiones de Spring (SpEL) para manipular el valor de la propiedad antes de inyectarlo. #{${}} para acceder a la propiedad.
    // @Value("#{ '${config.listOfValues}'.toUpperCase() }") inyecta el valor de la propiedad "config.listOfValues" del application.properties, lo convierte a mayúsculas y lo divide en una lista usando la coma como separador
    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}" )
    private List<String> valueList;

    // @Value("#{ '${config.listOfValues}'.toUpperCase() }") inyecta el valor de la propiedad "config.listOfValues" del application.properties, lo convierte a mayúsculas y lo asigna a una variable String
    @Value("#{ '${config.listOfValues}'.toUpperCase()}" )
    private String valueString;

    // @Value("#{${config.valuesMap}}") inyecta el valor de la propiedad "config.valuesMap" del application.properties, que es un mapa en formato JSON, y lo convierte a un Map<String, Object>
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    // @Value("#{${config.valuesMap}.product}") inyecta el valor de la clave "product" del mapa "config.valuesMap" del application.properties
    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    // Inyectar el objeto Environment para acceder a las propiedades de los properties de forma programática
    @Autowired
    private Environment environment;


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

    @GetMapping("/values")
        // @Value(${config.message2}) inyecta el valor de la propiedad "config.message2" del application.properties
        public Map<String, Object> values(@Value("${config.message2}") String message2) {

        // Crear un mapa para almacenar los valores a retornar en formato JSON
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);       
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("code", code);
        json.put("code2", environment.getProperty("config.code", Integer.class)); // Obtener el valor de la propiedad "config.code" del values.properties usando el objeto Environment y convertirlo a Integer ya que por defecto las propiedades se inyectan como String
        json.put("message2", message2);
        json.put("message3", environment.getProperty("config.message2")); // Obtener el valor de la propiedad "config.message2" del values.properties usando el objeto Environment
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        
        return json;

    }
}
