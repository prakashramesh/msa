package org.infosys.online.web;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebAccountsService}.
 * 
 *
 */
@JsonRootName("Product")
public class Product {

	protected Long id;
	protected String description;

	protected BigDecimal price;

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	

	
}
