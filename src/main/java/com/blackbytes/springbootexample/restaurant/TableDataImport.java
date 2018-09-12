package com.blackbytes.springbootexample.restaurant;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;

@Service
public class TableDataImport {


    private static final String FILE_PATH = "CSV/restaurant_table.csv";
    private  List<RestaurantTable> listRestaurantTables = new ArrayList<>();

    public TableDataImport() {
        try {
            readRestaurantTables();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RestaurantTable> getListRestaurantTables() {
        return listRestaurantTables;
    }




    private void readRestaurantTables() throws IOException {
        CSVReader reader = null;
        try (
                InputStream inputStream = RestaurantDataImport.class.getClassLoader().getResourceAsStream(FILE_PATH);
                Reader inputStreamReader = new InputStreamReader(inputStream, Charset.defaultCharset())
        ) {
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
            String restaurantTableID = nextLine[0].trim();
            int amountOfSeats = Integer.parseInt(nextLine[1].trim());
            String restaurantID = nextLine[2].trim() ;

            RestaurantTable restaurantTable = new RestaurantTable(restaurantTableID, amountOfSeats, restaurantID);
            listRestaurantTables.add(restaurantTable);
        }
    }
}

