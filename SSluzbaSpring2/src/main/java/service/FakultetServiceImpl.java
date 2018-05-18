package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.FakultetDTO;
import dto.StudentDTO;
import model.Fakultet;
import repository.FakultetRepository;
import service.interfaces.IFakultetService;

@Service
public class FakultetServiceImpl implements IFakultetService {

	@Autowired
	FakultetRepository fakultetRepository;

	@Override
	public List<FakultetDTO> getFakulteti() {

		return fakultetRepository.findAll().stream().map(x -> new FakultetDTO(x)).collect(Collectors.toList());
	}

	@Override
	public void save(FakultetDTO fakultetDTO) {
		Fakultet fakultet;
		if (fakultetDTO.getId() == 0) {
			fakultet = new Fakultet();
			fakultet.setNaziv(fakultetDTO.getNaziv());
			fakultet.setSkracenica(fakultetDTO.getSkracenica());
		} else {
			fakultet = fakultetRepository.findById(fakultetDTO.getId()).orElse(null);
			if (fakultet == null) {
				System.err.println("Ne postoji fakultet s tim id");
				return;
			}

			fakultet.setNaziv(fakultetDTO.getNaziv());
			fakultet.setSkracenica(fakultetDTO.getSkracenica());
		}
		fakultetRepository.save(fakultet);
	}

}
