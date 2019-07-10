package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class PlacesOfInterestActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    private CardView cardViewAccommodation,
            cardViewAtm,
            cardViewAvm,
            cardViewCinemas,
            cardViewHospitals,
            cardViewLanguageSchools,
            cardViewRestaurants,
            cardViewSports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_of_interest);

        cardViewAccommodation=findViewById(R.id.cardView_Accommodation);
        cardViewAtm=findViewById(R.id.cardView_atm);
        cardViewAvm=findViewById(R.id.cardView_avm);
        cardViewCinemas=findViewById(R.id.cardView_cinemas);
        cardViewHospitals=findViewById(R.id.cardView_hospitals);
        cardViewLanguageSchools=findViewById(R.id.cardView_languageSchools);
        cardViewRestaurants=findViewById(R.id.cardView_restaurants);
        cardViewSports=findViewById(R.id.cardView_sports);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    public void onClickCard(View v)
    {
        Intent i = null;
        switch (v.getId()) {
            case R.id.cardView_Accommodation:
                i=new Intent(PlacesOfInterestActivity.this, AccommodationPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_atm:
                i=new Intent(PlacesOfInterestActivity.this, AtmPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_avm:
                i=new Intent(PlacesOfInterestActivity.this, AvmPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_cinemas:
                i=new Intent(PlacesOfInterestActivity.this, CinemaPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_hospitals:
                i=new Intent(PlacesOfInterestActivity.this, HospitalPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_languageSchools:
                i=new Intent(PlacesOfInterestActivity.this, LanguageSchoolPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_restaurants:
                i=new Intent(PlacesOfInterestActivity.this, RestaurantPlacesOfInterest.class);
                startActivity(i);
                break;
            case R.id.cardView_sports:
                i=new Intent(PlacesOfInterestActivity.this, GymPlacesOfInterest.class);
                startActivity(i);
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(PlacesOfInterestActivity.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(PlacesOfInterestActivity.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(PlacesOfInterestActivity.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(PlacesOfInterestActivity.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(PlacesOfInterestActivity.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(PlacesOfInterestActivity.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(PlacesOfInterestActivity.this, HomeActivity.class);
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

