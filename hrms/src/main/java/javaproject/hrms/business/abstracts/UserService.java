package javaproject.hrms.business.abstracts;

import java.util.List;

import javaproject.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
