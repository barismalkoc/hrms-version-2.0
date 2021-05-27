package bbm.humanmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bbm.humanmrs.business.abstracts.EmployerService;
import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.Employer;
import bbm.humanmrs.entities.concretes.HrmsVerification;


@RestController
@RequestMapping("/humanmrs/employer")
public class EmployerControllers {

	private EmployerService employerService;

	@Autowired
	public EmployerControllers(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer, EmailVerification emailVerification, HrmsVerification hrmsVerification) {
		return this.employerService.add(employer, emailVerification, hrmsVerification);
	}
	
}
