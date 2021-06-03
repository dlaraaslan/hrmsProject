package javaproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="employers")
public class Employer extends User {
		
	//@PrimaryKeyJoinColumn
	//@Column(name="userId")
	//private int userId;
	
	@Column(name="companyName")
	private String companyName;
	
	@Column(name="webAdress")
	private String webAdress;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name= "userId")
	private User user;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdvert;
	
}
