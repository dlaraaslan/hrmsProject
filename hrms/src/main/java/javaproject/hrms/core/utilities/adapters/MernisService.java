package javaproject.hrms.core.utilities.adapters;

import javaproject.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
