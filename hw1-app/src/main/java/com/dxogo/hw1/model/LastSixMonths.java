package com.dxogo.hw1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastSixMonths {

    @JsonProperty("symbol") private String symbol;
    @JsonProperty("Country") private String country;
    @JsonProperty("date") private Date date;
    @JsonProperty("total_cases") private int total_cases;
    @JsonProperty("new_cases") private int new_cases;
    @JsonProperty("total_deaths") private int total_deaths;
    @JsonProperty("new_deaths") private int new_deaths;
    @JsonProperty("total_tests") private int total_tests;
    @JsonProperty("new_tests") private int new_tests;


    public LastSixMonths() {}

    public LastSixMonths(String symbol, String country, Date date, int total_cases, int new_cases, int total_deaths, int new_deaths, int total_tests, int new_tests) {
        this.symbol = symbol;
        this.country = country;
        this.date = date;
        this.total_cases = total_cases;
        this.new_cases = new_cases;
        this.total_deaths = total_deaths;
        this.new_deaths = new_deaths;
        this.total_tests = total_tests;
        this.new_tests = new_tests;
    }

    public String getSymbol() { return this.symbol; }

    public String getCountry() { return this.country; }

    public String getDate() { return new SimpleDateFormat("yyyy-MM-dd").format(this.date); }

    public int getTotal_cases() {return this.total_cases; }

    public int getNew_cases() {return this.new_cases; }

    public int getTotal_deaths() {return this.total_deaths; }

    public int getNew_deaths() {return this.new_deaths; }

    public int getTotal_tests() {return this.total_tests; }

    public int getNew_tests() {return this.new_tests; }


    @Override
    public String toString() {

        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", country='" + getCountry() + "'" +
            ", date='" + getDate() + "'" +
            ", total_cases='" + getTotal_cases() + "'" +
            ", new_cases='" + getNew_cases() + "'" +
            ", total_deaths='" + getTotal_deaths() + "'" +
            ", new_deaths='" + getNew_deaths() + "'" +
            ", total_tests='" + getNew_tests() + "'" +
            ", new_tests='" + getNew_tests() + "'" +
            "}";
    }    
}

