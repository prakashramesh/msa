package org.infosys.online.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient

public class OnlineServer {



	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "online-server");
		SpringApplication.run(OnlineServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
/*
	*//**
	 * The AccountService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 *//*
	@Bean
	public WebProductsService productsService() {
		return new WebProductsService(PRODUCTS_SERVICE_URL);
	}

	*//**
	 * Create the controller, passing it the {@link WebAccountsService} to use.
	 * 
	 * @return
	 *//*
	@Bean
	public WebProductsController productsController() {
		return new WebProductsController(productsService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}*/
}
