package javaproject.hrms.business.abstracts;
import java.util.List;
import javaproject.hrms.core.utilities.results.DataResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getCandidateByNationalIdentity(String nationalIdentity);
	Result add(Candidate candidate);
}
