package bbm.humanmrs.business.abstracts;

import java.util.List;

import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.JobSeeker;
import bbm.humanmrs.entities.concretes.MernisVerification;


public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification);

}
