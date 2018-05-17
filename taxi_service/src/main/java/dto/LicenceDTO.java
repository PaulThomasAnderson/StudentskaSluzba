package dto;

import entity.Licence;

public class LicenceDTO {
	private int driverId;
	private int licenceId;
	private String category;

	public int getLicenceId() {
		return licenceId;
	}

	public void setLicenceId(int licenceId) {
		this.licenceId = licenceId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LicenceDTO(int licenceId, String category) {
		super();
		this.licenceId = licenceId;
		this.category = category;
	}
	
	public LicenceDTO(Licence licence) {
		super();
		this.licenceId = licence.getLicenceId();
		this.category = licence.getCategory();
	}

	public LicenceDTO() {
		super();
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	

}
