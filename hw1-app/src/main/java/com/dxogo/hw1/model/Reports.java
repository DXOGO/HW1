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
    private String region_province;
    private Double lat;
    private Double lng;
    private Date date;


    public Reports() {
    }


    public Reports(Long id, String iso, String country, String region_province, Double lat, Double lng, Date date) {
        this.id = id;
        this.iso = iso;
        this.country = country;
        this.region_province = region_province;
        this.lat = lat;
        this.lng = lng;
        this.date = date;
    }

    public String getRegion_province() { return this.region_province; }

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
        return Objects.equals(id, Reports.id) && Objects.equals(iso, Reports.iso) && Objects.equals(country, Reports.country) && Objects.equals(region_province, Reports.region_province) && Objects.equals(lat, Reports.lat) && Objects.equals(lng, Reports.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso, country, region_province, lat, lng);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", iso='" + getIso() + "'" +
            ", country='" + getCountry() + "'" +
            ", region_province='" + getRegion_province() + "'" +
            ", lat='" + getLat() + "'" +
            ", lng='" + getLng() + "'" +
            "}";
    }


    public Reports orElseThrow(Object object) {
        return null;
    }

}