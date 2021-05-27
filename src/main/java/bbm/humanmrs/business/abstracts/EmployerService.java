package bbm.humanmrs.business.abstracts;

import java.util.List;

import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.Employer;
import bbm.humanmrs.entities.concretes.HrmsVerification;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	Result add(Employer employer, EmailVerification emailVerification, HrmsVerification hrmsVerification);

}
