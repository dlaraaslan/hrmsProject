package javaproject.hrms.business.abstracts;

import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {
	Result add(ActivationCode activationCode);
}
