package bbm.humanmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import bbm.humanmrs.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

}
