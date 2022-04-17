package com.dxogo.hw1.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue
    private Long id;

    private String iso;
    private String country;
    private String region;
    private Double lat;
    private Double lng;
    private Date date;


    public Reports() {
    }


    public Reports(Long id, String iso, String country, String region, Double lat, Double lng, Date date) {
        this.id = id;
        this.iso = iso;
        this.country = country;
        this.region = region;
        this.lat = lat;
        this.lng = lng;
        this.date = date;
    }

    public String getRegion() { return this.region; }

    public Date getDate() { return this.date; }
   
    public Long getId() { return this.id;}

    public String getIso() { return this.iso;}

    public String getCountry() { return this.country;}

    public Double getLat() { return this.lat;}

    public Double getLng() { return this.lng;}

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Reports)) {
            return false;
        }
        Reports Reports = (Reports) o;
        return Objects.equals(id, Reports.id) && Objects.equals(iso, Reports.iso) && Objects.equals(country, Reports.country) && Objects.equals(region, Reports.region) && Objects.equals(lat, Reports.lat) && Objects.equals(lng, Reports.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso, country, region, lat, lng);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", iso='" + getIso() + "'" +
            ", country='" + getCountry() + "'" +
            ", region='" + getRegion() + "'" +
            ", lat='" + getLat() + "'" +
            ", lng='" + getLng() + "'" +
            "}";
    }


    public Reports orElseThrow(Object object) {
        return null;
    }

}