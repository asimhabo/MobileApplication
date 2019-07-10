package com.example.merveerdem.yourguide;

public class Route {
    private int id;
    private String routeName;
    private String description;
    private String stop1;
    private String stop2;
    private String stop3;
    private String stop4;
    private String stop5;
    private String stop6;
    private String stop7;

    public Route(String routeName, String description, String stop1, String stop2, String stop3, String stop4, String stop5, String stop6, String stop7) {
        this.routeName = routeName;
        this.description = description;
        this.stop1 = stop1;
        this.stop2 = stop2;
        this.stop3 = stop3;
        this.stop4 = stop4;
        this.stop5 = stop5;
        this.stop6 = stop6;
        this.stop7 = stop7;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStop1() {
        return stop1;
    }

    public void setStop1(String stop1) {
        this.stop1 = stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public void setStop2(String stop2) {
        this.stop2 = stop2;
    }

    public String getStop3() {
        return stop3;
    }

    public void setStop3(String stop3) {
        this.stop3 = stop3;
    }

    public String getStop4() {
        return stop4;
    }

    public void setStop4(String stop4) {
        this.stop4 = stop4;
    }

    public String getStop5() {
        return stop5;
    }

    public void setStop5(String stop5) {
        this.stop5 = stop5;
    }

    public String getStop6() {
        return stop6;
    }

    public void setStop6(String stop6) {
        this.stop6 = stop6;
    }

    public String getStop7() {
        return stop7;
    }

    public void setStop7(String stop7) {
        this.stop7 = stop7;
    }
}

