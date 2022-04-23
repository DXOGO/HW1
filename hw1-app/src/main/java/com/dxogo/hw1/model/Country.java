package com.dxogo.hw1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @JsonProperty("Country") private String name;
    @JsonProperty("rank") private int rank;
    @JsonProperty("Continent") private String continent;
    @JsonProperty("ThreeLetterSymbol") private String iso;
    @JsonProperty("TwoLetterSymbol") private String twoLetterSymbol;
    @JsonProperty("TotalCases") private int total_cases;
    @JsonProperty("NewCases") private int new_cases;
    @JsonProperty("TotalDeaths") private int total_deaths;
    @JsonProperty("NewDeaths") private int new_deaths;
    @JsonProperty("TotalRecovered") private int total_recovered;
    @JsonProperty("NewRecovered") private int new_recovered;
    @JsonProperty("ActiveCases") private int active_cases;
    @JsonProperty("Serious_Critical") private int critical;
    @JsonProperty("TotalTests") private int total_tests;



    public Country() {}

    public Country(String name, int rank, String continent, String iso, String twoLetterSymbol, int total_cases, int new_cases, int total_deaths, int new_deaths, int total_recovered, int new_recovered, int active_cases, int critical, int total_tests) {
        this.name = name;
        this.rank = rank;
        this.continent = continent;
        this.iso = iso;
        this.twoLetterSymbol = twoLetterSymbol;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.total_deaths = total_deaths;
        this.new_deaths = new_deaths;
        this.total_recovered = total_recovered;
        this.new_recovered = new_recovered;
        this.active_cases = active_cases;
        this.critical = critical;
        this.total_tests = total_tests;
    }


    public String getName() { return this.name; }
    
    public int getRank() { return this.rank; }

    public String getContinent() { return this.continent; }

    public String getIso() { return this.iso; }

    public String getTwoLetterSymbol() { return this.twoLetterSymbol; }

    public int getTotal_cases() { return this.total_cases; }

    public int getNew_cases() { return this.new_cases; }

    public int getTotal_deaths() { return this.total_deaths; }

    public int getNew_deaths() { return this.new_deaths; }

    public int getTotal_recovered() { return this.total_recovered; }

    public int getNew_recovered() { return this.new_recovered; }
    
    public int getActive_cases() { return this.active_cases; }

    public int getCritical() { return this.critical; }
    
    public int getTotal_tests() { return this.total_tests; }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", rank='" + getRank() + "'" +
            ", continent='" + getContinent() + "'" +
            ", iso='" + getIso() + "'" +
            ", twoLetterSymbol='" + getTwoLetterSymbol() + "'" +
            ", total_cases='" + getTotal_cases() + "'" +
            ", new_cases='" + getNew_cases() + "'" +
            ", total_deaths='" + getTotal_deaths() + "'" +
            ", new_deaths='" + getNew_deaths() + "'" +
            ", total_recovered='" + getTotal_recovered() + "'" +
            ", new_recovered='" + getNew_recovered() + "'" +
            ", active_cases='" + getActive_cases() + "'" +
            ", critical='" + getCritical() + "'" +
            "}";
    }


}