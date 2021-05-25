package javaproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.UserService;
import javaproject.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class usersController {
	
	private UserService userService;
	
	public usersController(UserService userService) {
		super();
		this.userService = userService;		
	}
	
	@GetMapping("/getall")
	public List<User> getAll(){
		return this.userService.getAll();
	}
	
}
