package javaproject.hrms.business.abstracts;

import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;

public interface AuthService {
	Result registerEmployer(Employer employer, String confirmPassword);
	Result registerCandidate(Candidate candidate, String confirmPassword);
}
