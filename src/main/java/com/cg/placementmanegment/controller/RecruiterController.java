package com.cg.placementmanegment.controller;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.placementmanegment.exception.RecruiterNotFoundException;
import com.cg.placementmanegment.model.Admin;
import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.model.Recruiter;
import com.cg.placementmanegment.service.JobSeekerService;
import com.cg.placementmanegment.service.RecruiterService;



@Controller
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;
	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/recruiterindex")
	public String showRecruiterIndexPage() {
		return "recruiterindex";
	}

	public ModelAndView mainpage() {
		ModelAndView mav = new ModelAndView("recruiterlogin");
		mav.addObject("recruiter", new Admin());
		return mav;
	}

	@GetMapping("/recruitersignup")
	public String showRecruiterSignUpPage(Model model) {
		System.out.println("Recruiter SignUp Page");

		model.addAttribute("recruiter", new Recruiter());
		return "recruitersignup";
	}

	@PostMapping("/registerrecruiter")
	public String addAdmin(@Validated Recruiter recruiter, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "recruitersignup";
		}

		recruiterService.addRecruiter(recruiter);
		return "recruiterlogin";
	}

	@RequestMapping(path = "/recruiterlogin", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("recruiterlogin");
		mav.addObject("recruiter", new Recruiter());
		return mav;
	}

	@PostMapping("/recruiterlogin")
	public String loginRecruiter(HttpServletRequest request,Recruiter recruiter,Model model) {
        
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Recruiter recruiternew;
		try
		{
		      recruiternew = recruiterService.loginRecruiter(username,password);
		}
		catch(RecruiterNotFoundException ex){
		//System.out.print(recruiternew.getRecruiterid());
			model.addAttribute("errormessage",ex.getMessage());
			return "recruiterlogin";
	
		}
		model.addAttribute("recruiterid",recruiternew.getRecruiterid());
		
		System.out.print(recruiternew);
		if (Objects.nonNull(recruiternew)) {
			List<JobSeeker> listjobseeker = jobSeekerService.listAll();
			model.addAttribute("listjobseeker", listjobseeker);

			return "recruiterhomepage";

		} else {
			return "recruiterlogin";

		}

	}

	@GetMapping("/recruiterhomepage")
	public String viewRecruiterHomePage(Model model) {
		List<JobSeeker> listjobseeker = jobSeekerService.listAll();

		model.addAttribute("listjobseeker", listjobseeker);
		System.out.print("Get / ");
		return "recruiterhomepage";
	}

	@RequestMapping(value = "/savejobseeker", method = RequestMethod.POST)
	public String showJobSeeker(@ModelAttribute("jobseeker") JobSeeker jobseeker) {
		jobSeekerService.save(jobseeker);
		return "redirect:recruiterhomepage";
	}
	@GetMapping("/verify/{id}")
	public String viewVerifyPage(@PathVariable("id") String id, Model model) {
		
		System.out.println("Path Varaible values are:----" + id);
		String[] ids = id.split(" ");

		Long recruiterId = Long.parseLong(ids[0]);
		Integer jobseekerId = Integer.parseInt(ids[1]);
		System.out.println("job verification");
		
		JobSeeker jobSeeker= recruiterService.verifyJobSeeker(recruiterId, jobseekerId);
		model.addAttribute("message",jobSeeker.getInterview_status());
		//System.out.println("+++++++++++++++"+jobSeeker);
		return "resultpage";

	}
	

	@RequestMapping(value = { "/logoutrecruiter" }, method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/";
	}

}
