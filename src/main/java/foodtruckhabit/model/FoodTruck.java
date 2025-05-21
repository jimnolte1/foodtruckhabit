package foodtruckhabit.model;

import lombok.Data;

@Data
public class FoodTruck {

	private String locationId;
	private String applicant;
	private String facilityType;
	private String locationDescription;
	private String address;
	private String blocklot;
	private String block;
	private String lot;
	private String status;
	private String foodItems;
	private String latitude;
	private String longitude;
	private String schedule;
	private String dayshours;
	private String approved;
	private String location;

	public FoodTruck(MobileFoodFacilityPermit permit) {
		this.address = permit.getAddress();
		this.applicant = permit.getApplicant();
		this.approved = permit.getApproved();
		this.dayshours = permit.getDayshours();
		this.block = permit.getBlock();
		this.blocklot = permit.getBlocklot();
		this.facilityType = permit.getFacilityType();
		this.foodItems = permit.getFoodItems();
		this.latitude = permit.getLatitude();
		this.location = permit.getLocation();
		this.locationDescription = permit.getLongitude();
		this.locationId = permit.getLocationId();
		this.lot = permit.getLot();
		this.schedule = permit.getSchedule();
		this.status = permit.getStatus();
	}
}
