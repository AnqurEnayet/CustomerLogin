package com.luv2code.springdemo.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// injecting customer service
	@Autowired
	private CustomerService customerService;
	

	
	@GetMapping("/login")
	public String login(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "login";
	}
	
	@RequestMapping("/verifyCustomer")
	public String verifyCustomer(Model theModel,
			@RequestParam("email")String email,
			@RequestParam("password")String password) {
		
		if (isValid(email)) {
			//System.out.println("****");
			int id = customerService.verifyCustomer(email,password);
			//System.out.println("****");
			if(id==-1)
			{
				//System.out.println("##**");
				return "forward:/customer/Error";
			}
			else
			{
				//System.out.println("#####");
				return "forward:/customer/Successful";
			}
		}
		
		else return "forward:/customer/Error";

	}
	
	@RequestMapping("/Successful")
	public String successful(Model theModel) {
		return "/Successful";
	}
	
	@RequestMapping("/Error")
	public String error(Model theModel) {
		return "/Error";
	}
	
	 public static boolean isValid(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
	    }
}










