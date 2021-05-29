package javaproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.CandidateService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return candidateService.getAll();
	}
	
	@GetMapping("/getCandidatebynationalidentity")
	public DataResult<Candidate> getCandidateByNationalIdentity(String nationalIdentity){
		return candidateService.getCandidateByNationalIdentity(nationalIdentity);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return candidateService.add(candidate);
	}
}
