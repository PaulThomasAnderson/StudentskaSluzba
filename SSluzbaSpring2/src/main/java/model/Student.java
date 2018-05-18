package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StudentPK id;

	private String hobi;

	private String sport;

	//bi-directional many-to-one association to Polaganje
	@OneToMany(mappedBy="student")
	private List<Polaganje> polaganjes1;

	//bi-directional many-to-one association to Polaganje
	//@OneToMany(mappedBy="student2")
	//private List<Polaganje> polaganjes2;

	//bi-directional one-to-one association to Osoba
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="osoba_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Osoba osoba;

	public Student() {
	}

	public StudentPK getId() {
		return this.id;
	}

	public void setId(StudentPK id) {
		this.id = id;
	}

	public String getHobi() {
		return this.hobi;
	}

	public void setHobi(String hobi) {
		this.hobi = hobi;
	}

	public String getSport() {
		return this.sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public List<Polaganje> getPolaganjes1() {
		return this.polaganjes1;
	}

	public void setPolaganjes1(List<Polaganje> polaganjes1) {
		this.polaganjes1 = polaganjes1;
	}

	public Polaganje addPolaganjes1(Polaganje polaganjes1) {
		getPolaganjes1().add(polaganjes1);
		polaganjes1.setStudent(this);

		return polaganjes1;
	}

	public Polaganje removePolaganjes1(Polaganje polaganjes1) {
		getPolaganjes1().remove(polaganjes1);
		polaganjes1.setStudent(null);

		return polaganjes1;
	}



	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}