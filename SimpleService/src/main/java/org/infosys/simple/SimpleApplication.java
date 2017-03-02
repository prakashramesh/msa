package org.infosys.simple;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link AccountsConfiguration}. This is a deliberate separation of concerns.
 * 
 * 
 */
@EnableAutoConfiguration
@RestController
public class SimpleApplication {
	
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	


	public static void main(String[] args) {
	

		SpringApplication.run(SimpleApplication.class, args);
	}
}
