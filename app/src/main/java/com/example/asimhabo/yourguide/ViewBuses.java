package com.example.merveerdem.yourguide;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class ViewBuses extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView textTime;
    String intentHour, intentMinute, intentTime;
    int Hour, Minute;

    DatabaseHelper myDb;
    ArrayList<Schedule> scheduleList;
    ListView listView;
    Schedule schedule;

    private DrawerLayout drawer;

    String sAHour, sAMinute, sDHour, sDMinute, routeName, departureTime, arrivalTime, message, message2;
    int gapAhour, gapAminute, gapDhour, gapDminute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_buses);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        textTime = findViewById(R.id.time);
        intentHour = getIntent().getStringExtra("hour");
        intentMinute = getIntent().getStringExtra("minute");
        textTime.setText(intentHour + " " + intentMinute);

        intentTime = getIntent().getStringExtra("time");

        Hour = parseInt(intentHour);
        Minute = parseInt(intentMinute);


        myDb = new DatabaseHelper(this);
        myDb.getWritableDatabase();
        scheduleList = new ArrayList<>();
        Cursor data = myDb.getListContents();
        int numRows = data.getCount();

        if (numRows == 0) {
            Toast.makeText(ViewBuses.this, "There is nothing in database!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                routeName = data.getString(1);
                departureTime = data.getString(2);
                arrivalTime = data.getString(3);

//                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//                Date d1 = null;
//                Date d2 = null;
//
//                try {
//                    d1 = format.parse(arrivalTime);
//                    d2 = format.parse(intentTime);
//
//                    DateTime dt1 = new DateTime(d1);
//                    DateTime dt2 = new DateTime(d2);
//
//                    sAHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours ";
//                    sAMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes";
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//
//                schedule = new Schedule(routeName,sDHour + sDMinute,sAHour + sAMinute);
//                scheduleList.add(schedule);


                char c[] = arrivalTime.toCharArray();
                char hourAArray[] = new char[2];
                char minuteAArray[] = new char[2];
                int g = c.length - 1;

                hourAArray[0] = c[0];
                hourAArray[1] = c[1];
                minuteAArray[0] = c[g - 1];
                minuteAArray[1] = c[g];

                int hourAFromArray = charArrayToInt(hourAArray);
                int minuteAFromArray = charArrayToInt(minuteAArray);

                char c2[] = departureTime.toCharArray();
                char hourDArray[] = new char[2];
                char minuteDArray[] = new char[2];
                int f = c.length - 1;

                hourDArray[0] = c2[0];
                hourDArray[1] = c2[1];
                minuteDArray[0] = c2[f - 1];
                minuteDArray[1] = c2[f];

                int hourDFromArray = charArrayToInt(hourDArray);
                int minuteDFromArray = charArrayToInt(minuteDArray);

                if (Hour > hourAFromArray) {
                    //if results are minus

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    Date d1 = null;
                    Date d2 = null;

                    try {
                        d1 = format.parse(arrivalTime);
                        d2 = format.parse(intentTime);

                        DateTime dt1 = new DateTime(d1);
                        DateTime dt2 = new DateTime(d2);

                        sAHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " h ";
                        sAMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    message = sAHour + sAMinute + " before arrived";

                } else if (Hour < hourAFromArray) {
//                    gapAhour = hourAFromArray - Hour;
//                    gapAminute = minuteAFromArray - Minute;
//
//                    sAHour = Integer.toString(gapAhour);
//                    sAMinute = Integer.toString(gapAminute);

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    Date d1 = null;
                    Date d2 = null;

                    try {
                        d1 = format.parse(arrivalTime);
                        d2 = format.parse(intentTime);

                        DateTime dt1 = new DateTime(d1);
                        DateTime dt2 = new DateTime(d2);

                        sAHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " h ";
                        sAMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    message = sAHour + sAMinute + " later will arrive";
                }


//for departure time

                if (Hour > hourDFromArray) {
                    //if results are minus

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    Date d1 = null;
                    Date d2 = null;

                    try {
                        d1 = format.parse(departureTime);
                        d2 = format.parse(intentTime);

                        DateTime dt1 = new DateTime(d1);
                        DateTime dt2 = new DateTime(d2);

                        sDHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " h ";
                        sDMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    message2 = sDHour + sDMinute + " before moved";

                } else if (Hour < hourDFromArray) {
//                    gapAhour = hourAFromArray - Hour;
//                    gapAminute = minuteAFromArray - Minute;
//
//                    sAHour = Integer.toString(gapAhour);
//                    sAMinute = Integer.toString(gapAminute);

                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    Date d1 = null;
                    Date d2 = null;

                    try {
                        d1 = format.parse(departureTime);
                        d2 = format.parse(intentTime);

                        DateTime dt1 = new DateTime(d1);
                        DateTime dt2 = new DateTime(d2);

                        sDHour = Hours.hoursBetween(dt1, dt2).getHours() % 24 + " h ";
                        sDMinute = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " mn";

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    message2 = sDHour + sDMinute + " later will move";
                }


                schedule = new Schedule(routeName, message2, message);
                scheduleList.add(schedule);
            }
            TwoColumn_ListAdapter adapter = new TwoColumn_ListAdapter(this, R.layout.list_adapter_view, scheduleList);
            listView = findViewById(R.id.listview);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(ViewBuses.this, ViewStops.class);
                    i.putExtra("RouteName", scheduleList.get(position));
                    startActivity(i);
                }
            });

            listView.setAdapter(adapter);
        }


//        Cursor cursor = myDb.getDepartureTime();
//
//        int[] ret = new int[cursor.getCount()];
//
//
//        if (cursor.moveToFirst()){
//
//            int i = 0;
//            do{
//                ret[i] = Integer.parseInt(cursor.getString(0));
//                i++;
//            }while(cursor.moveToNext());
//
//        }
//        cursor.close();


    }

//    int charArrayToInt(char []data,int start,int end) throws NumberFormatException
//    {
//        int result = 0;
//        for (int i = start; i < end; i++)
//        {
//            int digit = (int)data[i] - (int)'0';
//            if ((digit < 0) || (digit > 9)) throw new NumberFormatException();
//            result *= 10;
//            result += digit;
//        }
//        return result;
//    }

    public static int charArrayToInt(char[] array) {
        int result = 0;
        int length = array.length - 1;

        for (int i = 0; i <= length; i++) {
            int digit = array[i] - '0'; //we don't want to cast by using (int)
            result *= 10;
            result += digit;
        }
        return result;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.favourites:
                Intent goFavouritesPage = new Intent(ViewBuses.this, FavouritesActivity.class);
                startActivity(goFavouritesPage);
                break;
            case R.id.placesOfInterest:
                Intent goPlacesOfInterestPage = new Intent(ViewBuses.this, PlacesOfInterestActivity.class);
                startActivity(goPlacesOfInterestPage);
                break;
            case R.id.journeyPlanner:
                Intent goJourneyPlannerPage = new Intent(ViewBuses.this, JourneyPlannerActivity.class);
                startActivity(goJourneyPlannerPage);
                break;
            case R.id.myNextBus:
                Intent goMyNextBusPage = new Intent(ViewBuses.this, MyNextBusActivity.class);
                startActivity(goMyNextBusPage);
                break;
            case R.id.contactUs:
                Intent goContactUsPage = new Intent(ViewBuses.this, ContactUsActivity.class);
                startActivity(goContactUsPage);
                break;
            case R.id.about:
                Intent goAboutPage = new Intent(ViewBuses.this, AboutActivity.class);
                startActivity(goAboutPage);
                break;
            case R.id.home:
                Intent goHomePage = new Intent(ViewBuses.this, HomeActivity.class);
                startActivity(goHomePage);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}