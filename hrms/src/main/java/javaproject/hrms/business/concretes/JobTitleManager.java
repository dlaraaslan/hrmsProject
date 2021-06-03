package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.JobTitleService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.JobTitleDao;
import javaproject.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;

	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(findByJobTitle(jobTitle.getTitle()).getData() != null) {
			return new ErrorResult(jobTitle.getTitle() + "Bu iş pozisyonu zaten kayıtlı");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi");
	}

	@Override
	public DataResult<JobTitle> findByJobTitle(String title) {
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.findByJobTitle(title));
	}

}
