package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawer;

    private CardView cardViewJourneyPlanner,
            cardViewMyNextBus,
            cardViewLogin,
            cardViewServiceUpdates,
            cardViewFavourites,
            cardViewPlacesOfInterest,
            cardViewBestChoices,
            cardViewContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardViewJourneyPlanner=findViewById(R.id.cardView_JourneyPlanner);
        cardViewMyNextBus=findViewById(R.id.cardView_MyNextBus);
        cardViewLogin=findViewById(R.id.cardView_Login);
        cardViewServiceUpdates=findViewById(R.id.cardView_ServiceUpdates);
        cardViewFavourites=findViewById(R.id.cardView_Favourites);
        cardViewPlacesOfInterest=findViewById(R.id.cardView_PlacesOfInterest);
        cardViewBestChoices=findViewById(R.id.cardView_BestChoices);
        cardViewContactUs=findViewById(R.id.cardView_ContactUs);

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

    public void onClickCardItem(View v)
    {
        Intent i = null;
        switch (v.getId()) {
            case R.id.cardView_JourneyPlanner:
                i=new Intent(HomeActivity.this, JourneyPlannerActivity.class);
                startActivity(i);
                break;
            case R.id.cardView_MyNextBus:
                i=new Intent(HomeActivity.this, MyNextBusActivity.class);
                startActivity(i);
                break;
            case R.id.cardView_Login:
                i=new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.cardView_PlacesOfInterest:
                i=new Intent(HomeActivity.this, PlacesOfInterestActivity.class);
                startActivity(i);
                break;
            case R.id.cardView_Favourites:
                i=new Intent(HomeActivity.this, FavouritesActivity.class);
                startActivity(i);
                break;
            case R.id.cardView_BestChoices:
                i=new Intent(HomeActivity.this, NearestAccommodation.class);
                startActivity(i);
                break;
            case R.id.cardView_ContactUs:
                i=new Intent(HomeActivity.this, NearestRestaurants.class);
                startActivity(i);
                break;
            case R.id.cardView_ServiceUpdates:
                i=new Intent(HomeActivity.this, NearestHospital.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(HomeActivity.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(HomeActivity.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(HomeActivity.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(HomeActivity.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(HomeActivity.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(HomeActivity.this, HomeActivity.class);
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
