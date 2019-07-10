package com.example.merveerdem.yourguide;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String routeName;
    private String departureTime;
    private String arrivalTime;
    private int id;

    public Schedule(String rName, String dTime, String aTime) {
        routeName = rName;
        departureTime = dTime;
        arrivalTime = aTime;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getId(int position) {
        return id;
    }
}