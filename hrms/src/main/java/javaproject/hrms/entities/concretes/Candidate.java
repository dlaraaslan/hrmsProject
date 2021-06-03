package javaproject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="candidates")
public class Candidate extends User {
	
	//@PrimaryKeyJoinColumn
	//@Column(name="userId")
	//private int userId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="nationalIdentity")
	private String nationalIdentity;
	
	@Column(name="birthYear")
	private int birthYear;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
}
