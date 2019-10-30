package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;

	
	@GetMapping
	public List<User> getUsers()
	{
		return userRepo.findAll();
	}	
//	@GetMapping("/{id}")
//	public User getoneuser(@PathVariable("id") String Id)
//	{
//		return this.userRepo.findOne(Id);
//	}
//	@PutMapping
//	public User putoneuser(@RequestBody User user)
//	{
//		this.service.addUser(user);
//		return user;
//	}
//	
}
