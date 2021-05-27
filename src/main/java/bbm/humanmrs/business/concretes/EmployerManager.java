package bbm.humanmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanmrs.business.abstracts.EmployerService;
import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.ErrorResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.core.utilities.results.SuccessDataResult;
import bbm.humanmrs.core.utilities.results.SuccessResult;
import bbm.humanmrs.dataAccess.abstracts.EmployerDao;
import bbm.humanmrs.entities.concretes.EmailVerification;
import bbm.humanmrs.entities.concretes.Employer;
import bbm.humanmrs.entities.concretes.HrmsVerification;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	
	
	@Override
	public Result add(Employer employer, EmailVerification emailVerification, HrmsVerification hrmsVerification) {
		
		if(employer.getCompany_name().length() > 2) {
			if(employer.getPassword().equals(employer.getPassword_repeat())) {
				if(emailVerification.isEmail_verification() == true) {
					if(hrmsVerification.isHrms_verification() == true) {
						this.employerDao.save(employer);
						return new SuccessResult("Kayit yapildi.");
					}else {
						return new ErrorResult("Hrms personel onayi bekleyiniz.");
					}
				}else {
					return new ErrorResult("Email onayi yapiniz.");
				}
			}else {
				return new ErrorResult("Sifre kontrolü yapiniz.");
			}
		}else {
			return new ErrorResult("Sirket adi en az iki harften olusabilir.");
		}
	}



	@Override
	public DataResult<List<Employer>> getAll() {
	
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Data getirildi.");
	}

}
