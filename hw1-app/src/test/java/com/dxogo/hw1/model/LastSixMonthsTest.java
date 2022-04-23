package com.dxogo.hw1.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastSixMonthsTest {
    
    @Test
    void getLastSixMonthsObjectTest() throws ParseException{

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = formatter.parse("2021-10-25");

        LastSixMonths c = new LastSixMonths("prt", "Portugal", date, 1085451, 313, 18138, 5, 19711548, 35285);

        assertEquals("prt", c.getSymbol());
        assertEquals("Portugal", c.getCountry());
        assertEquals(date, c.getDate());
        assertEquals(1085451, c.getTotal_cases());
        assertEquals(313, c.getNew_cases());
        assertEquals(18138, c.getTotal_deaths());
        assertEquals(5, c.getNew_deaths());
        assertEquals(19711548, c.getTotal_tests());
        assertEquals(35285, c.getNew_tests());
    }
}
