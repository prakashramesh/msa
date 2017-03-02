package org.infosys.online.web;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import groovy.lang.Grab;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebAccountsService}.
 * 
 * 
 */
@Controller
public class OnlineController {	
	

	@Autowired
	protected OnlineService onlineService;

	protected Logger logger = Logger.getLogger(OnlineController.class
			.getName());
	
	
	@RequestMapping("/browse")
	public String findAllProducts(Model model) {	

		List<Product> products = onlineService.findAllProducts();
		
		//String user = SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		model.addAttribute("products", products);
		return "products";
	}	
	
	@RequestMapping("/viewCart")
	public String findAllCartItems(Model model) {	

		List<CartItem> cartItems = onlineService.findCartItems();
		
		//String user = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if(cartItems.size() > 0){
			model.addAttribute("cartItems", cartItems);
		}
		return "cartitems";
	}	
	
	@RequestMapping("/addItem")
	@ResponseBody
	public CartItem addItem(@QueryParam("productId") String productId) {	

		CartItem cartItem= onlineService.addItem(productId);
		
		//String user = SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		//model.addAttribute("cartItem", cartItem);
		return cartItem;
	}
	
	@RequestMapping("/removeItem")
	@ResponseBody
	public String removeItem(@QueryParam("cartItemId") String cartItemId) {	

		String response =  onlineService.removeItem(cartItemId);		
		
		return response;
	}

	
}
