package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.stockspring.model.User;

import com.example.stockspring.service.UserService;

@Controller
public class UserControllerImpl {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add user");
		User e = new User();
		// e.setEmail("sdfsf");
		// e.setSalary(4564.56f);
		model.addAttribute("e2", e);
		return "signup";

	}

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String formHandler(@Valid @ModelAttribute("e2")User user, 
			BindingResult result, Model model) throws SQLException {
		System.out.println(user);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("e2", user);
			return "signup";
		}
		
		
		userService.registerUser(user);
		//model.addAttribute("name", employee.getName());
		 return "login";
	}
}
