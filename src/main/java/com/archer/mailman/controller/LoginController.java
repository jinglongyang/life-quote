package com.archer.mailman.controller;

import com.archer.mailman.dao.CompanyDao;
import com.archer.mailman.db.domain.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
    @Autowired
    private CompanyDao cdao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    public String loginFailure() {
        return "login-error";
    }

    @RequestMapping(value = "/vendor/{companyGuid}/emailManagement", method = RequestMethod.GET)
    public String manageEmail(@PathVariable String companyGuid, Model model) {
        CompanyEntity ce = cdao.getByGuid(companyGuid);
        model.addAttribute("company", ce);
        return "manageEmail";
    }
}
