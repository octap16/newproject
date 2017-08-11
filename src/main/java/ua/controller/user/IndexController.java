//package ua.controller.user;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import ua.dto.filter.ItemFilter;
//import ua.service.CategoryService;
//import ua.service.ColorService;
//import ua.service.ModelService;
//import ua.service.ProducerService;
//import ua.service.SeasonService;
//import ua.service.UserService;
//@Controller
//@RequestMapping("/")
//@SessionAttributes(names = "index")
//public class IndexController {
//	
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private ColorService colorService;
//	@Autowired
//	private ModelService modelService;
//	@Autowired
//	private ProducerService producerService;
//	@Autowired
//	private SeasonService seasonService;
//	@Autowired
//	private UserService userService;
//
//
//	
//	@ModelAttribute("filter")
//	public ItemFilter getFilter() {
//		return new ItemFilter();
//	}
//	
//	@RequestMapping("/")
//	public String index(){
//		return "user-index";
//	}
//	
//	
//	@RequestMapping("/login")
//	public String login(){
//		return "user-login";
//	}
//	@RequestMapping("/cart")
//	public String cart(){
//		return "user-cart";
//	}
//
//	
//	
//	
//	
//	
//	
//	
//
//}
