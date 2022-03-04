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

import com.cg.placementmanegment.exception.JobSeekerNotFoundException;
import com.cg.placementmanegment.model.AppliedJob;
import com.cg.placementmanegment.model.Company;
import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.service.AppliedJobService;
import com.cg.placementmanegment.service.CompanyService;
import com.cg.placementmanegment.service.JobSeekerService;



@Controller
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AppliedJobService appliedJobService;

	@GetMapping("/jobseekerindex")
	public String showIndexPage() {
		return "jobseekerindex";
	}

	public ModelAndView mainpage() {
		ModelAndView mav = new ModelAndView("jobseekerlogin");
		mav.addObject("jobseeker", new JobSeeker());
		return mav;
	}

	@GetMapping("/jobseekersignup")
	public String showSignUp(Model model) {
		System.out.println("SignUp Page");

		model.addAttribute("jobseeker", new JobSeeker());
		return "jobseekersignup";
	}

	@PostMapping("/registerjobseeker")
	public String addJobSeeker(@Validated JobSeeker jobseeker, Model model) {
		/*
		 * if (result.hasErrors()) { return "jobseekersignup";
		 */
		//}

		jobSeekerService.addJobseeker(jobseeker);
		return "jobseekerindex";
	}

	@RequestMapping(path = "/jobseekerlogin", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("jobseekerlogin");
		System.out.println("********************");
		mav.addObject("jobseeker", new JobSeeker());
		return mav;
	}

	@GetMapping("/jobseekerdetails")
	public String viewHomePage(Model model) {
		List<JobSeeker> listjobseeker = jobSeekerService.listAll();
		model.addAttribute("listjobseeker", listjobseeker);
		System.out.print("Get / ");
		return "jobseekerdetails";
	}

	@PostMapping("/jobseekerlogin")
	public String login(@ModelAttribute("jobseeker") JobSeeker jobSeeker, Model model) {
		JobSeeker oauthUser;
		try
		{
		 oauthUser = jobSeekerService.loginJobSeeker(jobSeeker.getUsername(), jobSeeker.getPassword());
		}
		catch(JobSeekerNotFoundException ex) {
			System.out.println(ex.getMessage());
			model.addAttribute("errormessage",ex.getMessage());
			return "jobseekerlogin";
		}
		
		model.addAttribute("jobseekerid", oauthUser.getUserid());
		   	System.out.println("Authenticated UserId" + oauthUser.getUserid());
		if (Objects.nonNull(oauthUser)) {
			List<Company> listplacement = companyService.listAll();
			model.addAttribute("listplacement", listplacement);

			return "jobseekerhome";

		} else {
			return "jobseekerlogin";

		}
	}

	@GetMapping("/jobseekerhome")
	public String viewJobSeekerHomePage(Model model) {
		List<Company> listplacement = companyService.listAll();
		model.addAttribute("listplacement", listplacement);
		System.out.print("Get / ");
		return "jobseekerhome";
	}

	@RequestMapping(value = "/saveplacement", method = RequestMethod.POST)
	public String showPlacement(@ModelAttribute("placement") Company plc) {
		companyService.save(plc);
		return "redirect:jobseekerhome";
	}

	@RequestMapping(value = "/apply/{id}", method = RequestMethod.GET)
	public String showAppliedJob(@PathVariable("id") String id, Model model) {

		System.out.println("Path Varaible values are:----" + id);
		String[] ids = id.split(" ");

		Long comId = Long.parseLong(ids[0]);
		Integer jobseekerId = Integer.parseInt(ids[1]);

		Company company = companyService.get(comId);
		JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(jobseekerId).get();
		AppliedJob appliedJob = new AppliedJob();
		appliedJob.setCompanyname(company.getCompanyname());
		appliedJob.setCompanyemail(company.getCompanyemail());
		appliedJob.setCompanylocation(company.getCompanylocation());
		appliedJob.setPosteddate(company.getPosteddate());
		appliedJob.setRole(company.getRole());
		appliedJob.setQualification_required(company.getQualification_required());
		appliedJob.setSkills(company.getSkills());
		appliedJob.setCompany(company);
		appliedJob.setJobSeeker(jobSeeker);

		// System.out.println(appliedJob);
		appliedJobService.save(appliedJob);

		model.addAttribute("appliedjoblist", appliedJobService.findByJobSeekerId(jobseekerId));
		System.out.println("In AppliedController");
		return "jobappliedhomepage";
	}

	@RequestMapping(value = { "/logoutjobseeker" }, method = RequestMethod.POST)
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/jobseekerlogin";
	}


}