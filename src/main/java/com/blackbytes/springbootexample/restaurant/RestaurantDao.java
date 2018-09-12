package com.blackbytes.springbootexample.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class RestaurantDao {

    @Autowired
    private RestaurantDataImport dataImport;


    public Set<String> getCuisineValues() {
        List<Restaurant> restaurants = dataImport.getListRestaurants();
        Set<String> listOfColumnValues = new TreeSet<>();
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            String newColumnElement = restaurant.getCuisine();
            listOfColumnValues.add(newColumnElement);
        }
        return listOfColumnValues;

    }

    public  Restaurant findRestaurantByID(String restaurantID){
        List<Restaurant> restaurants = dataImport.getListRestaurants();
        for(int i = 0; i < dataImport.getListRestaurants().size(); i++){
            Restaurant restaurant = restaurants.get(i);
            if(restaurant.getRestuarantID().equals(restaurantID)){
                return restaurant;
            }
        }
        return null;
    }



    public ArrayList<String> findRestaurantByCuisine(String cuisine){
        ArrayList<String> restaurantsByCuisine = new ArrayList<>();
        List<Restaurant> restaurants = dataImport.getListRestaurants();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getCuisine().equals(cuisine)) {
                restaurantsByCuisine.add(restaurants.get(i).getRestuarantID());
            }
        }
        return restaurantsByCuisine;
    }


}
