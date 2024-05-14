package foodtruckhabit.controller;

import foodtruckhabit.model.FoodTruck;
import foodtruckhabit.service.FoodTruckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foodtrucks")
@AllArgsConstructor
public class FoodTruckController {
 
    private final FoodTruckService service;

    @GetMapping
    public List<FoodTruck> getAllFoodTrucks() {

        List<FoodTruck> foodTrucks = service.getFoodTrucks();
        return foodTrucks;
    }

    @GetMapping("/{foodItem}")
    public List<FoodTruck> getFoodTrucksServing(@PathVariable String foodItem) {

        List<FoodTruck> foodTrucks = service.getFoodTrucksServing(foodItem);
        return foodTrucks;
    }

}