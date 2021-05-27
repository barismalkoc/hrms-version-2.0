package bbm.humanmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanmrs.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

}
