package com.blackbytes.springbootexample.restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTableTO {

    private Restaurant restaurant;
    private List<RestaurantTable> tables = new ArrayList<>();


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<RestaurantTable> getTables() {
        return tables;
    }

    public void setTables(List<RestaurantTable> tables) {
        this.tables = tables;
    }
}
