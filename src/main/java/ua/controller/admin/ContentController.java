//package ua.controller.admin;
//
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
//import static ua.service.utils.ParamBuilder.getParams;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//import ua.dto.filter.BasicFilter;
//import ua.entity.Content;
//import ua.service.ContentService;
//
//
//@Controller
//@RequestMapping("/admin/content")
//@SessionAttributes(names = "content")
//public class ContentController {
//
//	@Autowired
//	private ContentService contentService;
//
//	@ModelAttribute("content")
//	public Content getForm() {
//		return new Content();
//	}
//
////	@ModelAttribute("content")
////	public BasicFilter getFilter() {
////		return new BasicFilter();
////	}
////
////	@InitBinder("content")
////	protected void initBinder(WebDataBinder binder) {
////		binder.setValidator(new ContentValidator(contentService));
////	}
//
//	@RequestMapping
//	public String show( Model model,
//			@PageableDefault Pageable pageable) {
//	
//		model.addAttribute("page", contentService.findAll( pageable));
//		
//		return "admin-content";
//	}
//
//	@RequestMapping("/delete/{id}")
//	public String delete(@PathVariable int id,
//			@PageableDefault Pageable pageable
//			) {
//		contentService.delete(id);
//		return "redirect:/admin/content" ;
//	}
//
//	@RequestMapping("/update/{id}")
//	public String update(@PathVariable int id, Model model,
//			@PageableDefault Pageable pageable
//			) {
//	
//		model.addAttribute("content", contentService.findOne(id));
//		model.addAttribute("page", contentService.findAll( pageable));
//		return "admin-content";
//	}
//
//	@RequestMapping(method = POST)
//	public String save(@ModelAttribute("content") @Valid Content content,
//			BindingResult br, SessionStatus status, Model model,
//			@PageableDefault Pageable pageable
//			) {
//		if (br.hasErrors()) {
//			model.addAttribute("page", contentService.findAll( pageable));
//			return "admin-content";
//		}
//		contentService.save(content);
//		status.setComplete();
//		return "redirect:/admin/content" ;
//	}
//	
//}
