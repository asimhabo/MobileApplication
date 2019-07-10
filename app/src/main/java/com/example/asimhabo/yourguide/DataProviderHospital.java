package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderHospital {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("Karabük Egitim Ve Arastirma Hastanesi", details);
        places.put("Özel Medikar Hastanesi", details);
        places.put("Safranbolu Devlet Hastanesi", details);
        places.put("Karabük Ağız Ve Diş Sağlığı Hastanesi", details);
        places.put("Özel Vatan Hastanesi Acil Servis", details);

        return places;
    }
}
