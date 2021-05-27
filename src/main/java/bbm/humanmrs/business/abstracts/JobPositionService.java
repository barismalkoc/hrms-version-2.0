package bbm.humanmrs.business.abstracts;

import java.util.List;

import bbm.humanmrs.core.utilities.results.DataResult;
import bbm.humanmrs.core.utilities.results.Result;
import bbm.humanmrs.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);

}
