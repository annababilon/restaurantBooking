package com.blackbytes.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blackbytes.springbootexample.restaurant.RestaurantDao;
import com.blackbytes.springbootexample.restaurant.RestaurantQuery;
import com.blackbytes.springbootexample.restaurant.RestaurantTableTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")

public class HelloWorldController {

    @Autowired
    private RestaurantDao restaurantDao ;

    @Autowired
    private RestaurantQuery restaurantQuery;



    @RequestMapping("/cuisines")
    public Set<String> showCuisines() throws IOException {
        Set<String> cuisineList =  restaurantDao.getCuisineValues();
        return cuisineList;
    }

    @RequestMapping("/tables")
    public ArrayList<RestaurantTableTO> listOfTables(@RequestParam(value = "numberOfSeats") int numberOfSeats, @RequestParam(value = "cuisine") String cuisine) throws IOException {
        int blabla = 1;
        return restaurantQuery.findRestaurantBy(numberOfSeats,cuisine);
    }


}