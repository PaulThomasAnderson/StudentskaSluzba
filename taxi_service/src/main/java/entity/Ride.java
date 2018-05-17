package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ride database table.
 * 
 */
@Entity
@NamedQuery(name="Ride.findAll", query="SELECT r FROM Ride r")
public class Ride implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ride_id")
	private int rideId;

	@Column(name="address_from")
	private String addressFrom;

	@Column(name="address_to")
	private String addressTo;

	private String description;

	private Timestamp finished;

	private Timestamp started;

	//bi-directional many-to-one association to Driver
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;

	//bi-directional many-to-one association to Licence
	@ManyToOne
	@JoinColumn(name="licence_id")
	private Licence licence;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	public Ride() {
	}

	public int getRideId() {
		return this.rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public String getAddressFrom() {
		return this.addressFrom;
	}

	public void setAddressFrom(String addressFrom) {
		this.addressFrom = addressFrom;
	}

	public String getAddressTo() {
		return this.addressTo;
	}

	public void setAddressTo(String addressTo) {
		this.addressTo = addressTo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getFinished() {
		return this.finished;
	}

	public void setFinished(Timestamp finished) {
		this.finished = finished;
	}

	public Timestamp getStarted() {
		return this.started;
	}

	public void setStarted(Timestamp started) {
		this.started = started;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Licence getLicence() {
		return this.licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}