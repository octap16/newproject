//package ua.controller.admin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import ua.dto.filter.ItemFilter;
//import ua.repository.UserRepository;
//import ua.service.UserService;
//@Controller
//
//@RequestMapping("/admin/cartcontroller")
//@SessionAttributes(names="cartcontroller")
//public class CartAdminController {
//	@Autowired
//	private UserRepository userRepository;
//	@Autowired
//	private UserService userService;
//	
//	
//	@RequestMapping
//	public String show( Model model) {
//		model.addAttribute("users", userService.findByCart());
//		return "admin-cartcontroller";
//	}
//	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//	public String deleteItems(@PathVariable(value = "id") int id) {
//		userService.deleteUserCart(id);
//		return "redirect:/admin/cartcontroller";
//	}
//	@ModelAttribute("filter")
//	public ItemFilter getFilter() {
//		return new ItemFilter();
//	}
//
//}
