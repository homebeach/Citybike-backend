package com.citybike.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="Station")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StationDTO {

    @Id
    @Column(name = "ID")
    private Long id;

    private Integer fid;

    private String nimi;

    private String namn;

    private String name;

    private String osoite;

    private String address;

    private String kaupunki;

    private String stad;

    private String operaattori;

    private Integer kapasiteetti;

    private BigDecimal x;

    private BigDecimal y;

    @OneToMany(mappedBy = "departure_stationDTO")
    @JsonIgnore
    private List<JourneyDTO> journeysFrom;

    @OneToMany(mappedBy = "return_stationDTO")
    @JsonIgnore
    private List<JourneyDTO> journeysTo;

    public List<JourneyDTO> getJourneysFrom() {
        return journeysFrom;
    }

    public void setJourneysFrom(List<JourneyDTO> journeysFrom) {
        this.journeysFrom = journeysFrom;
    }

    public List<JourneyDTO> getJourneysTo() {
        return journeysTo;
    }

    public void setJourneysTo(List<JourneyDTO> journeysTo) {
        this.journeysTo = journeysTo;
    }

    public int getCountOfJourneysFrom() {
        return journeysFrom.size();
    }

    public int getCountOfJourneysTo() {
        return journeysTo.size();
    }

    public double getAverageJourneysFromDistance() {
        double totalDistance = 0.0;
        int numJourneys = journeysFrom.size();
        for (JourneyDTO journeyDTO : journeysFrom) {
            totalDistance += journeyDTO.getCovered_distance();
        }
        return numJourneys > 0 ? totalDistance / numJourneys : 0.0;
    }

    public double getAverageJourneysToDistance() {
        double totalDistance = 0.0;
        int numJourneys = journeysTo.size();
        for (JourneyDTO journeyDTO : journeysTo) {
            totalDistance += journeyDTO.getCovered_distance();
        }
        return numJourneys > 0 ? totalDistance / numJourneys : 0.0;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getOperaattori() {
        return operaattori;
    }

    public void setOperaattori(String operaattori) {
        this.operaattori = operaattori;
    }

    public Integer getKapasiteetti() {
        return kapasiteetti;
    }

    public void setKapasiteetti(Integer kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

}