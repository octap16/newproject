package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;






import ua.validator.SeasonValidator;
import ua.dto.filter.BasicFilter;
import ua.entity.Season;
import ua.service.SeasonService;

@Controller

@RequestMapping("/admin/season")
@SessionAttributes(names="season")
public class SeasonController {
	@Autowired
	private SeasonService seasonService;
	
	@ModelAttribute("season")
	public Season getForm(){
		return new Season();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("season")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new SeasonValidator(seasonService));
	}
	
	@RequestMapping
	public String show( Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", seasonService.findAll(filter, pageable));
		return "admin-season";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		seasonService.delete(id);
		return "redirect:/admin/season"+getParams(pageable, filter);
	}
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("season",seasonService.findOne(id));
		model.addAttribute("page", seasonService.findAll(filter, pageable));
		return "admin-season";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("season") @Valid Season season, BindingResult br, SessionStatus status, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", seasonService.findAll(filter, pageable));
			return "admin-season";
		}
		seasonService.save(season);
		status.setComplete();
		return "redirect:/admin/season"+getParams(pageable, filter);
	}
}