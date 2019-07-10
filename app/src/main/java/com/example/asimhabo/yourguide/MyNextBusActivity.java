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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MyNextBusActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DatabaseHelper myDb;
    ArrayList<Schedule> scheduleList;
    ListView listView;
    Schedule schedule;
    Button btn, btn2;

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_next_bus);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //-----------------------------------------------------------
        myDb = new DatabaseHelper(this);
        myDb.getWritableDatabase();
        scheduleList = new ArrayList<>();
        Cursor data = myDb.getListContents();
        int numRows = data.getCount();

        if (numRows == 0){
            Toast.makeText(MyNextBusActivity.this, "There is nothing in database!", Toast.LENGTH_LONG).show();
        }
        else{
            while (data.moveToNext())
            {
                schedule = new Schedule(data.getString(1),data.getString(2),data.getString(3));
                scheduleList.add(schedule);
            }
            TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(this, R.layout.list_adapter_view,scheduleList);
            listView = findViewById(R.id.listview);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(MyNextBusActivity.this, ViewStops.class);
                    i.putExtra("RouteName", scheduleList.get(position));
                    startActivity(i);
                }
            });

            listView.setAdapter(adapter);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("HH");
                String hour = format.format(calendar.getTime());

                Calendar calendar_two = Calendar.getInstance();
                SimpleDateFormat format_two = new SimpleDateFormat("mm");
                String minute = format_two.format(calendar_two.getTime());

                Calendar calendar_time = Calendar.getInstance();
                SimpleDateFormat format_time = new SimpleDateFormat("HH:mm");
                String time = format_time.format(calendar_time.getTime());

                Intent timeIntent = new Intent(MyNextBusActivity.this, ViewBuses.class);
                timeIntent.putExtra("hour", hour);
                timeIntent.putExtra("minute", minute);
                timeIntent.putExtra("time", time);
                startActivity(timeIntent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chosenIntent = new Intent(MyNextBusActivity.this, ViewMyNextChosenBus.class);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("HH");
                String hour = format.format(calendar.getTime());

                Calendar calendar_two = Calendar.getInstance();
                SimpleDateFormat format_two = new SimpleDateFormat("mm");
                String minute = format_two.format(calendar_two.getTime());

                Calendar calendar_time = Calendar.getInstance();
                SimpleDateFormat format_time = new SimpleDateFormat("HH:mm");
                String time = format_time.format(calendar_time.getTime());

                Intent timeIntent = new Intent(MyNextBusActivity.this, ViewBuses.class);
                chosenIntent.putExtra("hour", hour);
                chosenIntent.putExtra("minute", minute);
                chosenIntent.putExtra("time", time);
                startActivity(chosenIntent);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(MyNextBusActivity.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(MyNextBusActivity.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(MyNextBusActivity.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(MyNextBusActivity.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(MyNextBusActivity.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(MyNextBusActivity.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(MyNextBusActivity.this, HomeActivity.class);
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

