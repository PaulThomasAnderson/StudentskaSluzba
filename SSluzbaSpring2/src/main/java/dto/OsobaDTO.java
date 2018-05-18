package dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import model.Osoba;

public class OsobaDTO {
	private int id;	
	
	@Size(min = 2)
	@NotNull
	@NotEmpty
	private String ime;
	
	@Size(min = 2)
	@NotNull
	@NotEmpty
	private String prezime;
	
	@NotNull
	@NotEmpty
	private String pol;
	
	@NotNull
	private Timestamp god_rodjenja;
	
	@NotNull
	private String mesto;

	@NotNull
	private int postanskiBr;

	
	

	public OsobaDTO(int id, String ime, String prezime, String pol, Timestamp god_rodjenja, String mesto, int postanskiBr) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.pol = pol;
		this.god_rodjenja = god_rodjenja;
		this.mesto=mesto;
		this.postanskiBr=postanskiBr;
	}
	
	

	public OsobaDTO() {
		super();
	}
	
	public OsobaDTO(Osoba o) {
		super();
		setId(o.getId());
		setIme(o.getIme());
		setPrezime(o.getPrezime());
		setPol(o.getPol());
		setMesto(o.getMesto());
		setPostanskiBr(o.getPostanskiBr());
		
	}

	


	public String getMesto() {
		return mesto;
	}



	public void setMesto(String mesto) {
		this.mesto = mesto;
	}



	public int getPostanskiBr() {
		return postanskiBr;
	}



	public void setPostanskiBr(int postanskiBr) {
		this.postanskiBr = postanskiBr;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Timestamp getGod_rodjenja() {
		return god_rodjenja;
	}

	public void setGod_rodjenja(Timestamp god_rodjenja) {
		this.god_rodjenja = god_rodjenja;
	}

	

}
