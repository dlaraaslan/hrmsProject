package javaproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.AuthService;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registeremployer")
	public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
		return authService.registerEmployer(employer, confirmPassword);
	}
	
	@PostMapping("/registercandidate")
	public Result registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
		return authService.registerCandidate(candidate, confirmPassword);
	}
}
