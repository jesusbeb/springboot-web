package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    // ModelMap de Spring para pasar datos a la Vista, implemente de Map
    @GetMapping("/list")
    public String list(ModelMap model){
            
        model.addAttribute("title", "Lista de usuarios");
        return "list";
    }
    

    // @ModelAttribute inyecta el valor del atributo "users" a la Vista (plantilla html) antes de ejecutar cualquier handler (metodo) de este controlador
    // Ya no es necesario agregar el atributo "users" a cada handler (metodo) de este controlador
    // El valor del atributo "users" se puede usar en cualquier plantilla html de este controlador
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User("User4", "lastname4"),
            new User("user5", "lastname5", "user5@email.com"),
            new User("user6", "lastname6", "user6@mail.com"),
            new User("user7", "lastname7"));
    }
}
