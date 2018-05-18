package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.StudentDTO;
import service.interfaces.IStudentService;

/**
Created By Marko
*/

@RestController
@RequestMapping("/api/stud")
public class RestStudentController {
	
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("/all")
	public List<StudentDTO> getStudents(@RequestParam(name = "fnm", required = false) String firstName,
			@RequestParam(name = "lnm", required = false) String lastName) {
		
		return studentService.getListStudents(firstName, lastName);
		
	}
	
	@RequestMapping(path = "/getStudent/{id}", method = RequestMethod.GET )
	public StudentDTO getStudent(@PathVariable("id")int id){
		
		return studentService.getById(id);		
	}
	
	@RequestMapping(path = "/deleteStudent/{id}", method = RequestMethod.DELETE )
	public boolean deleteById(@PathVariable("id")int id){
		
		return studentService.delete(id);		
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public void saveStudent(@RequestBody @Valid StudentDTO s) {
		 studentService.save(s);
	}


}
