//package ua.controller.user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//
//import ua.service.UserService;
//import ua.validator.UserValidator;
//
//@Controller
//
//public class LoginController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@InitBinder("user")
//	protected void initBinder(WebDataBinder binder) {
//		binder.setValidator(new UserValidator(userService));
//	}
//	@RequestMapping
//	public String login() {
//		return "user-index";
//	}
//}
