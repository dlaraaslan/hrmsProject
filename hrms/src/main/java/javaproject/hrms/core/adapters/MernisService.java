package javaproject.hrms.core.adapters;

import javaproject.hrms.entities.concretes.Candidate;

public interface MernisService {
	boolean checkIfRealPerson(Candidate candidate);
}
