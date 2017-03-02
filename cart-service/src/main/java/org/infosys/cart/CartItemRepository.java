package org.infosys.cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 

 */

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	
	@Query("SELECT count(*) from CartItem")
	public int countProducts();
	
	public List<CartItem> findByUserName(String userName);

	
}
