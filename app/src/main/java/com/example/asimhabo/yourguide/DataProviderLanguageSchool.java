package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderLanguageSchool {
    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("American Time Mustafa Sarikaya", details);
        places.put("American LIFE Karabük", details);
        places.put("Karabük Üniversitesi Yabanci Diller Yüksekokulu - Karabuk University School of Foreign Languages", details);
        return places;
    }
}
