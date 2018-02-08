package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create new Student object
		Student student = new Student();
		
		// add student object to the model
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		// log the input data
		System.out.println("student: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("country: " + student.getCountry());
		System.out.println("favorite language: " + student.getFavoriteLanguage());
		
		return "student-confirmation";
	}
	
}
