package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping(produces = "application/json")
	public List<User> putoneuser(@RequestBody User user)
	{
		this.userRepo.save(user);
		return userRepo.findAll();
	}
	
	@PutMapping(value="/{id}",produces = "application/json")
	public String updateuser(@PathVariable("id") String Id, @RequestBody User user) {
		userRepo.save(user);
		return "user updated";
	}

}
