package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the profesor database table.
 * 
 */
@Embeddable
public class ProfesorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="osoba_id", insertable=false, updatable=false)
	private int osobaId;

	public ProfesorPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOsobaId() {
		return this.osobaId;
	}
	public void setOsobaId(int osobaId) {
		this.osobaId = osobaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProfesorPK)) {
			return false;
		}
		ProfesorPK castOther = (ProfesorPK)other;
		return 
			(this.id == castOther.id)
			&& (this.osobaId == castOther.osobaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.osobaId;
		
		return hash;
	}
}