package javaproject.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "jobAdverts")
public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employerId")
	private int employerId;
	
	@Column(name="jobTitleId")
	private int jobTitleId;
	
	@Column(name="city")
	private String city;
	
	@Column(name="minSalary")
	private int minSalary;
	
	@Column(name="maxSalary")
	private int maxSalary;
	
	@Column(name="numberOfOpenPositions")
	private int numberOfOpenPositions;
	
	@Column(name="createdDate")
	private LocalDate createdDate;
	
	@Column(name="lastDate")
	private LocalDate lastDate;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="employerId")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="jobTitleId")
	private JobTitle jobTitle;
}
