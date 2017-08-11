package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ua.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>, JpaSpecificationExecutor<ShoppingCart>{
	
	@Query("SELECT p FROM ShoppingCart p LEFT JOIN FETCH p.item LEFT JOIN FETCH p.user" )
	List<ShoppingCart> findAll();
	@Query("SELECT p FROM ShoppingCart p LEFT JOIN FETCH p.item LEFT JOIN FETCH p.user WHERE p.id=:id")
	ShoppingCart findOne(@Param("id")int id);
	@Query("SELECT p FROM ShoppingCart p LEFT JOIN FETCH p.item  WHERE p.id=:id")
	ShoppingCart loadedItem(@Param("id")int id);
	@Query("SELECT p FROM ShoppingCart p LEFT JOIN FETCH p.user  WHERE p.id=:id")
	ShoppingCart loadedUser(@Param("id")int id);
}
