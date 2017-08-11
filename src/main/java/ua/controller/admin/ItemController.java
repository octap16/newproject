//package ua.controller.admin;
//
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//
//
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import ua.dto.filter.ItemFilter;
//import ua.dto.form.ItemForm;
//import ua.editor.CategoryEditor;
//import ua.editor.ColorEditor;
//import ua.editor.ModelEditor;
//import ua.editor.ProducerEditor;
//import ua.editor.SeasonEditor;
//import ua.entity.Category;
//import ua.entity.Color;
//import ua.entity.Producer;
//import ua.entity.Season;
//import ua.service.CategoryService;
//import ua.service.ColorService;
//import ua.service.ItemService;
//import ua.service.ModelService;
//import ua.service.ProducerService;
//import ua.service.SeasonService;
//import ua.validator.ItemValidator;
//
//
//
//@Controller
//@RequestMapping("/admin/item")
//@SessionAttributes(names="item")
//public class ItemController {
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
//	private ItemService itemService;
//	
//	@InitBinder("item")
//	protected void initBinder(WebDataBinder binder){
//		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
//		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
//		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
//		binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
//		binder.registerCustomEditor(Season.class, new SeasonEditor(seasonService));
//		binder.setValidator(new ItemValidator());
//	}
//	
//	@ModelAttribute("item")
//	public ItemForm getForm(){
//		return new ItemForm();
//	}
//	
//	@ModelAttribute("filter")
//	public ItemFilter getFilter(){
//		return new ItemFilter();
//	}
//
//	@RequestMapping("/delete/{id}")
//	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
//		itemService.delete(id);
//		return "redirect:/admin/item"+getParams(pageable, filter);
//	}
//
//	@RequestMapping
//	public String show(org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
//		model.addAttribute("page", itemService.findAll(filter, pageable));
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("colors", colorService.findAll());
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("seasons", seasonService.findAll());
//		
//		return "admin-item";
//	}
//	
//	@RequestMapping("/update/{id}")
//	public String update(@PathVariable int id, org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
//		model.addAttribute("item", itemService.findForm(id));
//		
//		show(model, pageable, filter);
//		return "admin-item";
//	}
//	
//	@RequestMapping(method=POST)
//	public String save(@ModelAttribute("item") @Valid ItemForm item, BindingResult br, org.springframework.ui.Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter){
//		if(br.hasErrors()){
//			show(model, pageable, filter);
//			return "admin-item";
//		}
//		itemService.save(item);
//		status.setComplete();
//		return "redirect:/admin/item"+getParams(pageable, filter);
//	}
//	
//	private String getParams(Pageable pageable, ItemFilter filter){
//		StringBuilder buffer = new StringBuilder();
//		buffer.append("?page=");
//		buffer.append(String.valueOf(pageable.getPageNumber()+1));
//		buffer.append("&size=");
//		buffer.append(String.valueOf(pageable.getPageSize()));
//		if(pageable.getSort()!=null){
//			buffer.append("&sort=");
//			Sort sort = pageable.getSort();
//			sort.forEach((order)->{
//				buffer.append(order.getProperty());
//				if(order.getDirection()!=Direction.ASC)
//				buffer.append(",desc");
//			});
//		}
//		if(!filter.getMaxPrice().isEmpty()){
//			buffer.append("&maxPrice=");
//			buffer.append(filter.getMaxPrice());
//		}
//		if(!filter.getMinPrice().isEmpty()){
//			buffer.append("&minPrice=");
//			buffer.append(filter.getMinPrice());
//		}
//		if(!filter.getMaxSize().isEmpty()){
//			buffer.append("&maxSize=");
//			buffer.append(filter.getMaxSize());
//		}
//		if(!filter.getMinSize().isEmpty()){
//			buffer.append("&minSizee=");
//			buffer.append(filter.getMinSize());
//		}
//		for(Integer id : filter.getProducerIds()){
//			buffer.append("&producerIds=");
//			buffer.append(id);
//		}
//		for(Integer id : filter.getColorIds()){
//			buffer.append("&colorIds=");
//			buffer.append(id);
//		}
//		for(Integer id : filter.getSeasonIds()){
//			buffer.append("&seasonIds=");
//			buffer.append(id);
//		}
//		for(Integer id : filter.getCategoryIds()){
//			buffer.append("&categoryIds=");
//			buffer.append(id);
//		}
//		for(Integer id : filter.getModelIds()){
//			buffer.append("&modelIds=");
//			buffer.append(id);
//		}
//			
//		return buffer.toString();
//	}
//}
