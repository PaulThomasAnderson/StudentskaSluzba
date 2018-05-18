package service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.OsobaDTO;
import dto.StudentDTO;
import model.Osoba;
import model.Student;
import model.StudentPK;
import repository.OsobaRepository;
import repository.StudentRepository;
import service.interfaces.IStudentService;

/**
Created By Luka
*/

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private OsobaRepository osobaRepository;

	@Override
	public void save(StudentDTO studentDTO) {
		Student student;
		Osoba osoba;
		if(studentDTO.getIndex()==0) {
		    student = new Student();
		    osoba = new Osoba();
			student.setHobi(studentDTO.getHobi());
			student.getId().setIndex(studentDTO.getIndex());
			student.setSport(studentDTO.getSport());
			osoba.setIme(studentDTO.getOsoba().getIme());
			osoba.setPrezime(studentDTO.getOsoba().getPrezime());
			osoba.setPol(studentDTO.getOsoba().getPol());
			osoba.setMesto(studentDTO.getOsoba().getMesto());
			osoba.setPostanskiBr(studentDTO.getOsoba().getPostanskiBr());
			osoba.setGodRodjenja(studentDTO.getOsoba().getGod_rodjenja());
			student.setOsoba(osoba);
		}else {
			student = studentRepository.findById(studentDTO.getIndex()).orElse(null);

			if(student==null) {
				System.err.println("Ne postoji student sa tim id");
			}else{
				student.setHobi(studentDTO.getHobi());
				student.setId(new StudentPK(studentDTO.getIndex()));
				student.setSport(studentDTO.getSport());
				student.setOsoba(osobaRepository.findById(studentDTO.getOsoba().getId()).orElse(null));

			}
		}
		
		
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
