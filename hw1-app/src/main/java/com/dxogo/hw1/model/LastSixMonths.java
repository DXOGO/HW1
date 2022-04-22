package com.dxogo.hw1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastSixMonths {

    @JsonProperty("symbol") private String symbol;
    @JsonProperty("Country") private String country;
    @JsonProperty("date") @DateTimeFormat(pattern = "dd-MM-yyyy") private Date date;
    @JsonProperty("total_cases") private Long total_cases;
    @JsonProperty("new_cases") private Long new_cases;
    @JsonProperty("total_deaths") private Long total_deaths;
    @JsonProperty("new_deaths") private Long new_deaths;
    @JsonProperty("total_tests") private Long total_tests;
    @JsonProperty("new_tests") private Long new_tests;


    public LastSixMonths() {}

    public LastSixMonths(String symbol, String country, Date date, Long total_cases, Long new_cases, Long total_deaths, Long new_deaths, Long total_tests, Long new_tests) {
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

    public Date getDate() {return this.date; }

    public Long getTotal_cases() {return this.total_cases; }

    public Long getNew_cases() {return this.new_cases; }

    public Long getTotal_deaths() {return this.total_deaths; }

    public Long getNew_deaths() {return this.new_deaths; }

    public Long getTotal_tests() {return this.total_tests; }

    public Long getNew_tests() {return this.new_tests; }


    @Override
    public String toString() {

        String date = new SimpleDateFormat("yyyy-MM-dd").format( this.getDate() );

        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", country='" + getCountry() + "'" +
            ", date='" + date + "'" +
            ", total_cases='" + getTotal_cases() + "'" +
            ", new_cases='" + getNew_cases() + "'" +
            ", total_deaths='" + getTotal_deaths() + "'" +
            ", new_deaths='" + getNew_deaths() + "'" +
            ", total_tests='" + getNew_tests() + "'" +
            ", new_tests='" + getNew_tests() + "'" +
            "}";
    }
    
}

