package com.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repo.TodoRepo;
import com.entity.Todoitems;

@Service
public class TodoitemServices {

	@Autowired
	private TodoRepo todoRepo;
	
	public Iterable<Todoitems> getAll()
	{
		return todoRepo.findAll();
	}
	
	public Optional<Todoitems> getById(Long id)
	{
		return todoRepo.findById(id);
	}
	 
	public Todoitems save(Todoitems todoitems)
	{
		if(todoitems.getId()==null)
		{
			todoitems.setCreatedAt(Instant.now());
		}
		todoitems.setUpdatedAt(Instant.now());
		return todoRepo.save(todoitems);
	}
	public void delete(Todoitems todoitems)
	{
		todoRepo.delete(todoitems);
	}
}
