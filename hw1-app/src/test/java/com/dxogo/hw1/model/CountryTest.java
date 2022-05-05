package com.dxogo.hw1.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// unit testing
public class CountryTest {
    
    @Test
    void getCountryObjectTest(){

        Country c = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);

        assertEquals("Portugal", c.getName());
        assertEquals(30, c.getRank());
        assertEquals("Europe", c.getContinent());
        assertEquals("prt", c.getIso());
        assertEquals("pt", c.getTwoLetterSymbol());
        assertEquals(3719485, c.getTotal_cases());
        assertEquals(401, c.getNew_cases());
        assertEquals(21993, c.getTotal_deaths());
        assertEquals(32, c.getNew_deaths());
        assertEquals(3697492, c.getTotal_recovered());
        assertEquals(1272, c.getNew_recovered());
        assertEquals(5123, c.getActive_cases());
        assertEquals(61, c.getCritical());
        assertEquals(40748372, c.getTotal_tests());
    }

}
