package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.LicenceDTO;
import entity.Licence;
import repository.LicenceRepository;
import service.interfaces.ILicenceService;

@Service
public class LicenceServiceImpl implements ILicenceService{

	@Autowired
	LicenceRepository licenceRepository;
	
	@Override
	public List<LicenceDTO> getAll() {
		return licenceRepository.findAll()
				.stream()
				.map(x -> new LicenceDTO(x))
				.collect(Collectors.toList());
	}
}
