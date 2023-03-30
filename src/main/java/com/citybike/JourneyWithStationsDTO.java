package com.citybike;

import java.math.BigDecimal;
import java.util.Date;

public class JourneyWithStationsDTO {
    private Date Departure_time;
    private Date Return_time;
    private int Duration;
    private int Covered_distance;
    private Long Departure_station_id;

    private Integer Departure_station_fid;

    private String Departure_station_nimi;

    private String Departure_station_namn;

    private String Departure_station_name;

    private String Departure_station_osoite;

    private String Departure_station_address;

    private String Departure_station_kaupunki;

    private String Departure_station_stad;

    private String Departure_station_operaattori;

    private Integer Departure_station_kapasiteetti;

    private BigDecimal Departure_station_x;

    private BigDecimal Departure_station_y;

    private Long Return_station_id;

    private Integer Return_station_fid;

    private String Return_station_nimi;

    private String Return_station_namn;

    private String Return_station_name;

    private String Return_station_osoite;

    private String Return_station_address;

    private String Return_station_kaupunki;

    private String Return_station_stad;

    private String Return_station_operaattori;

    private Integer Return_station_kapasiteetti;

    private BigDecimal Return_station_x;

    private BigDecimal Return_station_y;

    public JourneyWithStationsDTO() {

    }

    public JourneyWithStationsDTO(Journey journey) {

        Departure_time = journey.getDeparture_time();
        Return_time = journey.getReturn_time();
        Duration = journey.getDuration();
        Covered_distance = journey.getCovered_distance();

        Station departure_station = journey.getDeparture_station();
        Station return_station = journey.getReturn_station();

        if(departure_station != null) {
            Departure_station_id = departure_station.getId();
            Departure_station_fid = departure_station.getFid();
            Departure_station_nimi = departure_station.getNimi();
            Departure_station_namn = departure_station.getNamn();
            Departure_station_name = departure_station.getName();
            Departure_station_osoite = departure_station.getOsoite();
            Departure_station_address = departure_station.getAddress();
            Departure_station_kaupunki = departure_station.getKaupunki();
            Departure_station_stad = departure_station.getStad();
            Departure_station_operaattori = departure_station.getOperaattori();
            Departure_station_kapasiteetti = departure_station.getKapasiteetti();
            Departure_station_x = departure_station.getX();
            Departure_station_y = departure_station.getY();
        }

        if(return_station != null) {
            Return_station_id = return_station.getId();
            Return_station_fid = return_station.getFid();
            Return_station_nimi = return_station.getNimi();
            Return_station_namn = return_station.getNamn();
            Return_station_name = return_station.getName();
            Return_station_osoite = return_station.getOsoite();
            Return_station_address = return_station.getAddress();
            Return_station_kaupunki = return_station.getKaupunki();
            Return_station_stad = return_station.getStad();
            Return_station_operaattori = return_station.getOperaattori();
            Return_station_kapasiteetti = return_station.getKapasiteetti();
            Return_station_x = return_station.getX();
            Return_station_y = return_station.getY();
        }
    }

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

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public Long getDeparture_station_id() {
        return Departure_station_id;
    }

    public void setDeparture_station_id(Long departure_station_id) {
        Departure_station_id = departure_station_id;
    }

    public Integer getDeparture_station_fid() {
        return Departure_station_fid;
    }

    public void setDeparture_station_fid(Integer departure_station_fid) {
        Departure_station_fid = departure_station_fid;
    }

    public String getDeparture_station_nimi() {
        return Departure_station_nimi;
    }

    public void setDeparture_station_nimi(String departure_station_nimi) {
        Departure_station_nimi = departure_station_nimi;
    }

    public String getDeparture_station_namn() {
        return Departure_station_namn;
    }

    public void setDeparture_station_namn(String departure_station_namn) {
        Departure_station_namn = departure_station_namn;
    }

    public String getDeparture_station_name() {
        return Departure_station_name;
    }

    public void setDeparture_station_name(String departure_station_name) {
        Departure_station_name = departure_station_name;
    }

    public String getDeparture_station_osoite() {
        return Departure_station_osoite;
    }

    public void setDeparture_station_osoite(String departure_station_osoite) {
        Departure_station_osoite = departure_station_osoite;
    }

    public String getDeparture_station_address() {
        return Departure_station_address;
    }

    public void setDeparture_station_address(String departure_station_address) {
        Departure_station_address = departure_station_address;
    }

    public String getDeparture_station_kaupunki() {
        return Departure_station_kaupunki;
    }

    public void setDeparture_station_kaupunki(String departure_station_kaupunki) {
        Departure_station_kaupunki = departure_station_kaupunki;
    }

    public String getDeparture_station_stad() {
        return Departure_station_stad;
    }

    public void setDeparture_station_stad(String departure_station_stad) {
        Departure_station_stad = departure_station_stad;
    }

    public String getDeparture_station_operaattori() {
        return Departure_station_operaattori;
    }

    public void setDeparture_station_operaattori(String departure_station_operaattori) {
        Departure_station_operaattori = departure_station_operaattori;
    }

    public Integer getDeparture_station_kapasiteetti() {
        return Departure_station_kapasiteetti;
    }

    public void setDeparture_station_kapasiteetti(Integer departure_station_kapasiteetti) {
        Departure_station_kapasiteetti = departure_station_kapasiteetti;
    }

    public BigDecimal getDeparture_station_x() {
        return Departure_station_x;
    }

    public void setDeparture_station_x(BigDecimal departure_station_x) {
        Departure_station_x = departure_station_x;
    }

    public BigDecimal getDeparture_station_y() {
        return Departure_station_y;
    }

    public void setDeparture_station_y(BigDecimal departure_station_y) {
        Departure_station_y = departure_station_y;
    }

    public Long getReturn_station_id() {
        return Return_station_id;
    }

    public void setReturn_station_id(Long return_station_id) {
        Return_station_id = return_station_id;
    }

    public Integer getReturn_station_fid() {
        return Return_station_fid;
    }

    public void setReturn_station_fid(Integer return_station_fid) {
        Return_station_fid = return_station_fid;
    }

    public String getReturn_station_nimi() {
        return Return_station_nimi;
    }

    public void setReturn_station_nimi(String return_station_nimi) {
        Return_station_nimi = return_station_nimi;
    }

    public String getReturn_station_namn() {
        return Return_station_namn;
    }

    public void setReturn_station_namn(String return_station_namn) {
        Return_station_namn = return_station_namn;
    }

    public String getReturn_station_name() {
        return Return_station_name;
    }

    public void setReturn_station_name(String return_station_name) {
        Return_station_name = return_station_name;
    }

    public String getReturn_station_osoite() {
        return Return_station_osoite;
    }

    public void setReturn_station_osoite(String return_station_osoite) {
        Return_station_osoite = return_station_osoite;
    }

    public String getReturn_station_address() {
        return Return_station_address;
    }

    public void setReturn_station_address(String return_station_address) {
        Return_station_address = return_station_address;
    }

    public String getReturn_station_kaupunki() {
        return Return_station_kaupunki;
    }

    public void setReturn_station_kaupunki(String return_station_kaupunki) {
        Return_station_kaupunki = return_station_kaupunki;
    }

    public String getReturn_station_stad() {
        return Return_station_stad;
    }

    public void setReturn_station_stad(String return_station_stad) {
        Return_station_stad = return_station_stad;
    }

    public String getReturn_station_operaattori() {
        return Return_station_operaattori;
    }

    public void setReturn_station_operaattori(String return_station_operaattori) {
        Return_station_operaattori = return_station_operaattori;
    }

    public Integer getReturn_station_kapasiteetti() {
        return Return_station_kapasiteetti;
    }

    public void setReturn_station_kapasiteetti(Integer return_station_kapasiteetti) {
        Return_station_kapasiteetti = return_station_kapasiteetti;
    }

    public BigDecimal getReturn_station_x() {
        return Return_station_x;
    }

    public void setReturn_station_x(BigDecimal return_station_x) {
        Return_station_x = return_station_x;
    }

    public BigDecimal getReturn_station_y() {
        return Return_station_y;
    }

    public void setReturn_station_y(BigDecimal return_station_y) {
        Return_station_y = return_station_y;
    }
}