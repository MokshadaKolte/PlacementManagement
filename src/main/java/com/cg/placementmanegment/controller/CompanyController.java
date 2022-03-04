package com.cg.placementmanegment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanegment.model.Company;
import com.cg.placementmanegment.service.CompanyService;


@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/placementindex")
	public String viewHomePage(Model model) {
		List<Company> listcompany = companyService.listAll();
		model.addAttribute("listcompany", listcompany);
		System.out.print("Get / ");
		return "placementindex";
	}

	@GetMapping("/placementnew")
	public String add(Model model) {
		model.addAttribute("company", new Company());
		return "placementnew";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCompany(@ModelAttribute("company") Company company) {
		companyService.save(company);
		return "redirect:placementindex";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCompanyPage(@PathVariable(name = "id") long id) {
		ModelAndView modelAndView = new ModelAndView("placementnew");
		Company company = companyService.get(id);
		modelAndView.addObject("company", company);
		return modelAndView;

	}

	@RequestMapping("/delete/{id}")
	public String deleteCompany(@PathVariable(name = "id") long id) {
		companyService.delete(id);
		return "redirect:/placementindex";
	}

}
