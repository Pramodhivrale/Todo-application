package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Todoitems;
import com.services.TodoitemServices;

import jakarta.validation.Valid;

@Controller
public class TodoFromController {

	@Autowired
	private TodoitemServices todoitemServices;
	
	@GetMapping("/create")
	public String showCreateFrom(Todoitems todoitems)
	{
		
		return "new-todo-item";
		
	}
	
	@PostMapping("/todo")
	public String createTodoitem(@Valid Todoitems todoitems,BindingResult result,Model model)
	{
		Todoitems item=new Todoitems();
		item.setDescription(todoitems.getDescription());
		item.setIsComplete(todoitems.getIsComplete());
		
		todoitemServices.save(todoitems);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Long id,Model model)
	{
		Todoitems todoitems=todoitemServices.getById(id).orElseThrow(() ->new IllegalArgumentException("TodoItem id:"+id+"not found"));
		todoitemServices.delete(todoitems);
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdatedfrom(@PathVariable("id") Long id,Model model)
	{
		Todoitems todoitems=todoitemServices.getById(id).orElseThrow(() ->new IllegalArgumentException("TodoItem id:"+id+"not found"));
		model.addAttribute("todo", todoitems);
		return "edit-todo-item";
	}
	
	@PostMapping("/todo/{id}")
	public String updateTodoItem(@PathVariable("id") Long id,@Valid Todoitems todoitems,BindingResult result,Model model)
	{
		Todoitems item=todoitemServices.getById(id).orElseThrow(() ->new IllegalArgumentException("TodoItem id:"+id+"not found"));
		item.setIsComplete(todoitems.getIsComplete());
		item.setDescription(todoitems.getDescription());
		
		todoitemServices.save(item);
		return "redirect:/";
		
	}
}
