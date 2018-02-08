package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		// convert all data to all caps
		name = name.toUpperCase();
		
		// create the message
		String result = "Yo! " + name;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String letsShoutDude(
			@RequestParam("studentName") String name, 
			Model model) {
		
		// convert all data to all caps
		name = name.toUpperCase();
		
		// create the message
		String result = "Wabalabadubdub! " + name;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
