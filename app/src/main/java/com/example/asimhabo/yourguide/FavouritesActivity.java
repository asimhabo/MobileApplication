package com.example.merveerdem.yourguide;

import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.GetChars;

import java.lang.reflect.Array;

public class FavouritesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        Resources resources = context.getResources();

        String[] ninja = {"Naruto", "Sasuke", "Sakura", "Kakashi","Obito"};


        TypedArray ninja_icons = resources.obtainTypedArray(R.array.ninja_icons);


        setListAdapter(new ImageAndTextAdapter(context, R.layout.secondary_layout, ninja, ninja_icons));

    }

}
