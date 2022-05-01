package com.dxogo.hw1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.dxogo.hw1.cache.Cache;
import com.dxogo.hw1.connection.HttpClientConfig;
import com.dxogo.hw1.exception.ResourceNotFoundException;
import com.dxogo.hw1.model.Country;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@SuppressWarnings("rawtypes")
public class ReportsServiceTest {
    
    @Mock private TestRestTemplate template;
    
    @Mock private Cache cache;
    
    @InjectMocks private ReportsService service;

    
    @BeforeEach
    void setUp() throws InterruptedException, ResourceNotFoundException, IOException {
        this.service = new ReportsService();
        this.template = new TestRestTemplate();

    //     Country c1 = new Country("Portugal", 30, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);
    //     Country c2 = new Country("Spain", 11, "Europe", "esp", "es", 11786036, 16381, 103908, 63, 11261340, 13474, 420788, 339, 471036328);
    //     Country w = new Country("World", 0, "All", null, null, 508387668, 640592, 6238531, 2220, 460806264, 808241, 41342873, 41733, 0);
    
    //     List<Country> allCountries = Arrays.asList(c1, c2, w);

        // Mockito.when(this.service.getCountryDataToday(c1.getName(), c1.getIso())).thenReturn(c1);
        // Mockito.when(this.service.getCountryDataToday(c2.getName(), c2.getIso())).thenReturn(c2);
        // Mockito.when(this.service.getCountryDataToday("not existing","not existing")).thenReturn(null);
        // Mockito.when(this.service.getAllCountries()).thenReturn(allCountries);
    } 

    @Test
    void whenValidUrl_ThenReturnOk(){
        ResponseEntity<String> response = template.
        getForEntity("http://localhost:8080/world", String.class);
        
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void whenValidName_thenCountryShouldBeFound() throws IOException, ResourceNotFoundException, InterruptedException {
        // String iso = "prt";
        // String found = service.getCountryFromISO(iso);

        // Assertions.assertEquals(found, iso);
    }

    @Test
    void getWorldDataTest() throws IOException, InterruptedException {
    }

    @Test
    void getIsoFromCountryTest() throws IOException, InterruptedException, JSONException, ParseException {
    }

    @Test
    void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() throws ResourceNotFoundException, IOException, InterruptedException {
        // Country c1 = new Country("Portugal", 29, "Europe", "prt", "pt", 3719485, 401, 21993, 32, 3697492, 1272, 5123, 61, 40748372);
        
        // Mockito.when(template.getForEntity("http://localhost:8080/report/prt", Country.class))
        //     .thenReturn(new ResponseEntity<Country>(c1, HttpStatus.OK));

        // String countryname = service.getCountryFromISO("prt");
        // Assertions.assertEquals(countryname, c1);
    }

    @Test
    void getCacheDetailsTest() throws IOException, InterruptedException, JSONException, ParseException {

        String cache_string = "{ \"time_to_live\": 3000, \"requests\": 7, \"hits\": 5, \"misses\": 2 }";
    
        Mockito.when( cache.toString() ).thenReturn( cache_string );

        String info = service.getCacheDetailsString();

        assertEquals(cache_string, info);
    }
}
