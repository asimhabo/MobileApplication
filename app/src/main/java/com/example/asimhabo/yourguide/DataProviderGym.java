package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderGym {
    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");

        places.put("Esform Fitness&Wellness Club", details);
        places.put("Sevinc Spor Merkezi", details);
        places.put("Çebioglu Aura Fitness & Spa", details);
        places.put("Dr. Necmettin Seyhoglu Stadyumu", details);
        places.put("Yenisehir Kapali Spor Salonu", details);
        places.put("Karabuk Yeni Merkez Spor Salonu", details);
        places.put("Karabük Merkez Spor Salonu 2", details);
        return places;
    }

}
