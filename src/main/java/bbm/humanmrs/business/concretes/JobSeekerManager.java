package bbm.humanmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanmrs.business.abstracts.JobSeekerService;
import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.ErrorResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.core.utilities.results.SuccessDataResult;
import bbm.humanmrs.core.utilities.results.SuccessResult;
import bbm.humanmrs.dataAccess.abstracts.JobSeekerDao;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.JobSeeker;
import bbm.humanmrs.entities.concretes.MernisVerification;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao JobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		JobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.JobSeekerDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(JobSeeker jobSeeker, EmailVerification emailVerification, MernisVerification mernisVerification ) {
		
		if(jobSeeker.getPassword().equals(jobSeeker.getPassword_repeat())) {
			if(jobSeeker.getIdentity_number().length() == 11) {
				if(jobSeeker.getFirst_name().length() > 2) {
					if(jobSeeker.getLast_name().length() > 1) {
						if(emailVerification.isEmail_verification() == true) {
							if(mernisVerification.isMernis_verification() == true) {
								this.JobSeekerDao.save(jobSeeker);
								return new SuccessResult("Kayit yapildi.");
							}else {
								return new ErrorResult("Mernis onayi yapilamadi.");
							}
						}else {
							return new ErrorResult("Mailinizi onaylayiniz.");
						}
						
					}else {
						return new ErrorResult("Soyadiniz en az iki harften olusmalidir.");
					}
				}else {
					return new ErrorResult("Adiniz en az üc harften olusmalidir.");
				}
			}else {
				return new ErrorResult("Kimlik numarasi 11 haneli olmali.");
			}
		}else {
			return new ErrorResult("Sifre tekrarini kontrol ediniz.");
			
		}
		
	}
	
		
	
		
		

}
