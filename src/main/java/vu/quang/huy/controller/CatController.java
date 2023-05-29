package vu.quang.huy.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import vu.quang.huy.models.Cat;
import vu.quang.huy.services.BreadService;
import vu.quang.huy.services.CatService;

@Controller
@RequestMapping("/cat")
public class CatController {
	@Autowired
	CatService catService;
	@Autowired
	BreadService breadService;
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/Images/";

	@GetMapping({ "list", "" })
	public ModelAndView listCat() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("cats", catService.findAll());
		andView.setViewName("list_Cat");
		return andView;
	}

	@GetMapping("/showAddCatForm")
	public ModelAndView showAddCatform() {
		ModelAndView model = new ModelAndView();
		model.addObject("cat", new Cat());
		model.addObject("breads", breadService.findAll());
		model.setViewName("AddCatForm");
		return model;
	}

	@GetMapping("/delete")
	public ModelAndView deleteCat(int id) {
		ModelAndView model = new ModelAndView();
		catService.deleteCat(id);
		
		model.setViewName("redirect:/cat");
		return model;
	}

	@PostMapping("/saveCat")
	public ModelAndView saveCat(@RequestParam("catIMG") MultipartFile file, @ModelAttribute Cat cat) throws Exception {
		String fileName = file.getOriginalFilename();
		if (!fileName.equals("")) {
			// write file uploadDir
			cat.setCat_Image(fileName);
			String filePath = uploadDir + fileName;
			file.transferTo(new File(filePath));

		}

		ModelAndView andView = new ModelAndView();
		andView.setViewName("redirect:/cat/list");
		catService.saveCat(cat);
		return andView;
	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		Cat cat = catService.findCatById(id).get();
		modelAndView.addObject("cat", cat);
		modelAndView.addObject("breads", breadService.findAll());
		modelAndView.setViewName("AddCatForm");
		return modelAndView;

	}

	@GetMapping("/search")
	public ModelAndView searchCats(HttpServletRequest request) {
		String keyword = request.getParameter("search");
		System.err.println(keyword);
		ModelAndView andView = new ModelAndView();
		andView.setViewName("list_Cat");
		andView.addObject("cats", catService.findByNameCat(keyword));

		return andView;
	}

}
