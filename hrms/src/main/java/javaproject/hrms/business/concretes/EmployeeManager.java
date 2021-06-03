package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.EmployeeService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.dataAccess.abstracts.EmployeeDao;
import javaproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeDao) {
		super();
		this.employeDao = employeDao;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeDao.findAll(),"Çalışanlar listelendi");
	}

}
