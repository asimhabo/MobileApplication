package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AtmPlacesOfInterest extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    HashMap<String,List<String>> Atm_category;
    List<String> Atm_list;
    ExpandableListView Exp_list;
    AccommodationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_places_of_interest);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Expandable List View
        Exp_list=findViewById(R.id.exp_list);
        Atm_category=DataProviderAtm.getInfo();
        Atm_list= new ArrayList<String >(Atm_category.keySet());
        adapter=new AccommodationAdapter(this, Atm_category, Atm_list);
        Exp_list.setAdapter(adapter);

        Exp_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(), Atm_list.get(groupPosition)+ "is expanded", Toast.LENGTH_LONG).show();
            }
        });

        Exp_list.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(), Atm_list.get(groupPosition)+ "is collapsed", Toast.LENGTH_LONG).show();
            }
        });

        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(),
                        Atm_category.get(Atm_list.get(groupPosition)).get(childPosition)+ " from category "+ Atm_list.get(groupPosition)+ "is selected",Toast.LENGTH_LONG).show();

                if (Atm_category.get(Atm_list.get(groupPosition)).get(childPosition)== "View On Map")
                {
                    Intent viewOnMap= new Intent(AtmPlacesOfInterest.this, ViewOnMapActivity.class);
                    viewOnMap.putExtra("place",Atm_list.get(groupPosition));
                    startActivity(viewOnMap);
                }

                return false;
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(AtmPlacesOfInterest.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(AtmPlacesOfInterest.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(AtmPlacesOfInterest.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(AtmPlacesOfInterest.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(AtmPlacesOfInterest.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(AtmPlacesOfInterest.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(AtmPlacesOfInterest.this, HomeActivity.class);
                startActivity(goHomePage);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

}