package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import models.User;

@Controller
public class UserController {

    // Este metodo retorna el nombre (en un String) de la plantilla (html) de la Vista
    // La plantilla esta en el package resources
    // Model de spring inyecta datos a la Vista (plantilla html)
    // addAttribute recibe el nombre del atributo a inyectar y su valor
    // Inicialiamos un objeto User y se pasa a la Vista como objeto
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("JB", "Beltran");
        user.setEmail("jb@mail.com");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
