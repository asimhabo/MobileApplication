package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderCinema {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("Cityplex Sinemalari", details);
        places.put("Onel Sinemasi", details);
        places.put("Safranbolu Atamerkez Sinemalari", details);

        return places;
    }

}
