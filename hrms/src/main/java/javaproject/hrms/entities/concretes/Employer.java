package javaproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employers")
public class Employer extends User {
		
	@Column(name="userId")
	private int userId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="webAdress")
	private String webAdress;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
}
