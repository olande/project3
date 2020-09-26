package com.example.waste;

public class Hero {
    String userid,location,complaints,time,binno;

    public Hero(String complaints, String time, String userid,String binno, String location) {
        this.userid = userid;
        this.location = location;
        this.complaints = complaints;
        this.binno=binno;
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public String getLocation()
    {
        return location;
    }

    public String getComplaints() {
        return complaints;
    }


    public  String getBinno(){return binno;}

    public String getTime() {
        return time;
    }
}
