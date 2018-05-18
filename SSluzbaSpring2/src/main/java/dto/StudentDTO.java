package dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import model.Osoba;
import model.Student;

/**
Created By Luka
*/

public class StudentDTO {
	
	
	
	@NotNull
	private String sport;
	
	@NotNull
	private String hobi;
	
	@NotNull
	private int index;
	
	
	private OsobaDTO osoba; 

	public OsobaDTO getOsoba() {
		return osoba;
	}

	public void setOsoba(OsobaDTO osoba) {
		this.osoba = osoba;
	}

	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentDTO(Student student) {
		setSport(student.getSport());
		setHobi(student.getHobi());
		setIndex(student.getId().getIndex());
		setOsoba(new OsobaDTO(student.getOsoba()));
	}

	public StudentDTO(String sport, String hobi,
			int index, OsobaDTO osoba) {
		super();
		this.sport = sport;
		this.hobi = hobi;
		this.index = index;
		this.osoba = osoba;
	}

	

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getHobi() {
		return hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "StudentDTO [ime="  + osoba.getIme()+ ", prezime=" + osoba.getPrezime()+", pol=" + osoba.getPol()+ ", godRodjenja="
				+ osoba.getGod_rodjenja()  + ", sport=" + sport + ", hobi=" + hobi + ", index=" + index + "]";
	}
	
}
