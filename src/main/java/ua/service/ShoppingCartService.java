package ua.service;

import java.util.List;


import ua.entity.ShoppingCart;

public interface ShoppingCartService {
	
	ShoppingCart findOne(int id);
	 
	 List<ShoppingCart> findAll();
	 	 
	 void delete(int id);
	 
	 void addToCard( int id, ShoppingCart shoppingCart);

}
