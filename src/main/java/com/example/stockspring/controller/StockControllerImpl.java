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
import com.example.stockspring.model.StockExchange;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.StockService;

@Controller
public class StockControllerImpl {

	@Autowired
	private StockService stockService;

	@RequestMapping(path = "/stockExchangeList")
	public ModelAndView getStockExchangeList() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stockExchangeList");
		mv.addObject("stockExchangeList", stockService.getStockExchangeList());
		return mv;
	}

	@RequestMapping(value = "/stockExchange", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		System.out.println("add stock");
		StockExchange e = new StockExchange();
		// e.setEmail("sdfsf");
		// e.setSalary(4564.56f);
		model.addAttribute("stock", e);
		return "stockExchange";

	}

	@RequestMapping(value = "/stockExchange", method = RequestMethod.POST)
	public String formHandler(@Valid StockExchange stock, 
			BindingResult result, Model model) throws SQLException {
		System.out.println(stock);
		if(result.hasErrors()){
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			model.addAttribute("stock", stock);
			return "stockExchange";
		}
		
		
		stockService.insertStockExchange(stock);
		//model.addAttribute("name", employee.getName());
		 return "redirect:/stockExchangeList";
	}

}
