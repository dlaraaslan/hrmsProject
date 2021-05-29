package javaproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javaproject.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode, Integer>{

}
