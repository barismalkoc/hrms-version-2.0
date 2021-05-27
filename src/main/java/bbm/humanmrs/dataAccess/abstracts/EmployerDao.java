package bbm.humanmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanmrs.entities.concretes.Employer;


public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
