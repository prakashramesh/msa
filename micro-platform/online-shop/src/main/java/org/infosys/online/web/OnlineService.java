package org.infosys.online.web;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * 
 */

@Service
public class OnlineService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String productServiceUrl;
	protected String cartsServiceUrl;
	
	public static final String PRODUCTS_SERVICE_URL = "http://PRODUCTS-SERVICE";
	public static final String CARTS_SERVICE_URL = "http://CARTS-SERVICE";

	protected Logger logger = Logger.getLogger(OnlineService.class
			.getName());

	public OnlineService(String productServiceUrl,String cartsServiceUrl) {
		
		this.productServiceUrl = productServiceUrl.startsWith("http") ? productServiceUrl
				: "http://" + productServiceUrl;
		this.cartsServiceUrl = cartsServiceUrl.startsWith("http") ? cartsServiceUrl
				: "http://" + cartsServiceUrl;
	}
	
	public OnlineService() {		
		
		 this(PRODUCTS_SERVICE_URL,CARTS_SERVICE_URL);
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory().getClass());
	}

	public Product findProduct(Long id) {

		
		return restTemplate.getForObject(productServiceUrl + "/products/"+id,
				Product.class);
	}
	
	public List findAllProducts() {

		
		return restTemplate.getForObject(productServiceUrl + "/products/all",List.class);
	}
	
	public CartItem addItem(String productId) {
		
		Product product = findProduct(new Long(productId));
		
		CartItem cartItem = new CartItem();
		cartItem.setProductName(product.getDescription());
		cartItem.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		cartItem.setPrice(product.getPrice());

		ResponseEntity<CartItem>  response= restTemplate.postForEntity(cartsServiceUrl+"/addItemNew", cartItem, CartItem.class);
		
		CartItem addedItem = response.getBody();
		
		return addedItem;
	}
	
	public String removeItem(String cartItemId) {
		
		

		return restTemplate.getForObject(cartsServiceUrl + "/removeItem?cartItemId="+cartItemId,String.class);
		
		
	}
	
	public List<CartItem> findCartItems(){
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return restTemplate.getForObject(cartsServiceUrl +"/cart?userName="+userName,List.class);
		
	}
	
	
}
