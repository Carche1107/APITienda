package com.avvale.API.APITienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAsync
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ApiTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTiendaApplication.class, args);
	}

}
