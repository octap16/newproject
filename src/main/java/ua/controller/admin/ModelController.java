package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.BasicFilter;
//import ua.editor.ContentEditor;
//import ua.entity.Content;
import ua.entity.Model;
//import ua.service.ContentService;
import ua.service.ModelService;
import ua.validator.ModelValidator;

@Controller

@RequestMapping("/admin/model")
@SessionAttributes(names="model")
public class ModelController {
	@Autowired
	private ModelService modelService;
	
//	@Autowired
//	private ContentService contentService;

	@ModelAttribute("model")
	public Model getForm(){
		return new Model();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("model")
	protected void initBinder(WebDataBinder binder) {
//		 binder.registerCustomEditor(Content.class, new ContentEditor(contentService));
		binder.setValidator(new ModelValidator(modelService));
				   
	}
	
	@RequestMapping
	public String show(org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		
		model.addAttribute("page", modelService.findAll(filter, pageable));
//		model.addAttribute("contents", contentService.findAll());
		return "admin-model";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		modelService.delete(id);
		return "redirect:/admin/model"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("model", modelService.findOne(id));
		model.addAttribute("page", modelService.findAll(filter, pageable));
//		model.addAttribute("page", contentService.findAll( pageable));
		return "admin-model";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("model") @Valid Model uaModel, BindingResult br, SessionStatus status, org.springframework.ui.Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			show(model, pageable, filter);
			return "admin-model";
		}
		modelService.save(uaModel);
		status.setComplete();
		return "redirect:/admin/model"+getParams(pageable, filter);
	}
}
