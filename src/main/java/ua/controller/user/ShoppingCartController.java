package ua.controller.user;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;




import ua.dto.filter.ItemFilter;
import ua.repository.UserRepository;

import ua.service.UserService;

@Controller
@RequestMapping("/")

public class ShoppingCartController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;	


	
	@ModelAttribute("filter")
	public ItemFilter getFilter() {
		return new ItemFilter();
	}
	
	
	@RequestMapping()
	public String show() {	
//	    model.addAttribute("carts",userService.findByUsername(principal.getName()));  
		return "user-shoppingcart";
	}
	
	

}
