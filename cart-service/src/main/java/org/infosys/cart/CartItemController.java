package org.infosys.cart;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * A RESTFul controller for accessing account information.
 * 
 */
@RestController
public class CartItemController {

	protected Logger logger = Logger.getLogger(CartItemController.class
			.getName());
	protected CartItemRepository cartItemRepository;

	/**
	 * Create an instance plugging in the respository of Accounts.
	 * 
	 * @param productRepository
	 *            An account repository implementation.
	 */
	@Autowired
	public CartItemController(CartItemRepository cartItemRepository) {
		this.cartItemRepository = cartItemRepository;

		logger.info("ProductRepository says system has "
				+ cartItemRepository.countProducts() + " products");
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
	@Produces(MediaType.APPLICATION_XML)
	public List<CartItem> fetchProducts() {

		
		List<CartItem> products = cartItemRepository.findAll();
		

		return products;
	}
	
	@RequestMapping("/products/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public CartItem getProduct(@PathVariable("id") Long id) {

		
		CartItem product = cartItemRepository.findOne(id);
		

		return product;
	}
	
	@RequestMapping("/addItem")
	@Produces(MediaType.APPLICATION_XML)
	public CartItem addItem() {

		
		
		CartItem cartItem = new CartItem();
		cartItem.setProductName("phone");
		cartItem.setUserName("john");
		cartItem.setPrice(new BigDecimal("100.00"));
		cartItem=cartItemRepository.saveAndFlush(cartItem);
		
		return cartItem;
	}
	
	@RequestMapping("/addItemNew")
	@POST	
	public CartItem addCartItem(@RequestBody CartItem cartItem) {
		
		
		cartItem=cartItemRepository.saveAndFlush(cartItem);
		System.out.println("item added");
		return cartItem;
	}
	
	@RequestMapping("/cart")
	@Produces(MediaType.APPLICATION_XML)
	public List<CartItem> getCart(@QueryParam("userName") String userName) {	
		
		
		List<CartItem> cartItems=cartItemRepository.findByUserName(userName);
		
		return cartItems;
	}
	
	@RequestMapping("/removeItem")
	@Produces(MediaType.APPLICATION_XML)
	public String removeItem(@QueryParam("cartItemId") String cartItemId) {	
		
		
		
		cartItemRepository.delete(new Long(cartItemId));
		return "success";
	}
	
	

	
}
