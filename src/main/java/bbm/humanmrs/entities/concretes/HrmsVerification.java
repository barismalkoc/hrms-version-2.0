package bbm.humanmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "hrms_verification")
@AllArgsConstructor
@NoArgsConstructor
public class HrmsVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hrms_verification_id")
	private int hrms_verification_id;
	
	@Column(name="hrms_verification")
	private boolean hrms_verification;

}
