package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@NamedQuery(name="Driver.findAll", query="SELECT d FROM Driver d")
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="driver_id")
	private int driverId;

	private int age;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@OneToMany(mappedBy="driver", fetch = FetchType.EAGER)
	private List<DriverLicence> driverLicences;

	//bi-directional many-to-one association to Ride
	@OneToMany(mappedBy="driver")
	private List<Ride> rides;

	public Driver() {
	}

	public int getDriverId() {
		return this.driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Ride> getRides() {
		return this.rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

	public Ride addRide(Ride ride) {
		getRides().add(ride);
		ride.setDriver(this);

		return ride;
	}

	public Ride removeRide(Ride ride) {
		getRides().remove(ride);
		ride.setDriver(null);

		return ride;
	}

	public List<DriverLicence> getDriverLicences() {
		return driverLicences;
	}

	public void setDriverLicences(List<DriverLicence> driverLicences) {
		this.driverLicences = driverLicences;
	}
	
	

}