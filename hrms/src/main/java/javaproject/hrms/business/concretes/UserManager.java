package javaproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javaproject.hrms.business.abstracts.UserService;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessDataResult;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.dataAccess.abstracts.UserDao;
import javaproject.hrms.entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),"Kullanıcılar listelendi");
				
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findUserByEmail(email));
	}

}
