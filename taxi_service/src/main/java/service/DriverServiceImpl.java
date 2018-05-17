package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.DriverDTO;
import dto.LicenceDTO;
import entity.Driver;
import entity.DriverLicence;
import entity.DriverLicencePK;
import entity.Licence;
import repository.DriverLicenceRepository;
import repository.DriverRepository;
import service.interfaces.IDriverService;

@Service
public class DriverServiceImpl implements IDriverService {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private DriverLicenceRepository driverLicenceRepository;
	
	@Override
	public DriverDTO save(DriverDTO driverDTO) {
		Driver driver;
		if(driverDTO.getId() == 0) {
			driver = new Driver();
			driver.setAge(driverDTO.getAge());
			driver.setFirstName(driverDTO.getFirstName());
			driver.setLastName(driverDTO.getLastName());
		} else {
			driver = driverRepository.findById(driverDTO.getId()).orElse(null);
			driver.setAge(driverDTO.getAge());
			driver.setFirstName(driverDTO.getFirstName());
			driver.setLastName(driverDTO.getLastName());
		}
		driver = driverRepository.save(driver);
		return new DriverDTO(driver);
	}
	
	@Override
	public List<DriverDTO> all(){
		return driverRepository.findAll().stream()
				.map(x -> new DriverDTO(x))
				.collect(Collectors.toList());
	}
	
	@Override
	public DriverDTO get(int id) {
		return new DriverDTO(driverRepository.findById(id).get());
	}
	
	@Override
	public LicenceDTO addLicence(LicenceDTO licenceDTO) {
		// TODO Auto-generated method stub
		DriverLicence driverLicence = new DriverLicence();
		DriverLicencePK pk = new DriverLicencePK();
		pk.setDriverId(licenceDTO.getDriverId());
		pk.setLicenceId(licenceDTO.getLicenceId());
		driverLicence.setDriverLicence(pk);
		driverLicenceRepository.save(driverLicence);
		return licenceDTO;
	}
}
