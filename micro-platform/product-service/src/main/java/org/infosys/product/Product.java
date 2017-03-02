package org.infosys.product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent account entity with JPA markup. Accounts are stored in an H2
 * relational database.
 * 
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

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



	public void setId(Long id) {
		this.id = id;
	}



	@Id
	protected Long id;

	

	@Column(name = "description")
	protected String description;

	@Column(name = "price")
	protected BigDecimal price;

	

	/**
	 * Default constructor for JPA only.
	 */
	protected Product() {
		
	}

	

	public long getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(long id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return description + ": $" + price;
	}

}
