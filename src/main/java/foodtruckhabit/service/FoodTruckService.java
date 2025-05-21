package foodtruckhabit.service;

import foodtruckhabit.model.FoodTruck;

import java.util.List;
public interface FoodTruckService {

    List<FoodTruck> getFoodTrucks();
    List<FoodTruck> getFoodTrucksServing(String foodItem);
}
