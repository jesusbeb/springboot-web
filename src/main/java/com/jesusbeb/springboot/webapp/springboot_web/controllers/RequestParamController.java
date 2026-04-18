package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.dto.ParamDto;
import models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    // http://localhost:8080/api/params/foo?message="mensaje a enviar"
    // Si no se recibe el parámetro, se asigna el valor por defecto "Hello, World!"
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hello, World!") String message) {

        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    // Recibiendo dos paramtetros, uno de tipo String y otro de tipo Integer
    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam() String text, @RequestParam Integer code) {

        ParamMixDto params = new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    // Otra forma de recibir parámetros, a través del objeto HttpServletRequest
    // Valida el parámetro "code" para convertirlo a Integer, si no se puede convertir, se asigna el valor 0
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) { // Si try no entra, catch no se hace nada y code se queda con el valor 0
        }

        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }


}
