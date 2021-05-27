package bbm.humanmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbm.humanmrs.business.abstracts.JobPositionService;
import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.ErrorResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.core.utilities.results.SuccessDataResult;
import bbm.humanmrs.core.utilities.results.SuccessResult;
import bbm.humanmrs.dataAccess.abstracts.JobPositionDao;
import bbm.humanmrs.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data getirildi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPosition.getJob_position().length() > 5) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Data getirildi");
		}
		return new ErrorResult("Data getirilemedi.");
	}

}
