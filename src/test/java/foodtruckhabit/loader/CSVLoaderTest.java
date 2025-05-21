package foodtruckhabit.loader;

import foodtruckhabit.config.AppConfig;
import foodtruckhabit.model.MobileFoodFacilityPermit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * JUnit for doing a super minimal test on the <code>DefaultFoodTruckService</code>, and exists as a starting point to
 * identify where (the service) and what kind (integration) of test to run. It uses JUnit 4 rather than 5, as it's been
 * some time since I put anything together on the machine I'm using, and updating the versions didn't
 * seem like a must-have for the time budget. Given more time, going to JUnit 5 and adding a more tests, including
 * non-happy path, would be a good place to start. Time spent testing is ALLWAYS time saved in the long run.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CSVLoaderTest {
/* Header
	locationid,Applicant,FacilityType,cnn,LocationDescription,Address,blocklot,block,lot,permit,Status,FoodItems,X,Y,Latitude,Longitude,Schedule,dayshours,NOISent,Approved,Received,PriorPermit,ExpirationDate,Location,Fire Prevention Districts,Police Districts,
	Supervisor Districts,Zip Codes,Neighborhoods (old)
   Data
	735318,Ziaurehman Amini,Push Cart,30727000,MARKET ST: DRUMM ST intersection,5 THE EMBARCADERO,0234017,0234,017,15MFF-0159,REQUESTED,,6013916.72,2117244.027,37.794331003246846,-122.39581105302317,http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=15MFF-0159&ExportPDF=1&Filename=15MFF-0159_schedule.pdf,,,,20151231,0,03/15/2016 12:00:00 AM,"(37.794331003246846, -122.39581105302317)",4,1,
	10,28855,6
	1750864,TING TING MINI MOBILE DELI,Truck,6792000,HAWES ST: SHAFTER AVE to THOMAS AVE (1500 - 1599),1153 SHAFTER AVE,4793006,4793,006,23MFF-00054,APPROVED,Cold Truck: Pre-packaged sandwiches: snacks: fruit: various beverages,6017053.425,2092471.602,37.72648516321647,-122.38323245870731,http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=23MFF-00054&ExportPDF=1&Filename=23MFF-00054_schedule.pdf,,,03/28/2024 12:00:00 AM,20231229,1,11/15/2024 12:00:00 AM,"(37.72648516321647, -122.38323245870731)",10,3,
	8,58,1
 */
	private static final int NUM_DATA_ROWS = 481;
	private static final String LOCATION_ID_FIRST = "735318";
	private static final String APPLICANT_FIRST = "Ziaurehman Amini";
	private static final String FACILITY_TYPE_FIRST = "Push Cart";
	private static final String SUPERVISOR_DISTRICTS_FIRST 	= "10";
	private static final String ZIP_CODES_FIRST 	= "28855";
	private static final String NEIGHBORHOODS_FIRST = "6";
	private static final String LOCATION_ID_LAST = "1750864";
	private static final String APPLICANT_LAST = "TING TING MINI MOBILE DELI";
	private static final String FACILITY_TYPE_LAST = "Truck";
	private static final String SUPERVISOR_DISTRICTS_LAST 	= "10";
	private static final String ZIP_CODES_LAST 	= "28855";
	private static final String NEIGHBORHOODS_LAST = "6";

	@Autowired
	private CSVLoader<MobileFoodFacilityPermit> permitsLoader;

	@Test
	public void loadPermitsWhenAllOK() {

		List<MobileFoodFacilityPermit> permits = permitsLoader.loadFromCSV();
		assertEquals("Wrong number of Permits!", NUM_DATA_ROWS, permits.size());

		MobileFoodFacilityPermit first = permits.get(0);
		MobileFoodFacilityPermit last = permits.get(NUM_DATA_ROWS - 1);

		assertEquals("Wrong first location id!", LOCATION_ID_FIRST, first.getLocationId());
		assertEquals("Wrong first applicant!", APPLICANT_FIRST, first.getApplicant());
		assertEquals("Wrong first facility type!", FACILITY_TYPE_FIRST,first.getFacilityType());
		assertEquals("Wrong last location id!", LOCATION_ID_LAST, last.getLocationId());
		assertEquals("Wrong last applicant!", APPLICANT_LAST, last.getApplicant());
		assertEquals("Wrong last facility type!", FACILITY_TYPE_LAST, last.getFacilityType());

		assertEquals("Wrong first supervisor districts!", SUPERVISOR_DISTRICTS_FIRST, first.getSupervisorDistricts());
		assertEquals("Wrong first zip codes!", ZIP_CODES_FIRST, first.getZipCodes());
		assertEquals("Wrong first neighborhoods!", NEIGHBORHOODS_FIRST,first.getNeighborhoods());
		assertEquals("Wrong last supervisor districts!", SUPERVISOR_DISTRICTS_LAST, first.getSupervisorDistricts());
		assertEquals("Wrong last zip codes!", ZIP_CODES_LAST, first.getZipCodes());
		assertEquals("Wrong last neighborhoods!", NEIGHBORHOODS_LAST,first.getNeighborhoods());
	}
}