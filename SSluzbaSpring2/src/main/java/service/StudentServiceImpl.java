package service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.StudentDTO;
import model.Student;
import repository.StudentRepository;
import service.interfaces.IStudentService;

/**
Created By Marko
*/

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDTO save(StudentDTO studentDto) {
		if(studentDto.getId()==0) {
			Student student = new Student();
			student.setHobi(studentDto.getHobi());
			student.setIndex(studentDto.getIndex());
			student.setSport(studentDto.getSport());
			//student.setOsoba(studentDto.);
		}
		
		return null;
	}


	@Override
	public boolean delete(int id) {

		 studentRepository.deleteById(id);		 
		 return true;
		
	}

	@Override
	public List<StudentDTO> getListStudents(String firstName, String lastName) {
		
		return studentRepository.findAll().stream().map(x -> new StudentDTO(x)).collect(Collectors.toList());
	}

	@Override
	public StudentDTO getById(int id) {

		return new StudentDTO(studentRepository.findById(id).orElse(null));
	}

}
