package com.vivek.app.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.app.Rest.Repo.Repo;
import com.vivek.app.Rest.User.User;
	
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ApiControllers {
	
	@Autowired
	private Repo userRepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome";
	}
	
	@GetMapping(value="/crudusers")
	public List<User> getUsers() 
	{
		return userRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public String saveUser (@RequestBody User vivek) 
	{
		userRepo.save(vivek);
		return "Saved...";
	}
	
	@PutMapping (value = "/update/{id}")
	public String updateUser (@PathVariable long id, @RequestBody User user) {
		User updatedUser = userRepo.findById(id).get();
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		userRepo.save(updatedUser);
		
		return "Updated...";
		
	}

}
