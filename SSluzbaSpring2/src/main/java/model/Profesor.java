package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profesor database table.
 * 
 */
@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProfesorPK id;

	private String seminar;

	//bi-directional many-to-one association to Predmet
	@OneToMany(mappedBy="profesor")
	private List<Predmet> predmets;

	//bi-directional one-to-one association to Osoba
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="osoba_id", referencedColumnName="id", insertable=false, updatable=false),
		})
	private Osoba osoba;

	public Profesor() {
	}

	public ProfesorPK getId() {
		return this.id;
	}

	public void setId(ProfesorPK id) {
		this.id = id;
	}

	public String getSeminar() {
		return this.seminar;
	}

	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}

	public List<Predmet> getPredmets() {
		return this.predmets;
	}

	public void setPredmets(List<Predmet> predmets) {
		this.predmets = predmets;
	}

	public Predmet addPredmet(Predmet predmet) {
		getPredmets().add(predmet);
		predmet.setProfesor(this);

		return predmet;
	}

	public Predmet removePredmet(Predmet predmet) {
		getPredmets().remove(predmet);
		predmet.setProfesor(null);

		return predmet;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}