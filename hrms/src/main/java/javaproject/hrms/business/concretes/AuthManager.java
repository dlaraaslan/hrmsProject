package javaproject.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaproject.hrms.business.abstracts.ActivationCodeService;
import javaproject.hrms.business.abstracts.AuthService;
import javaproject.hrms.business.abstracts.CandidateService;
import javaproject.hrms.business.abstracts.EmployerService;
import javaproject.hrms.business.abstracts.UserService;
import javaproject.hrms.core.utilities.adapters.MernisService;
import javaproject.hrms.core.utilities.results.ErrorResult;
import javaproject.hrms.core.utilities.results.Result;
import javaproject.hrms.core.utilities.results.SuccessResult;
import javaproject.hrms.core.verification.VerificationService;
import javaproject.hrms.entities.concretes.ActivationCode;
import javaproject.hrms.entities.concretes.Candidate;
import javaproject.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private CandidateService candidateService;
	private VerificationService verificationService;
	private MernisService mernisService;
	private ActivationCodeService activationCodeService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, CandidateService candidateService,
			VerificationService verificationService, MernisService mernisService,
			ActivationCodeService activationCodeService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.verificationService = verificationService;
		this.mernisService = mernisService;
		this.activationCodeService = activationCodeService;
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if(!checkIfNullInfoForEmployer(employer)) {
			return new ErrorResult("Eksik bilgi girdiniz.");
		}
		if(!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebAdress())) {
			return new ErrorResult("Geçersiz email.");
		}
		if(!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + "bu emaile kayıtlı bir adres zaten var");
		}
		if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Parolalar aynı değil.");
		}
		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Kayıt oluşturuldu.");
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {
		if(mernisService.checkIfRealPerson(candidate) == false) {
			return new ErrorResult("Bilgilerinizi lütfen doğru girin");
		}
		if(!checkIfNullInfoForCandidate(candidate, confirmPassword)) {
			return new ErrorResult("Eksik bilgi girdiniz.");
		}
		if(!checkIfExistsTcNo(candidate.getNationalIdentity())) {
			return new ErrorResult(candidate.getNationalIdentity() + "zaten var");
		}
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() + "zaten var");
		}
		candidateService.add(candidate);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, candidate.getId(), candidate.getEmail());
		return new SuccessResult("Kayıt oluşturuldu");
	}

	// Validation for employer register 

	private boolean checkIfNullInfoForEmployer(Employer employer) {

		if (employer.getCompanyName() != null && employer.getWebAdress() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {
			return true;
		}
		return false;
	}
	private boolean checkIfEqualEmailAndDomain(String email, String webAdress) {
		String[] emailArr = email.split("@", 2);
		String domain = webAdress.substring(4, webAdress.length());

		if (emailArr[1].equals(domain)) {
			return true;
		}
		return false;
	}
	// Validation for candidate register 
	
		private boolean checkIfNullInfoForCandidate(Candidate candidate, String confirmPassword) {

			if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getNationalIdentity() != null
					&& candidate.getBirthYear() != (Integer)null && candidate.getPassword() != null && candidate.getEmail() != null
					&& confirmPassword != null) {

				return true;
			}
			return false;
		}

		private boolean checkIfExistsTcNo(String nationalId) {

			if (this.candidateService.getCandidateByNationalIdentity(nationalId).getData() == null) {
				return true;
			}
			return false;
		}

		// Common Validation

		private boolean checkIfEmailExists(String email) {

			if (this.userService.findUserByEmail(email).getData() == null) {
				return true;
			}
			return false;
		}

		private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

			if (!password.equals(confirmPassword)) {
				return false;
			}

			return true;
		}
		
		private void verificationCodeRecord(String code, int id, String email) {
			
			ActivationCode activationCode = new ActivationCode(id, code, false, LocalDate.now());
			this.activationCodeService.add(activationCode);
			System.out.println("Verification code has been sent to " + email );
		
		}


}
