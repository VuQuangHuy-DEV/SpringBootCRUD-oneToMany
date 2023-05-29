package vu.quang.huy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import vu.quang.huy.Repositories.BreadRepository;
import vu.quang.huy.models.Bread;
import vu.quang.huy.services.BreadService;

@Controller
@RequestMapping("/bread")

public class BreadController {
	@Autowired
	private BreadService breadService;
	
	@GetMapping({ "/list", "" })
	public ModelAndView showAllBread() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("breads", breadService.findAll());
		modelAndView.setViewName("list_bread");
		return modelAndView;
	}
	@PostMapping("saveBread")
	public ModelAndView saveBread(@ModelAttribute Bread bread) {
		ModelAndView modelAndView = new ModelAndView();
		breadService.saveBread(bread);
	    modelAndView.setViewName("redirect:/bread");
	    return modelAndView;
	}
	
	@GetMapping("showAddBreadForm")
	public ModelAndView showAddBreadForm() {
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("bread",new Bread());
		modelAndView.setViewName("AddBreadForm");
		return modelAndView;
	}
@GetMapping("/delete")
public ModelAndView deleteBread( int id) {
	ModelAndView modelAndView= new ModelAndView();
	breadService.deleteBread(id);

	modelAndView.setViewName("redirect:/bread");
	return modelAndView;
	
	
}
@GetMapping("showUpdateBreadForm")
public ModelAndView showUpdateForm(int id) {
	ModelAndView modelAndView= new ModelAndView();
	modelAndView.addObject("bread",breadService.findBreadById(id));
	modelAndView.setViewName("AddBreadForm");
	return modelAndView;
}

}
