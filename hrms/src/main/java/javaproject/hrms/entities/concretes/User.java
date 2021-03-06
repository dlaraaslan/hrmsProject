package javaproject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="users")
@Inheritance(strategy= InheritanceType.JOINED) 
@JsonIgnoreProperties({"hibernameLazyInitalizer","handler","products"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //bir bir oto artan
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	 
	@OneToMany(mappedBy = "user")
	private List<Candidate> candidate;
	
	@OneToMany(mappedBy = "user")
	private List<Employee> employee;
	
	@OneToMany(mappedBy = "user")
	private List<Employer> employer;
}
