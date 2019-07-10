package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.database.Cursor;
import android.provider.Settings;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import java.security.SecurityPermission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class ViewMyNextChosenBus extends AppCompatActivity implements AdapterView.OnItemSelectedListener,NavigationView.OnNavigationItemSelectedListener {

    Spinner spinner2;
    String text, t, stop;
    Button btn;

    DatabaseHelper myDb;
    ArrayList<Schedule> scheduleList;
    ListView listView;
    Schedule schedule;

    private DrawerLayout drawer;

    String sDHour, sDMinute, routeName, departureTime, message, message2;

    String intentHour, intentMinute, intentTime;
    int Hour, Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_next_chosen_bus);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        myDb = new DatabaseHelper(this);

        intentHour = getIntent().getStringExtra("hour");
        intentMinute = getIntent().getStringExtra("minute");
        intentTime = getIntent().getStringExtra("time");

        Hour = parseInt(intentHour);
        Minute = parseInt(intentMinute);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.route_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setVisibility(View.GONE);



        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(text + t + stop + "..........");
                //right the staff here

                myDb.getWritableDatabase();
                scheduleList = new ArrayList<>();
                Cursor data = myDb.getStopValues(text,stop);
                int numRows = data.getCount();

                if (numRows == 0){
                    Toast.makeText(ViewMyNextChosenBus.this, "There is nothing in database!", Toast.LENGTH_LONG).show();
                }
                else{
                    while (data.moveToNext())
                    {
                        departureTime = data.getString(2);
                        System.out.println(departureTime + " /////////////////");

                        char c2[] = departureTime.toCharArray();
                        char hourDArray[] = new char[2];
                        char minuteDArray[] = new char[2];
                        int f = c2.length-1;

                        minuteDArray[0]=c2[f-1];
                        minuteDArray[1]=c2[f];

                        int hourDFromArray = charArrayToInt(hourDArray);
                        int minuteDFromArray = charArrayToInt(minuteDArray);

                        if (Hour < hourDFromArray) {
                            //if results are minus

                            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                            Date d1 = null;
                            Date d2 = null;

                            try {
                                d1 = format.parse(departureTime);
                                d2 = format.parse(intentTime);

                                DateTime dt1 = new DateTime(d1);
                                DateTime dt2 = new DateTime(d2);

                                sDHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hr ";
                                sDMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                                System.out.println( sDHour + " " + sDMinute + " /////////////////");

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            message2 = sDHour + sDMinute + " before passed";

                        }else{

                            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                            Date d1 = null;
                            Date d2 = null;

                            try {
                                d1 = format.parse(departureTime);
                                d2 = format.parse(intentTime);

                                DateTime dt1 = new DateTime(d1);
                                DateTime dt2 = new DateTime(d2);

                                sDHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hr ";
                                sDMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            message2 = sDHour + sDMinute + " later will arrive";
                        }


                        schedule = new Schedule(data.getString(1),data.getString(2),message2);
                        scheduleList.add(schedule);
                    }
                    TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(ViewMyNextChosenBus.this, R.layout.list_adapter_view,scheduleList);
                    listView = findViewById(R.id.listview);

                    listView.setAdapter(adapter);
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        text = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        spinner2.setVisibility(View.GONE);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                t = parent.getItemAtPosition(position).toString();
                //System.out.println(t + "123123123123123123");
                if (t == parent.getItemAtPosition(0))
                    stop = "ONESTOP";
                else if (t == parent.getItemAtPosition(1))
                    stop = "TWOSTOP";
                else if (t == parent.getItemAtPosition(2))
                    stop = "THREESTOP";
                else if (t == parent.getItemAtPosition(3))
                    stop = "FOURSTOP";
                else if (t == parent.getItemAtPosition(4))
                    stop = "FIVESTOP";
                else if (t == parent.getItemAtPosition(5))
                    stop = "SIXSTOP";
                else if (t == parent.getItemAtPosition(6))
                    stop = "SEVENSTOP";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (text == parent.getItemAtPosition(0)){
            spinner2.setVisibility(View.VISIBLE);

            ArrayAdapter<CharSequence> adapterfirst = ArrayAdapter.createFromResource(this,R.array.first_stops,android.R.layout.simple_spinner_item);
            adapterfirst.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterfirst);

        }
        else if (text == parent.getItemAtPosition(1)){
            spinner2.setVisibility(View.VISIBLE);

            ArrayAdapter<CharSequence> adaptersecond = ArrayAdapter.createFromResource(this,R.array.second_stops,android.R.layout.simple_spinner_item);
            adaptersecond.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adaptersecond);

        }
        else if (text == parent.getItemAtPosition(2)){
            spinner2.setVisibility(View.VISIBLE);

            ArrayAdapter<CharSequence> adapterthird = ArrayAdapter.createFromResource(this,R.array.third_stops,android.R.layout.simple_spinner_item);
            adapterthird.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterthird);

        }
        else if (text == parent.getItemAtPosition(3)){
            spinner2.setVisibility(View.VISIBLE);

            ArrayAdapter<CharSequence> adapterfourth = ArrayAdapter.createFromResource(this,R.array.fourth_stops,android.R.layout.simple_spinner_item);
            adapterfourth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapterfourth);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public static int charArrayToInt(char[] array){
        int result = 0;
        int length = array.length - 1;

        for (int i = 0; i <= length; i++)
        {
            int digit = array[i] - '0'; //we don't want to cast by using (int)
            result *= 10;
            result += digit;
        }
        return result;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(ViewMyNextChosenBus.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(ViewMyNextChosenBus.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(ViewMyNextChosenBus.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(ViewMyNextChosenBus.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(ViewMyNextChosenBus.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(ViewMyNextChosenBus.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(ViewMyNextChosenBus.this, HomeActivity.class);
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
