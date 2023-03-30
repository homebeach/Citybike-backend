package com.citybike;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Journey {
    @Id
    private Date Departure_time;
    private Date Return_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_station_id")
    private Station Departure_station;
    private String Departure_station_name;

    public void setReturn_station(Station return_station) {
        Return_station = return_station;
    }

    @OneToOne
    @JoinColumn(name = "return_station_id", referencedColumnName = "id")
    private Station Return_station;
    private String Return_station_name;
    private int Duration;
    private int Covered_distance;

    public int getCovered_distance() {
        return Covered_distance;
    }

    public void setCovered_distance(int covered_distance) {
        Covered_distance = covered_distance;
    }

    public Date getDeparture_time() {
        return Departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        Departure_time = departure_time;
    }

    public Date getReturn_time() {
        return Return_time;
    }

    public void setReturn_time(Date return_time) {
        Return_time = return_time;
    }

    public Station getDeparture_station() {
        return Departure_station;
    }

    public void setDeparture_station(Station departure_station) {
        Departure_station = departure_station;
    }

    public String getDeparture_station_name() {
        return Departure_station_name;
    }

    public void setDeparture_station_name(String departure_station_name) {
        Departure_station_name = departure_station_name;
    }

    public Station getReturn_station() {
        return Return_station;
    }

    public String getReturn_station_name() {
        return Return_station_name;
    }

    public void setReturn_station_name(String return_station_name) {
        Return_station_name = return_station_name;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

}