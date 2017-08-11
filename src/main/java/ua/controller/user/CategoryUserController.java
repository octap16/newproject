//package ua.controller.user;
//
//
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//
//
//import ua.dto.filter.ItemFilter;
//import ua.service.CategoryService;
//import ua.service.ColorService;
//import ua.service.ItemService;
//import ua.service.ModelService;
//import ua.service.ProducerService;
//import ua.service.SeasonService;
//import ua.service.UserService;
//
//
//@Controller
//@RequestMapping("/filters")
//@SessionAttributes(names = "filters")
//public class CategoryUserController {
//	
//	
//
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
//	@Autowired
//	private ItemService itemService;
//	
//	@ModelAttribute("filter")
//	public ItemFilter getFilter() {
//		return new ItemFilter();
//	}
//	
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public String show(@PathVariable(value = "id") int id ,org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
//		filter.getCategoryIds().add(id);
//		model.addAttribute("page", itemService.findAll(filter, pageable));
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("colors", colorService.findAll());
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("seasons", seasonService.findAll());
//		return "user-filters";
//	}
//	
//	@RequestMapping
//	public String show(org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
//		
//		model.addAttribute("page", itemService.findAll(filter, pageable));
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("colors", colorService.findAll());
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("seasons", seasonService.findAll());
//		return "user-filters";
//	}
//	
//	@RequestMapping(value = "/ordernow/{id}", method = RequestMethod.GET)
//	public String ordernow(@PathVariable(value = "id") int id, Principal principal) {
//		userService.addItem(id, principal);
//		System.out.println("gello");
//		return "redirect:/filters";
//
//	}
//	@RequestMapping("/search")
//	public String search(org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
//		model.addAttribute("page", itemService.findAllSearch(pageable, filter));
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("colors", colorService.findAll());
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("seasons", seasonService.findAll());
//		return "user-filters";
//	}
//	
//
//}
