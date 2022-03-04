package com.cg.placementmanegment.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.cg.placementmanegment.exception.AdminNotFoundException;
import com.cg.placementmanegment.model.Admin;
import com.cg.placementmanegment.service.AdminService;


@Controller
public class AdminController {
	
	@Autowired
    private AdminService adminService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/admin")
	public String showIndexPage()
	{
		return "index";
	}

    @RequestMapping(path = "/adminindex", method = RequestMethod.GET)
    public String adminindex() {
        return "adminindex"; //defect-details.html page name to open it
    }
    public ModelAndView mainpage() {
    	ModelAndView mav = new ModelAndView("adminlogin");
        mav.addObject("admin", new Admin());
        return mav;
    }
    /*@GetMapping("/sign-up")
	public String showSignUpPage(Model model)
	{
		System.out.println("SignUp Page");
		
		model.addAttribute("admin",new Admin());
		return "sign-up";
}

	@PostMapping("/register")
	public String addAdmin(@Validated Admin admin, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        return "sign-up";
	    }

	    adminService.addAdmin(admin);
	    return "adminlogin";
	}*/
	
                         
    @RequestMapping(path = "/adminlogin", method = RequestMethod.GET)
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("adminlogin");
        mav.addObject("admin", new Admin());
        return mav;
    }

    @PostMapping("/adminlogin")
    public String login(@ModelAttribute("admin") Admin admin,Model model ) {
    	Admin oauthUser;
    	try
    	{
    	oauthUser = adminService.login(admin.getUsername(), admin.getPassword());
    	
    	}
    	catch(AdminNotFoundException ex)
    	{
    		model.addAttribute("errormessage",ex.getMessage());
			return "adminlogin";

    	}
    		if(Objects.nonNull(oauthUser)) 
    	{	
            
    		return "redirect:/adminindex";
    	
    		
    	} else {
    		return "redirect:/adminlogin";
    		
    	
    	}

}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    	
	  
        return "redirect:/";
    }
   
}