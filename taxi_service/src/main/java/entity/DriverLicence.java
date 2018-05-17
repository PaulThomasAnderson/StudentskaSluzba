package entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_licence")
public class DriverLicence implements Serializable{
	
	@EmbeddedId
	private DriverLicencePK driverLicence;
	
	@JoinColumn(name = "driver_id", referencedColumnName = "driver_id", insertable=false, updatable=false)
	@ManyToOne
	private Driver driver;
	
	@JoinColumn(name = "licence_id", referencedColumnName = "licence_id", insertable=false, updatable=false)
	@ManyToOne
	private Licence licence;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Licence getLicence() {
		return licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	public DriverLicencePK getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(DriverLicencePK driverLicence) {
		this.driverLicence = driverLicence;
	}

	
	
	
}
