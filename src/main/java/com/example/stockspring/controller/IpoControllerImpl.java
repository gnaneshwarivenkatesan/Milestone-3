package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.IPODetails;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.IpoService;

@Controller
public class IpoControllerImpl {

	@Autowired
	private IpoService ipoService;

	@RequestMapping(path = "/ipoList")
	public ModelAndView getIpoList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ipoList");
		mv.addObject("ipoList", ipoService.getIpoList());
		return mv;
	}

	@RequestMapping(value = "/ipoDetails", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add ipo");
		IPODetails e = new IPODetails();
		// e.setEmail("sdfsf");
		// e.setSalary(4564.56f);
		model.addAttribute("ipo", e);
		return "IpoDetails";

	}

	@RequestMapping(value = "/ipoDetails", method = RequestMethod.POST)
	public String formHandler(@Valid IPODetails ipo, 
			BindingResult result, Model model) throws SQLException {
		System.out.println(ipo);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("ipo", ipo);
			return "IpoDetails";
		}
		
		
		ipoService.insertIpo(ipo);
		//model.addAttribute("name", employee.getName());
		 return "redirect:/ipoList";
	}

}
