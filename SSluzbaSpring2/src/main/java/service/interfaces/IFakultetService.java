package service.interfaces;

import java.util.List;

import dto.FakultetDTO;


public interface IFakultetService {
 public List<FakultetDTO> getFakulteti();
 
 public void save(FakultetDTO fakultetDTO);
}
