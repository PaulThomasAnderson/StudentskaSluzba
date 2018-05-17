package service.interfaces;

import java.util.List;

import dto.StudentDTO;

/**
Created By Marko
*/

public interface IStudentService {
	
	StudentDTO save(StudentDTO studentDto);
	
	
	List<StudentDTO> getListStudents(String firstName, String lastName);
	
	StudentDTO getById(int id);
	
	boolean delete(int id);
	

}
