package com.blackbytes.springbootexample.restaurant;

public class Restaurant {
        private String restuarantID;
        private String restaurantName;
        private String city;
        private String address;
        private String phoneNumber;
        private String establishment;
        private PriceLevel priceLevel;
        private String cuisine;
        private String photoPath;

        private RestaurantTable tables;

        public Restaurant(String restuarantID, String restaurantName, String city, String address, String phoneNumber, String establishment, PriceLevel priceLevel, String cuisine, String photoPath) {
            this.restuarantID = restuarantID;
            this.restaurantName = restaurantName;
            this.city = city;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.establishment = establishment;
            this.priceLevel = priceLevel;
            this.cuisine = cuisine;
            this.photoPath = photoPath;
        }

        public String getRestuarantID() {
            return restuarantID;
        }

        public void setRestuarantID(String restuarantID) {
            this.restuarantID = restuarantID;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEstablishment() {
            return establishment;
        }

        public void setEstablishment(String establishment) {
            this.establishment = establishment;
        }

    public PriceLevel getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(PriceLevel priceLevel) {
        this.priceLevel = priceLevel;
    }

    public RestaurantTable getTables() {
        return tables;
    }

    public void setTables(RestaurantTable tables) {
        this.tables = tables;
    }

    public String getCuisine() {
            return cuisine;
        }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }
    }


