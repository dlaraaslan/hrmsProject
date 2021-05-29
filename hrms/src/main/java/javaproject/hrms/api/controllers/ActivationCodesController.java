package javaproject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.ActivationCodeService;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.ActivationCode;

@RestController
@RequestMapping("/api/activationcodes")
public class ActivationCodesController {
	private ActivationCodeService activationCodeService;

	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ActivationCode activationCode) {
		return activationCodeService.add(activationCode);
	}
	
}
