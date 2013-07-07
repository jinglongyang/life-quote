package com.archer.mailman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.archer.mailman.dto.Contact;

@Controller
@SessionAttributes
@RequestMapping("/contact")
public class ContactController {
	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public String goToContactPage(ModelMap model){
		Contact c=new Contact();
		model.addAttribute("contact", c);
		return "companyCreate";
	}
	
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		System.out.println("First Name:" + contact.getFirstname()
				+ "Last Name:" + contact.getLastname());

		return "home";
	}

	@RequestMapping("/contacts")
	public ModelAndView showContacts() {

		return new ModelAndView("contact", "command", new Contact());
	}
}
