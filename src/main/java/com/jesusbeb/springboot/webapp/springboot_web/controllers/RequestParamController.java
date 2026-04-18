package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.dto.ParamDto;

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

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam() String text, @RequestParam Integer code) {

        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }


}
