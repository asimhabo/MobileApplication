package com.example.merveerdem.yourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NineRow_ListAdapter extends ArrayAdapter<Route> {

    private LayoutInflater mInflater2;
    private ArrayList<Route> routes;
    private int mViewResourceId2;

    public NineRow_ListAdapter(Context context, int textViewResourceId, ArrayList<Route> routes)
    {
        super(context,textViewResourceId,routes);
        this.routes = routes;
        mInflater2 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId2 = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents)
    {
        convertView = mInflater2.inflate(mViewResourceId2,null);

        Route route = routes.get(position);

        if (route != null)
        {
            TextView routeName = (TextView) convertView.findViewById(R.id.routeName);
            TextView description = (TextView) convertView.findViewById(R.id.textDescription);
            TextView stopOne = (TextView) convertView.findViewById(R.id.textStopOne);
            TextView stopTwo = (TextView) convertView.findViewById(R.id.textStopTwo);
            TextView stopThree = (TextView) convertView.findViewById(R.id.textStopThree);
            TextView stopFour = (TextView) convertView.findViewById(R.id.textStopFour);
            TextView stopFive = (TextView) convertView.findViewById(R.id.textStopFive);
            TextView stopSix = (TextView) convertView.findViewById(R.id.textStopSix);
            TextView stopSeven = (TextView) convertView.findViewById(R.id.textStopSeven);

            if (routeName != null){
                routeName.setText(route.getRouteName());
            }
            if (description != null){
                description.setText(route.getDescription());
            }
            if (stopOne != null){
                stopOne.setText(route.getStop1());
            }
            if (stopTwo != null){
                stopTwo.setText(route.getStop2());
            }
            if (stopThree != null){
                stopThree.setText(route.getStop3());
            }
            if (stopFour != null){
                stopFour.setText(route.getStop4());
            }
            if (stopFive != null){
                stopFive.setText(route.getStop5());
            }
            if (stopSix != null){
                stopSix.setText(route.getStop6());
            }
            if (stopSeven != null){
                stopSeven.setText(route.getStop7());
            }

        }
        return convertView;
    }

}