package ua.service.implementation;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.entity.ShoppingCart;
import ua.entity.User;
import ua.repository.ItemRepository;
import ua.repository.ShoppingCartRepository;
import ua.repository.UserRepository;
import ua.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Autowired
	private  ShoppingCartRepository shoppingCartrepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private UserRepository userRepository;
		
	@Override
	@Transactional (readOnly=true)
	public ShoppingCart findOne(int id) {
		
		return shoppingCartrepository.findOne(id);
	}

	@Override
	@Transactional (readOnly=true)
	public List<ShoppingCart> findAll() {
		
		return shoppingCartrepository.findAll();
	}

	@Override
	public void delete(int id) {
		shoppingCartrepository.delete(id);
		
	}

	@Override
	public void addToCard( int id, ShoppingCart shoppingCart) {
		Item item = itemRepository.findOne(id);
		User user = userRepository.findOne(id);
		shoppingCart.setItem(item);
		shoppingCart.setUser(user);
		shoppingCart.setQuantity(1);
		shoppingCartrepository.save(shoppingCart);
	}

	
	
	

}
