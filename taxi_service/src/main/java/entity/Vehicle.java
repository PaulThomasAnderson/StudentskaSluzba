package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vehicle_id")
	private int vehicleId;

	private String model;

	private String status;

	private String type;

	//bi-directional many-to-one association to Ride
	@OneToMany(mappedBy="vehicle")
	private List<Ride> rides;

	//bi-directional many-to-one association to Licence
	@ManyToOne
	@JoinColumn(name="licence_id")
	private Licence licence;

	public Vehicle() {
	}

	public int getVehicleId() {
		return this.vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Ride> getRides() {
		return this.rides;
	}

	public void setRides(List<Ride> rides) {
		this.rides = rides;
	}

	public Ride addRide(Ride ride) {
		getRides().add(ride);
		ride.setVehicle(this);

		return ride;
	}

	public Ride removeRide(Ride ride) {
		getRides().remove(ride);
		ride.setVehicle(null);

		return ride;
	}

	public Licence getLicence() {
		return this.licence;
	}

	public void setLicence(Licence licence) {
		this.licence = licence;
	}

}