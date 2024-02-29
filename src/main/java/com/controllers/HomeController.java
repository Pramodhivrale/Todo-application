package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.services.TodoitemServices;

@Controller
public class HomeController {

	@Autowired
	private TodoitemServices todoitemServices;
	
//	@GetMapping("/get")
//	public ModelAndView index()
//	{
//		ModelAndView modelAndView=new ModelAndView("index");
//		modelAndView.addObject("todoitems",todoitemServices.getAll());
//		return modelAndView;
//		
//	}
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("todoitems", todoitemServices.getAll());
		return "index";
	}
}
