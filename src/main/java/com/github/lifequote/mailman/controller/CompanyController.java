package com.github.lifequote.mailman.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.lifequote.mailman.dao.CompanyDao;
import com.github.lifequote.mailman.dao.EmailListDao;
import com.github.lifequote.mailman.domain.CompanyEntity;

@Controller
@RequestMapping("/company")
public class CompanyController {
	private static final Logger logger = LoggerFactory
			.getLogger(CompanyController.class);

	@Autowired
	CompanyDao cdao;
	@Autowired
	EmailListDao edao;

	// company front page... for create, delete, update option
	@RequestMapping(method = RequestMethod.GET)
	public String companyHome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "company";
	}

	// new company sign up ..
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String createCompany(Model model) {
		CompanyEntity comp = new CompanyEntity();
		model.addAttribute("company", comp);
		return "companyCreate";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createCompany(@ModelAttribute("company") CompanyEntity comp,
			BindingResult result) {
		cdao.insertNewCompany(comp);
		edao.addToEmailList(comp.getCategory(), comp.getEmail());
		return "company";
	}

	// edit email.....

	// email management page
	@RequestMapping(value = "/{companyGuid}/emailManagement", method = RequestMethod.GET)
	public String manageEmail(@PathVariable String companyGuid, Model model) {
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		model.addAttribute("company", ce);
		return "manageEmail";
	}

	// update email--take care of email list, btw, category will not be list as
	// system based on 1-1 company category
	
	@RequestMapping(value = "/{companyGuid}/emailManagement/update", method = RequestMethod.GET)
	public String updateEmail(@PathVariable String companyGuid, @RequestParam("oldEmail") String oldEmail,
			Model model) {
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		model.addAttribute("company", ce);
		model.addAttribute("oldEmail", oldEmail);
		return "emailUpdate";
	}
	
	@RequestMapping(value = "/{companyGuid}/emailManagement/update", method = RequestMethod.POST)
	public String updateEmail(@PathVariable String companyGuid,
			@RequestParam("newEmail") String newEmail, @RequestParam("oldEmail") String oldEmail,Model model) {
		cdao.updateCompanyEmail(companyGuid, oldEmail, newEmail);
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		edao.removeFromEmailList(ce.getCategory(), oldEmail);
		edao.addToEmailList(ce.getCategory(), Arrays.asList(newEmail));
		return manageEmail(companyGuid, model);
	}

	// remove email
	@RequestMapping(value = "/{companyGuid}/emailManagement/remove/{emailToRemove}", method = RequestMethod.POST)
	public String removeEmail(@PathVariable String companyGuid,
			@PathVariable String emailToRemove, Model model) {
		cdao.removeEmail(companyGuid, emailToRemove);
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		edao.removeFromEmailList(ce.getCategory(), emailToRemove);
		return manageEmail(companyGuid, model);
	}

	// add email
	@RequestMapping(value = "/{companyGuid}/emailManagement/add/{emailToAdd}", method = RequestMethod.POST)
	public String addEmail(@PathVariable String companyGuid,
			@PathVariable String emailToAdd, Model model) {
		cdao.addCompanyEmail(companyGuid, emailToAdd);
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		edao.addToEmailList(ce.getCategory(), Arrays.asList(emailToAdd));
		return manageEmail(companyGuid, model);
	}

	// edit company regular fields....

	@RequestMapping(value = "/{companyGuid}", method = RequestMethod.GET)
	public String companyEdit(@PathVariable String companyGuid,Model model) {
		CompanyEntity ce = cdao.getByGuid(companyGuid);
		CompanyEntity ce2= new CompanyEntity();
        model.addAttribute("company", ce);
        model.addAttribute("company2", ce2);
		return "companyEdit";
	}
	
	@RequestMapping(value = "/{companyGuid}", method = RequestMethod.POST)
	public String companyEdit(@PathVariable String companyGuid,@ModelAttribute("company2") CompanyEntity comp,
			BindingResult result,Model model) {
		CompanyEntity ce = cdao.getByGuid(companyGuid);
        if(comp.getCompanyName()!=null){
        	ce.setCompanyName(comp.getCompanyName());
        }
        if(comp.getPassword()!=null){
        	ce.setPassword(comp.getPassword());
        }
        cdao.insertNewCompany(ce);
		return "companyEdit";
	}
	
}
