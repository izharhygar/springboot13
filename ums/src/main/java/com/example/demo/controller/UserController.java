package com.example.demo.controller;

import java.util.List;

import javax.xml.ws.http.HTTPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public 	ResponseEntity<User> putoneuser(@RequestBody User user)
	{   long old_count = this.userRepo.count();
	    if(this.userRepo.existsById(user.getUser_id()))
	    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	    else {this.userRepo.save(user);
		long new_count = this.userRepo.count();
		System.out.println(old_count+"  .."+new_count);
		if(new_count>old_count)
			return new ResponseEntity<User>(HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	    }
			 
	}
	
	@PutMapping(value="/{id}",produces = "application/json")
	public String updateuser(@PathVariable("id") String Id, @RequestBody User user) {
		userRepo.save(user);
		return "user updated";
	}

}
