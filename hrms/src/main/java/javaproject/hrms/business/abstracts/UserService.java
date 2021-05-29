package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	Result add(User user);
	DataResult<User> findUserByEmail(String email);
}
