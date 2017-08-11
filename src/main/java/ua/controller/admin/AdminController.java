package ua.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dto.filter.ItemFilter;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	@ModelAttribute("filter")
	public ItemFilter getFilter() {
		return new ItemFilter();
	}
}
