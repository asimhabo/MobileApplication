package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderRestaurant {
    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("Domino's Pizza Karabük", details);
        places.put("Hacioglu Karabük", details);
        places.put("Myor Cafe & Restaurant", details);
        places.put("Takaa Et & Balik", details);
        places.put("Hacibaba Dürümce Karabük Üniversitesi", details);
        places.put("keyfince cafe &restaurant Karabük", details);
        places.put("Güven Kösk", details);
        places.put("Derya Restaurant Karabük", details);
        places.put("Kılcıoğlu Pide Karabük", details);
        return places;
    }
}
