package ua.controller.user;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.User;
import ua.resetpasword.Sender;

@Controller
public class ResetController {
	@Autowired
	private Sender sender;
	
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String reset() {
	sender.send("jykhkjhk", "jhkjhkjkj", "vdovychynostap@gmail.com");
		return "redirect:/" ;
	}
}
