package idc.beker.idan.idcfreefood.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

import idc.beker.idan.idcfreefood.data.FoodEvent;

/**
 * This is supposed to be the service class which will update the information. #IdanBeker
 */
public class FoodEventsService {

    private static String sampleData ="";


    public FoodEventsService() {
    }

    /**
     * This is supposed to be the function which reads data from a server and builds a data structure of our data. #IdanBeker
     *
     * @param data File.
     *
     * @return an Array of events.
     */
    public FoodEvent[] refreshEvents(File data){


        FoodEvent[] foodEvents = {new FoodEvent( 1 ,"Coffee event") , new FoodEvent( 2 ,"sandwichEvent"),
                new FoodEvent( 3 ,"Special event"), new FoodEvent( 4 ,"def event"), new FoodEvent( 1 , "Another coffee event"),
                new FoodEvent( 5, "Dedfault event")
        };

        return foodEvents;


    }
}
