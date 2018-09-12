package com.blackbytes.springbootexample.restaurant;


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;

@Service
public class RestaurantDataImport {

    private static final String FILE_PATH = "CSV/restaurant.csv";
    private List<Restaurant> listRestaurants = new ArrayList<>();

    public List<Restaurant> getListRestaurants() {
        return listRestaurants;
    }

    public RestaurantDataImport() {
        readRestaurants();
    }

    private void readRestaurants() {
        CSVReader reader = null;
        try (
                InputStream inputStream = RestaurantDataImport.class.getClassLoader().getResourceAsStream(FILE_PATH);
                Reader inputStreamReader = new InputStreamReader(inputStream, Charset.defaultCharset())
        ){
            reader = new CSVReader(inputStreamReader);
            readFile(reader);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFile(CSVReader reader) throws IOException {
        String [] nextLine;
        reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            String restuarantID = nextLine[0].trim();
            String restaurantName = nextLine[1].trim();
            String city = nextLine[2].trim();
            String address = nextLine[3].trim();
            String phoneNumber = nextLine[4].trim();
            String establishment = nextLine[5].trim();
            String price = nextLine[6].trim();
            String cuisine = nextLine[7].trim();
            String photoPath = nextLine[8].trim();

            PriceLevel priceLevel;
            try {
                priceLevel = PriceLevel.valueOf(price.toUpperCase());
            } catch (Exception e){
                priceLevel = PriceLevel.valueOf("NO_INFO");
            }

            Restaurant restaurant = new Restaurant(restuarantID, restaurantName, city, address, phoneNumber, establishment, priceLevel, cuisine, photoPath);
            listRestaurants.add(restaurant);
        }
    }
}

