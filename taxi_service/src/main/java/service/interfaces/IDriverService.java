package service.interfaces;

import java.util.List;

import dto.DriverDTO;
import dto.LicenceDTO;

public interface IDriverService {

	DriverDTO save(DriverDTO driverDTO);

	List<DriverDTO> all();

	DriverDTO get(int id);

	LicenceDTO addLicence(LicenceDTO licenceDTO);

}
