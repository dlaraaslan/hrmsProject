package javaproject.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaproject.hrms.business.abstracts.JobAdvertService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert){
		return this.jobAdvertService.add(jobAdvert);
	}
	
//	@PostMapping("/update")
//	public Result update(@RequestBody JobAdvert jobAdvert){
//		return this.jobAdvertService.update(jobAdvert);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(@RequestParam("id") int id){
//		return this.jobAdvertService.delete(id);
//	}
	
	@GetMapping("/getbyid")
	public DataResult<JobAdvert> getById(@RequestParam int id){
		return this.jobAdvertService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){		
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getAllActiveJobAdvertList")
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertList(){
		return this.jobAdvertService.getAllActiveJobAdvertList();
	}
	
	@GetMapping("/findAllByOrderByCreatedDate")
	public DataResult<List<JobAdvert>> findAllByOrderByCreatedDate(){
		return this.jobAdvertService.findAllByOrderByCreatedDate();
	}
	
	@GetMapping("getAllActiveJobAdvertByEmployer")
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(int id){
		return this.jobAdvertService.getAllActiveJobAdvertByEmployer(id);
	}
	
	@GetMapping("/updateAsPassiveAd")
	public Result updateAsPassiveAd(int id) {
		return this.jobAdvertService.updateAsPassiveAd(id);
	}
	
	
}
