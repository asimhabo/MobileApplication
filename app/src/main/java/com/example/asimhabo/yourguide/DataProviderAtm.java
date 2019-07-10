package com.example.merveerdem.yourguide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderAtm {

    public static HashMap<String, List<String>> getInfo()
    {
        HashMap<String, List<String>> places= new HashMap<String, List<String>>();
        List<String> details= new ArrayList<String>();
        details.add("Save to Favourites");
        details.add("View On Map");
        details.add("Plan Journey to Here");


        places.put("Albaraka Türk - Karabük Şubesi", details);
        places.put("Türkiye Finans Karabük Şubesi", details);
        places.put("Garanti Bankası Karabük Şubesi", details);
        places.put("Yapı Kredi Bankası - Karabük Şubesi", details);
        places.put("Sekerbank Karabük Medikar Hastanesi Atm", details);
        places.put("Türkiye İş Bankası Atm-karabük Şubesi", details);
        places.put("Şekerbank Karabük ATM", details);
        places.put("Albaraka Türk - Safranbolu ATM", details);
        places.put("Yapi Kredi Karabük 5000 Evler ATM", details);

        return places;
    }

}