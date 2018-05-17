package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.RideDTO;
import entity.Ride;
import repository.LicenceRepository;
import repository.RideRepository;
import service.interfaces.IRideService;

@Service
public class RideServiceImpl implements IRideService{
	
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private LicenceRepository licenceRepository;
	
	@Override
	public boolean save(RideDTO rideDTO) {
		Ride ride = new Ride();
		ride.setAddressFrom(rideDTO.getAddressFrom());
		ride.setAddressTo(rideDTO.getAddressTo());
		ride.setDescription(rideDTO.getDescription());
		ride.setLicence(licenceRepository.findById(rideDTO.getLicenceId()).get());
		rideRepository.save(ride);
		return true;
	}
}
