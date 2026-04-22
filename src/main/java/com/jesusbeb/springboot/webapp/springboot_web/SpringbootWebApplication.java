package com.jesusbeb.springboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
//@PropertySource("classpath:values.properties") // Carga un archivo de propiedades personalizado
@PropertySources({
	@PropertySource("classpath:values.properties") // Se puede cargar varios archivos de propiedades personalizados
})
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
