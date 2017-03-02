package org.infosys.cart;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent account entity with JPA markup. Accounts are stored in an H2
 * relational database.
 * 
 */
@Entity
@Table(name = "CART_ITEMS")
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;
	

	@Id
	@GeneratedValue
	@Column(name = "CART_ITEM_ID")
	protected Long id;
	
	@Column(name = "PRICE")
	protected BigDecimal price;
	
	@Column(name = "USER_NAME")
	protected String userName;
	
	@Column(name = "PRODUCT_NAME")
	protected String productName;	

	/**
	 * Default constructor for JPA only.
	 */
	protected CartItem() {
		
	}

	public static Long getNextId() {
		return nextId;
	}

	public static void setNextId(Long nextId) {
		CartItem.nextId = nextId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


}
