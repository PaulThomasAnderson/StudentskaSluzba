package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the licence database table.
 * 
 */
@Entity
@NamedQuery(name="Licence.findAll", query="SELECT l FROM Licence l")
public class Licence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="licence_id")
	private int licenceId;

	private String category;

	//bi-directional many-to-many association to Driver
	@OneToMany(mappedBy="licence")
	private List<DriverLicence> driverLicences;

	//bi-directional many-to-one association to Ride
	@OneToMany(mappedBy="licence")
	private List<Ride> rides;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="licence")
	private List<Vehicle> vehicles;

	public Licence() {
	}

	public int getLicenceId() {
		return this.licenceId;
	}

	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Ride> getRides() {
		return this.rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

	public Ride addRide(Ride ride) {
		getRides().add(ride);
		ride.setLicence(this);

		return ride;
	}

	public Ride removeRide(Ride ride) {
		getRides().remove(ride);
		ride.setLicence(null);

		return ride;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setLicence(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setLicence(null);

		return vehicle;
	}

}