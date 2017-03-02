package org.infosys.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for Account data implemented using Spring Data JPA.
 * 

 */

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT count(*) from Product")
	public int countProducts();

	
}
