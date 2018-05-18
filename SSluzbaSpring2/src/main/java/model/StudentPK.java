package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the student database table.
 * 
 */
@Embeddable
public class StudentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int index;

	@Column(name="osoba_id", insertable=false, updatable=false)
	private int osobaId;

	public StudentPK() {
	}
	public StudentPK(int index) {
		this.index=index;
	}

	public int getIndex() {
		return this.index;
	}
	public void setIndex(int index) {
		this.index = index;
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
		if (!(other instanceof StudentPK)) {
			return false;
		}
		StudentPK castOther = (StudentPK)other;
		return 
			(this.index == castOther.index)
			&& (this.osobaId == castOther.osobaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.index;
		hash = hash * prime + this.osobaId;
		
		return hash;
	}
}