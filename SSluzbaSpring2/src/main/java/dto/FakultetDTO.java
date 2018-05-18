package dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import model.Fakultet;

public class FakultetDTO {

	private int id;

	@NotNull
	@NotEmpty
	private String naziv;

	@NotNull
	@NotEmpty
	private String skracenica;
	
	

	public FakultetDTO(int id, String naziv, String skracenica) {
		
		this.id = id;
		this.naziv = naziv;
		this.skracenica = skracenica;
	}
	
	

	public FakultetDTO() {
		super();
	}

	public FakultetDTO(Fakultet f) {
		
		setId(f.getId());
		setNaziv(f.getNaziv());
		setSkracenica(f.getSkracenica());
	}



	@Override
	public String toString() {
		return "FakultetDTO [id=" + id + ", naziv=" + naziv + ", skracenica=" + skracenica + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkracenica() {
		return skracenica;
	}

	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}
	
	
	
	
	
}
