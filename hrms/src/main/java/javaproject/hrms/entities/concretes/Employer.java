package javaproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="employers")
public class Employer extends User {
		
	@PrimaryKeyJoinColumn
	@Column(name="userId")
	private int userId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="webAdress")
	private String webAdress;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
}
