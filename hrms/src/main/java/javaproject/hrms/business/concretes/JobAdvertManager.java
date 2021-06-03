package javaproject.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javaproject.hrms.business.abstracts.JobAdvertService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.JobAdvertDao;
import javaproject.hrms.entities.concretes.JobAdvert;

public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>
		(this.jobAdvertDao.getById(id)) ;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllActiveJobAdvertList());
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByCreatedDate() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.findAllByOrderByCreatedDateDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertDao.getAllActiveJobAdvertByEmployer(id));
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(CheckAdd(jobAdvert)) {
			return new ErrorResult("Alanları kontrol ediniz");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("iş ilanı güncellendi")
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("İlan silindi");
	}
	
	@Override
	public Result updateAsPassiveAd(int id) {
		if(getById(id) == null && getById(id).getData().isActive() == true) {
			return new ErrorResult("Geçersiz alan");
		}
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setActive(false);
		update(jobAdvert);
		return new SuccessResult("İlan kapatılmıştır");
	}
	
	private boolean CheckAdd(JobAdvert jobAdvert) {
		if (jobAdvert.getJobTitle() != null 
				&& jobAdvert.getDescription() != null 
				&& jobAdvert.getCity() != null
				&& jobAdvert.getNumberOfOpenPositions() != 0
				&& jobAdvert.getLastDate().isBefore(LocalDate.now())) {
			return true;
		}
		return false;
	}

	

}
