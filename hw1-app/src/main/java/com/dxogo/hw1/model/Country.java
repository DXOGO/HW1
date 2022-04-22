package com.dxogo.hw1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    @JsonProperty("Country") private String name;
    @JsonProperty("rank") private Long rank;
    @JsonProperty("Continent") private String continent;
    @JsonProperty("ThreeLetterSymbol") private String iso;
    @JsonProperty("TwoLetterSymbol") private String twoLetterSymbol;
    @JsonProperty("TotalCases") private Long total_cases;
    @JsonProperty("NewCases") private Long new_cases;
    @JsonProperty("TotalDeaths") private Long total_deaths;
    @JsonProperty("NewDeaths") private Long new_deaths;
    @JsonProperty("TotalRecovered") private Long total_recovered;
    @JsonProperty("NewRecovered") private Long new_recovered;
    @JsonProperty("ActiveCases") private Long active_cases;
    @JsonProperty("Serious_Critical") private Long critical;
    @JsonProperty("TotalTests") private Long total_tests;



    public Country() {}

    public Country(String name, Long rank, String continent, String iso, String twoLetterSymbol, Long total_cases, Long new_cases, Long total_deaths, Long new_deaths, Long total_recovered, Long new_recovered, Long active_cases, Long critical, Long total_tests) {
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
    
    public Long getRank() { return this.rank; }

    public String getContinent() { return this.continent; }

    public String getIso() { return this.iso; }

    public String getTwoLetterSymbol() { return this.twoLetterSymbol; }

    public Long getTotal_cases() { return this.total_cases; }

    public Long getNew_cases() { return this.new_cases; }

    public Long getTotal_deaths() { return this.total_deaths; }

    public Long getNew_deaths() { return this.new_deaths; }

    public Long getTotal_recovered() { return this.total_recovered; }

    public Long getNew_recovered() { return this.new_recovered; }
    
    public Long getActive_cases() { return this.active_cases; }

    public Long getCritical() { return this.critical; }
    
    public Long getTotal_tests() { return this.total_tests; }

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