package com.dxogo.hw1.service;

import com.dxogo.hw1.cache.Cache;
import com.dxogo.hw1.exception.ResourceNotFoundException;
import com.dxogo.hw1.model.Country;
import com.dxogo.hw1.model.LastSixMonths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ReportsServiceTest {

    @Mock private RestTemplate template;
    
    @Mock private Cache cache;
    
    @InjectMocks private ReportsService service;
    
    @BeforeEach
    void setUp() { service = new ReportsService(template); } 

    @AfterEach
    void cleanUp() { cache.clear(); }

    @Test
    void getWorldDataTest() throws IOException, InterruptedException, ResourceNotFoundException {

        Country[] world = {new Country("World", 0, "All", null, null, 508387668, 640592, 6238531, 2220, 460806264, 808241, 41342873, 41733, 0)};

        ResponseEntity<Country[]> response = ResponseEntity.ok().body(world);
        
        Mockito.when(template.getForEntity("/npm-covid-data/world", Country[].class)).thenReturn(response);

        Country result = service.getWorldData();

        assertEquals(result, world[0]);
        Mockito.verify(template, Mockito.times(1)).getForEntity("/npm-covid-data/world", Country[].class);

    }

    @Test
    void getAllCountriesTest() throws ResourceNotFoundException, IOException, InterruptedException {
        Country c1 = new Country("Portugal", 29, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);
        Country c2 = new Country("Spain", 11, "Europe", "esp", "es", 11786036, 16381, 103908, 63, 11261340, 13474, 420788, 339, 471036328);

        Country[] countries = {c1, c2};
        ResponseEntity<Country[]> response = ResponseEntity.ok().body(countries);
        
        Mockito.when(template.getForEntity("/npm-covid-data/countries-name-ordered", Country[].class)).thenReturn(response);

        Country[] result = service.getAllCountries();

        assertEquals(result, countries);
        Mockito.verify(template, Mockito.times(1)).getForEntity("/npm-covid-data/countries-name-ordered", Country[].class);
    }

    @Test
    void getCountryLastSixMonthsTest() throws ParseException, IOException, InterruptedException{

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  

        Date date1 = formatter.parse("2021-10-26");
        LastSixMonths c1 = new LastSixMonths("PRT", "Portugal", date1, 1088133, 888, 18149, 3, 19784847, 35619);
 
        Date date2 = formatter.parse("2021-10-27");
        LastSixMonths c2 = new LastSixMonths("PRT", "Portugal", date2, 2611886, 45335, 19856, 29, 19784847, 35619);

        LastSixMonths[] l6m = {c1, c2};

        ResponseEntity<LastSixMonths[]> response = ResponseEntity.ok().body(l6m);
        
        Mockito.when(template.getForEntity("/covid-ovid-data/sixmonth/PRT", LastSixMonths[].class)).thenReturn(response);

        LastSixMonths[] result = service.getAllLastSixMonths("PRT");

        assertEquals(result, l6m);
        Mockito.verify(template, Mockito.times(1)).getForEntity("/covid-ovid-data/sixmonth/PRT", LastSixMonths[].class);
    }
}
