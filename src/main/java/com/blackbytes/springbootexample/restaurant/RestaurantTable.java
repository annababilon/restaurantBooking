package com.blackbytes.springbootexample.restaurant;

public class RestaurantTable {

    private String restaurantTableID;
    private int amountOfSeats;
    private String restaurantID;

    public RestaurantTable(String restaurantTableID, int amountOfSeats, String restaurantID) {
        this.restaurantTableID = restaurantTableID;
        this.amountOfSeats = amountOfSeats;
        this.restaurantID = restaurantID;
    }

    public String getRestaurantTableID() {
        return restaurantTableID;
    }

    public void setRestaurantTableID(String restaurantTableID) {
        this.restaurantTableID = restaurantTableID;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }
}
