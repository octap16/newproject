package ua.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.dto.filter.ItemFilter;
import ua.service.CategoryService;
import ua.service.ColorService;

import ua.service.ModelService;
import ua.service.ProducerService;
import ua.service.SeasonService;
import ua.service.UserService;

@Controller
@SessionAttributes(names = "info")
public class InfoConcroller {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private SeasonService seasonService;
	@Autowired
	private UserService userService;
	@Autowired
	
	
	@ModelAttribute("filter")
	public ItemFilter getFilter() {
		return new ItemFilter();
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String ordernow( ) {
		return "user-info";
	}

}
