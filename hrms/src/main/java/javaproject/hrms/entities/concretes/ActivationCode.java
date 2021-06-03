package javaproject.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activationCodes")
public class ActivationCode {
	
	@Autowired
	public ActivationCode(int userId, String code, boolean isVerified, LocalDate confirmedDate) {
		super();
		this.userId = userId;
		this.code = code;
		this.isVerified = isVerified;
		this.confirmedDate = confirmedDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@PrimaryKeyJoinColumn
	@Column(name="userId")
	private int userId;
	
	@Column(name="code")
	private String code;
	
	@Column(name="isVerified")
	private boolean isVerified;
	
	@Column(name="confirmedDate",columnDefinition = "Date defult CURRENT_DATE")
	private LocalDate confirmedDate = LocalDate.now();
	
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private User user;
}
