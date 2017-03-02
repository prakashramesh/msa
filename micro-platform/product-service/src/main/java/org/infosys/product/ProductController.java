package org.infosys.product;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * A RESTFul controller for accessing account information.
 * 
 */
@RestController
public class ProductController {

	protected Logger logger = Logger.getLogger(ProductController.class
			.getName());
	protected ProductRepository productRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param productRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;

		logger.info("ProductRepository says system has "
				+ productRepository.countProducts() + " products");
	}

	/**
	 * Fetch an account with the specified account number.
	 * 
	 * @param accountNumber
	 *            A numeric, 9 digit account number.
	 * @return The account if found.
	 * @throws AccountNotFoundException
	 *             If the number is not recognised.
	 */
	@RequestMapping("/products/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> fetchProducts() {

		
		List<Product> products = productRepository.findAll();
		

		return products;
	}
	
	@RequestMapping("/products/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathVariable("id") Long id) {

		
		Product product = productRepository.findOne(id);
		

		return product;
	}

	
}
