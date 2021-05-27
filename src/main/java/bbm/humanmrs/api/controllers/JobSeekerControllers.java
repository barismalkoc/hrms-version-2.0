package bbm.humanmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bbm.humanmrs.business.abstracts.JobSeekerService;
import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.JobSeeker;
import bbm.humanmrs.entities.concretes.MernisVerification;

@RestController
@RequestMapping("/humanmrs/joSeeker")
public class JobSeekerControllers {
	
	@Autowired
	private JobSeekerService jobSeekerService;

	public JobSeekerControllers(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification) {
		return this.jobSeekerService.add(jobSeeker, emailVerification, mernisVerification);
	}
	

}
