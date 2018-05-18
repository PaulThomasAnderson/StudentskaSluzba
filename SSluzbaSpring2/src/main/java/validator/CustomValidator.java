package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import dto.StudentDTO;

@Component
public class CustomValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return StudentDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		StudentDTO studentDTO = (StudentDTO) arg0;
		if (studentDTO.getOsoba().getIme() == null) {
			arg1.reject("ime","Ime is null!!!!");
		}
	}
	
	

}
