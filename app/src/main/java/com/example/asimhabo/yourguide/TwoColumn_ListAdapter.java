package com.example.merveerdem.yourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoColumn_ListAdapter extends ArrayAdapter<Schedule> {

    private LayoutInflater mInflater;
    private ArrayList<Schedule> schedules;
    private int mViewResourceId;

    public TwoColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<Schedule> schedules) {
        super(context, textViewResourceId, schedules);
        this.schedules = schedules;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Schedule schedule = schedules.get(position);

        if (schedule != null) {
            TextView routeName = (TextView) convertView.findViewById(R.id.textRouteName);
            TextView departureTime = (TextView) convertView.findViewById(R.id.textDTime);
            TextView arrivalTime = (TextView) convertView.findViewById(R.id.textATime);

            if (routeName != null) {
                routeName.setText(schedule.getRouteName());
            }
            if (departureTime != null) {
                departureTime.setText(schedule.getDepartureTime());
            }
            if (arrivalTime != null) {
                arrivalTime.setText(schedule.getArrivalTime());
            }

        }
        return convertView;
    }
}

