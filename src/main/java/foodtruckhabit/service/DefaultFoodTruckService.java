package foodtruckhabit.service;

import foodtruckhabit.loader.CSVLoader;
import foodtruckhabit.model.FoodTruck;
import foodtruckhabit.model.MobileFoodFacilityPermit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultFoodTruckService implements FoodTruckService {

    // Package visibility for tests. If we get many more of these let's make them enums...
    static final String STATUS_APPROVED = "APPROVED";
    static final String STATUS_ISSUED = "ISSUED";
    static final String FACILITY_TYPE_TRUCK = "Truck";
    private List<FoodTruck> foodTrucks = new ArrayList<>();
    private final CSVLoader<MobileFoodFacilityPermit> permitsLoader;

    /**
     * Returns all food trucks. This makes an assumption that only facility type
     * "Truck" with status "APPROVED" or "ISSUED" qualify as something we want
     * to see. With more time in budget I would add methods that take a status
     * and/or statuses.Also with time in budget I'd make the synchronization
     * approach less klugy.
     *
     * Style note: Some folks prefer to explicitly refer to private members using
     * <code>this.</code>, myself being one of them, as a form of documentation
     * for someone reading the code without the benefit of an IDE. I've left that
     * out intentionally for the sake of brevity.
     *
     * @return the list of <code>FoodTruck</code> that the service will have
     * access to for its run lifelime
     */
    @Override
    public List<FoodTruck> getFoodTrucks() {

        if (foodTrucks.isEmpty()) {
            synchronized (foodTrucks) {
                foodTrucks = populateFoodTrucks();
            }
        }
        return foodTrucks;
    }

    /**
     * Returns all food trucks that serve the requested food item, ignoring
     * case.
     *
     * This match is hyper-rudimentary. Given more time in budget we would at
     * least want a word match against the <code>foodItems</code> property, and
     * could get much more elaborate from there, allowing multiple terms,
     * correcting for misspellings, etc. I won't belabor the point.
     *
     * @return the list of <code>FoodTruck</code> that the service will have
     * access to for its run lifelime that serve a particular food item
     */
    @Override
    public List<FoodTruck> getFoodTrucksServing(String foodItem) {

        List<FoodTruck> foodTrucks = getFoodTrucks();

        if (foodItem != null) {
            return foodTrucks.stream()
                    .filter(f -> (f.getFoodItems() != null &&
                            f.getFoodItems().toUpperCase().contains(foodItem.toUpperCase())))
                    .collect(Collectors.toList());
        }
        else {
            return null;
        }
    }

    private List<FoodTruck> populateFoodTrucks() {

        List<FoodTruck> trucks = new ArrayList<>();
        List<MobileFoodFacilityPermit> permits = permitsLoader.loadFromCSV()
                .stream()
                .filter(f -> FACILITY_TYPE_TRUCK.equals(f.getFacilityType()) &&
                        STATUS_APPROVED.equals(f.getStatus()) || STATUS_ISSUED.equals(f.getStatus()))
                .collect(Collectors.toList());

        permits.forEach(p -> {
            trucks.add(new FoodTruck(p));
        });
        return trucks;
    }
}
