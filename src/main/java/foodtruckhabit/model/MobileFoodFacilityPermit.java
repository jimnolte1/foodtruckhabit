package foodtruckhabit.model;

import lombok.Data;

/**
 * Here's our model class to represent the permits stored in the CSV file. It
 * exists essentially to fill the needs of the CSV loading library I'm using.
 * If there were more requirements in scope to do interesting things with permits,
 * it would actually be a problem domain model. And since there is no requirement to
 * do aything with dates, IDs, etc., everything is just plain <code>String</code> for
 * display, and to not have to deal with parsing errors for empty dates.
 *
 * An improvement would be to provide an all-args constructor, make all the private
 * members <code>final</code>, and get the opencvs library to use that.
 */
@Data
public class MobileFoodFacilityPermit {

	private String locationId;
	private String applicant;
	private String facilityType;
	private String cnn;
	private String locationDescription;
	private String address;
	private String blocklot;
	private String block;
	private String lot;
	private String permit;
	private String status;
	private String foodItems;
	private String x;
	private String y;
	private String latitude;
	private String longitude;
	private String schedule;
	private String dayshours;
	private String noiSent;
	private String approved;
	private String received;
	private String priorPermit;
	private String expirationDate;
	private String location;
	private String firePreventionDistricts;
	private String policeDistricts;
	private String supervisorDistricts;
	private String zipCodes;
	private String neighborhoods;
}
