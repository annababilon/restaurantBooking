package com.blackbytes.springbootexample.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RestaurantQuery {

    @Autowired
    private RestaurantDao restaurantDao;
    @Autowired
    private TableDao tableDao;

    public ArrayList<RestaurantTableTO> findRestaurantBy(int seatsNeeded, String cuisine) {

        ArrayList<RestaurantTableTO> restaurantByTables = this.tableDao.rightAmountOfSeatsTables(seatsNeeded, restaurantDao);

        if ("all".equals(cuisine) || cuisine == null) {
            return restaurantByTables;
        } else {
            ArrayList<RestaurantTableTO> restaurants = new ArrayList<RestaurantTableTO>();

            for(RestaurantTableTO restaurantTableTO : restaurantByTables ) {
                if (restaurantTableTO.getRestaurant().getCuisine().equals(cuisine)) {
                    restaurants.add(restaurantTableTO);
                }
            }
            return restaurants;
        }
    }
}


