package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class DriverLicencePK implements Serializable {
	@Column(name="driver_id", insertable=false, updatable=false)
	private int driverId;
	@Column(name="licence_id", insertable=false, updatable=false)
	private int licenceId;
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getLicenceId() {
		return licenceId;
	}
	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}
	public DriverLicencePK() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + driverId;
		result = prime * result + licenceId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverLicencePK other = (DriverLicencePK) obj;
		if (driverId != other.driverId)
			return false;
		if (licenceId != other.licenceId)
			return false;
		return true;
	}
	
	
	
}
