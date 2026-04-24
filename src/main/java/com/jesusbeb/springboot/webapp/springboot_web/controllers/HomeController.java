package com.jesusbeb.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // redirect Redirecciona a la ruta "/details" (de UserController) cuando se accede a la ruta raíz ("/") o a "/home". La URL en el navegador cambia a "/details"
    // Si se usa forward, la URL en el navegador no cambia a "/details", pero se muestra el contenido de la plantilla "details.html"
    // Forward no pierde los datos del request, mientras que redirect sí los pierde, ya que es una nueva solicitud HTTP
    @GetMapping({"", "/", "/home"})
    public String home(){

        return "redirect:/details";
        //return "forward:/details";
    }
}
