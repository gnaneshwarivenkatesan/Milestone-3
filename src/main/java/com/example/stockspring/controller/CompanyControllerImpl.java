package com.example.stockspring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.CompanyServiceImpl;

@Controller
public class CompanyControllerImpl {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(path = "/companyList")
	public ModelAndView getCompanyList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("companyList");
		mv.addObject("companyList", companyService.getCompanyList());
		return mv;
	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add employee");
		Company e = new Company();
		// e.setEmail("sdfsf");
		// e.setSalary(4564.56f);
		model.addAttribute("e1", e);
		return "insert";

	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String formHandler(@Valid Company company, 
			BindingResult result, Model model) throws SQLException {
		System.out.println(company);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("e1", company);
			return "insert";
		}
		
		
		companyService.insertCompany(company);
		//model.addAttribute("name", employee.getName());
		 return "redirect:/companyList";
	}

}
