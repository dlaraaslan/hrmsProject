package javaproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javaproject.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	
	JobAdvert getById(int id);
	
	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllActiveJobAdvertList();
	
	@Query("From JobAdvert where isOpen = true Order By createdDate Desc")
	List<JobAdvert> findAllByOrderByCreatedDateDesc();
	
	@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvert> getAllActiveJobAdvertByEmployer(int id);
	
	
}
