package foodtruckhabit.service;

import foodtruckhabit.config.AppConfig;
import foodtruckhabit.model.FoodTruck;
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
public class DefaultFoodTruckServiceTest {
	private static final int NUM_FOOD_TRUCKS = 200;
	private static final int NUM_FOOD_TRUCKS_SERVING_CORN_DOGS = 7;
	private static final String CORN_DOGS = "corn dog";

	@Autowired
	private FoodTruckService service;

	@Test
	public void getFoodTrucksWhenAllOK() {

		List<FoodTruck> trucks = service.getFoodTrucks();
		assertEquals("Wrong number of Trucks!", NUM_FOOD_TRUCKS, trucks.size());
	}

	@Test
	public void getFoodTrucksServingCornDogsWhenAllOK() {

		List<FoodTruck> trucks = service.getFoodTrucksServing(CORN_DOGS);
		assertEquals("Wrong number of Trucks Serving " + CORN_DOGS + "!", NUM_FOOD_TRUCKS_SERVING_CORN_DOGS, trucks.size());
	}
}