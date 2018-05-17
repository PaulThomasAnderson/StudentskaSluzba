package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.DriverLicence;
import entity.DriverLicencePK;

public interface DriverLicenceRepository extends JpaRepository<DriverLicence, DriverLicencePK>{
	
}
