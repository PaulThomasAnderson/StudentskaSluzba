package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.FakultetDTO;
import dto.StudentDTO;
import service.interfaces.IFakultetService;

@RestController
@RequestMapping("/api/fakultet")
public class RestFakultetController {

	@Autowired
	IFakultetService fakultetService;
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<FakultetDTO> getFakulteti() {
		
		return fakultetService.getFakulteti();
		
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveStudent(@RequestBody FakultetDTO fakultetDTO) {
		fakultetService.save(fakultetDTO);
	}
}
