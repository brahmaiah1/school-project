package com.school.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.pojo.Contact;
import com.school.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping(value="/contact",method = RequestMethod.GET)
	public String getStudentDetails(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
		
	}
	
	
	
	/*
	 * @RequestMapping(value = "/saveContact", method = RequestMethod.POST) public
	 * String saveContactDetails(@RequestParam String name, @RequestParam String
	 * mobileNum,
	 * 
	 * @RequestParam String email, @RequestParam String subject, @RequestParam
	 * String message) {
	 * 
	 * System.out.println("name" + name); System.out.println("mobileNum" +
	 * mobileNum); System.out.println("email" + email); System.out.println("subject"
	 * + subject); System.out.println("message" + message);
	 * 
	 * return "redirect:/contact";
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContactDetails(@Valid @ModelAttribute("contact")Contact contact,Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("error"+errors.toString());
			return "redirect:/contact";
		}
		contactService.saveContactDetails(contact);
		
		return "redirect:/contact";
	}
	 
	
	
	

}
