package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.database.Cursor;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewStops extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private Schedule schedule;
    private String rName;

    DatabaseHelper myDb2;
    ArrayList<Route> routeList;
    ListView listView2;
    Route route;

   // Button btn_showRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stops);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //---------------------------------------------------------

        //btn_showRoute = findViewById(R.id.btn_ShowRoute);

        Intent intent= getIntent();
        schedule = (Schedule) intent.getSerializableExtra("RouteName");
        rName = schedule.getRouteName();

        myDb2 = new DatabaseHelper(this);
        myDb2.getWritableDatabase();
        routeList = new ArrayList<>();
        Cursor data = myDb2.getRouteValues(rName);
        int numRows = data.getCount();

        if (numRows == 0){
            Toast.makeText(ViewStops.this, "There is nothing in database!", Toast.LENGTH_LONG).show();
        }
        else{
            while (data.moveToNext())
            {
                route = new Route(data.getString(1),data.getString(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7),data.getString(8),data.getString(9));
                routeList.add(route);
            }
            NineRow_ListAdapter adapter2 = new NineRow_ListAdapter(this, R.layout.list_adapter_view_two,routeList);
            listView2 = findViewById(R.id.listview2);
            listView2.setAdapter(adapter2);
        }

        //System.out.println("**********************************" + schedule.getRouteName());

//        btn_showRoute.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i;
//                if(rName == "78U")
//                {
//                i = new Intent(ViewStops.this, routeOfStations.class);
//                startActivity(i);
//                }
//          }
//      });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(ViewStops.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(ViewStops.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(ViewStops.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(ViewStops.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(ViewStops.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(ViewStops.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(ViewStops.this, HomeActivity.class);
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
