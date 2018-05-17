package dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import entity.Driver;

public class DriverDTO {
	private int id;
	@Size(min = 2)
	private String firstName;
	@Size(min = 2)
	private String lastName;
	@NotNull
	private Integer age;
	
	private List<LicenceDTO> licences;
	
	private List<RideDTO> rides;
	
	public DriverDTO() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	
	public DriverDTO(Driver driver) {
		this.id = driver.getDriverId();
		this.firstName = driver.getFirstName();
		this.lastName = driver.getLastName();
		this.age = driver.getAge();
		this.licences = driver.getDriverLicences()
				.stream()
				.map(x -> new LicenceDTO(x.getLicence()))
				.collect(Collectors.toList());
		//this.rides = driver.getRides().stream().map(x -> new RideDTO(x)).collect(Collectors.toList());
	}


	public DriverDTO(int id, String firstName, String lastName, Integer age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public List<LicenceDTO> getLicences() {
		return licences;
	}


	public void setLicences(List<LicenceDTO> licences) {
		this.licences = licences;
	}


	public List<RideDTO> getRides() {
		return rides;
	}


	public void setRides(List<RideDTO> rides) {
		this.rides = rides;
	}
	
	
}
