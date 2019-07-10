package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProvider {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("Altın Kalem Öğrenci Yurdu", details);
        places.put("Öztekinler Kız Öğrenci Yurdu", details);
        places.put("Ebik Kız Öğrenci Yurdu (M.E.B)", details);
        places.put("Aslantepe Kız Öğrenci Yurdu", details);
        places.put("Özel Safranbolu Yamakoğlu Yüksek Öğretim Kız Öğrenci Yurdu", details);
        places.put("Kyk Karabük Üniversitesi Ögrenci Yurdu", details);
        places.put("Karakoç Erkek Ögrenci Yurdu", details);
        places.put("Dilekyurt Karabük Kız Yurdu", details);
        places.put("Oktay Erkek Öğrenci Yurt/Pansiyon", details);

        return places;
    }

}
