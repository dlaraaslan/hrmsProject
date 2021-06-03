package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	DataResult<JobAdvert> getById(int id);	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllActiveJobAdvertList();
	DataResult<List<JobAdvert>> findAllByOrderByCreatedDate();
	DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(int id);
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(int id);
	Result updateAsPassiveAd(int id);
}
