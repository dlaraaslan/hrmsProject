package javaproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="candidates")
public class Candidate extends User {
		
	@Column(name="userId")
	private int userId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="nationalIdentity")
	private String nationalIdentity;
	
	@Column(name="birthYear")
	private int birthYear;
	
	
}
