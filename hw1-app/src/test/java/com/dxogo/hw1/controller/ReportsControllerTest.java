package com.dxogo.hw1.controller;

import com.dxogo.hw1.model.Country;
import com.dxogo.hw1.model.LastSixMonths;
import com.dxogo.hw1.service.ReportsService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReportsController.class)
public class ReportsControllerTest {
    
    @Autowired MockMvc mvc;    //entry point to the web framework

    // inject required beans as "mockeable" objects
    // note that @AutoWire would result in NoSuchBeanDefinitionException
    @MockBean ReportsService service;

    @Test
    void getWorldData() throws Exception {

        Country c = new Country("World", 0, "All", null, null, 508387668, 640592, 6238531, 2220, 460806264, 808241, 41342873, 41733, 0);

        when(service.getWorldData()).thenReturn(c);

        mvc.perform(
            get("/report/world").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(14)))
            .andExpect(jsonPath("$.Country", is(c.getName())))
            .andExpect(jsonPath("$.Continent", is(c.getContinent()))
            );
            
        verify(service, times(1)).getWorldData();
    }

    @Test
    void getCountryData() throws Exception {

        Country c = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);

        when( service.getCountryDataToday( Mockito.anyString(), Mockito.anyString() )).thenReturn( c );
        when( service.getCountryFromISO( Mockito.anyString() ) ).thenReturn( "Portugal" );

        mvc.perform(
            get("/report/prt").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(14)))
            .andExpect(jsonPath("$.Country", is(c.getName())))
            .andExpect(jsonPath("$.ThreeLetterSymbol", is(c.getIso())))
            .andExpect(jsonPath("$.Continent", is(c.getContinent()))
            );
            
        verify(service, times(1)).getCountryDataToday("prt", "Portugal" );

    }

    @Test
    void getLastMonthData() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
        
        Date date1 = formatter.parse("2021-10-26");
        LastSixMonths c1 = new LastSixMonths("PRT", "Portugal", date1, 1088133, 888, 18149, 3, 19784847, 35619);
 
        Date date2 = formatter.parse("2021-10-27");
        LastSixMonths c2 = new LastSixMonths("PRT", "Portugal", date2, 2611886, 45335, 19856, 29, 19784847, 35619);

        List<LastSixMonths> last6months = Arrays.asList(c1, c2);

        when( service.getLastSixMonthsData("prt") ).thenReturn( last6months );

        mvc.perform(
            get("/report/lastsixmonths/prt").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].symbol", is(c1.getSymbol())))
            .andExpect(jsonPath("$[0].Country", is(c1.getCountry())))
            .andExpect(jsonPath("$[0].date", is(c1.getDate())))
            .andExpect(jsonPath("$[1].symbol", is(c2.getSymbol())))
            .andExpect(jsonPath("$[1].Country", is(c2.getCountry())))
            .andExpect(jsonPath("$[1].date", is(c2.getDate()))
        );
            
        verify(service, times(1)).getLastSixMonthsData( "prt" );

    }

    @Test
    void getCountriesData() throws Exception {

        Country c1 = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);
        Country c2 = new Country("Spain", 11, "Europe", "esp", "es", 11786036, 16381, 103908, 63, 11261340, 13474, 420788, 339, 471036328);

        List<Country> countries = Arrays.asList(c1, c2);

        when( service.getTop10() ).thenReturn( countries );

        mvc.perform(
            get("/report/top10").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].Country", is(c1.getName())))
            .andExpect(jsonPath("$[0].rank", is(c1.getRank())))
            .andExpect(jsonPath("$[0].Continent", is(c1.getContinent())))
            .andExpect(jsonPath("$[1].Country", is(c2.getName())))
            .andExpect(jsonPath("$[1].rank", is(c2.getRank())))
            .andExpect(jsonPath("$[1].Continent", is(c2.getContinent()))
        );
            
        verify(service, times(1)).getTop10( );

    }

    @Test
    void getIsoFromCountry() throws Exception {

        Country c = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);

        when( service.getIsoFromCountry("Portugal") ).thenReturn( "prt" );

        mvc.perform(
            get("/report/iso/Portugal").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(1)))
            .andExpect(jsonPath("$.iso", is(c.getIso()))
        );
            
        verify(service, times(1)).getIsoFromCountry( "Portugal" );

    }

    @Test
    void getCountryFromIso() throws Exception {

        Country c = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);

        when( service.getCountryFromISO("prt")).thenReturn( "Portugal" );

        mvc.perform(
            get("/report/country/prt").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(1)))
            .andExpect(jsonPath("$.country", is(c.getName()))
        );
            
        verify(service, times(1)).getCountryFromISO( "prt" );
    }

    @Test
    void getCacheDetails() throws Exception {

        String cache = "{ \"time_to_live\": 3000, \"requests\": 7, \"hits\": 5, \"misses\": 2 }";
    
        when( service.getCacheDetailsString() ).thenReturn( cache );

        mvc.perform(
            get("/report/cache").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*", hasSize(4)))
            .andExpect(jsonPath("$.time_to_live", is(3000)))
            .andExpect(jsonPath("$.requests", is(7)))
            .andExpect(jsonPath("$.hits", is(5)))
            .andExpect(jsonPath("$.misses", is(2))
        );
            
        verify(service, times(1)).getCacheDetailsString();

    }

}
