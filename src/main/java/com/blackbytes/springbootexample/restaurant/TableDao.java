package com.blackbytes.springbootexample.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TableDao {

    @Autowired
    private TableDataImport dataImport;


    public ArrayList<RestaurantTableTO> rightAmountOfSeatsTables(int seatsNeeded, RestaurantDao restaurantDao){
        List<RestaurantTable> restaurantTables = dataImport.getListRestaurantTables();
        Map<String, RestaurantTableTO> resultMap = new HashMap<>();

        for(int i = 0; i < restaurantTables.size(); i++){
            RestaurantTable table = restaurantTables.get(i);
            if (table.getAmountOfSeats() >= seatsNeeded){
                String restaurant_id = table.getRestaurantID();
                RestaurantTableTO restaurantTablesContainer = resultMap.get(restaurant_id);
                if(restaurantTablesContainer == null) {
                    restaurantTablesContainer = new RestaurantTableTO();
                    restaurantTablesContainer.setRestaurant(restaurantDao.findRestaurantByID(restaurant_id));
                    resultMap.put(restaurant_id, restaurantTablesContainer);
                }
                restaurantTablesContainer.getTables().add(table);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
}
