package com.dxogo.hw1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import com.dxogo.hw1.exception.ResourceNotFoundException;
import com.dxogo.hw1.model.Country;
import com.dxogo.hw1.model.LastSixMonths;
import com.dxogo.hw1.service.ReportsService;

@RestController
public class ReportsController {

    @Autowired ReportsService service;

    // country report
    @GetMapping("/{iso}")
    public ModelAndView getCountryReport(Model model, @PathVariable String iso) throws ResourceNotFoundException, IOException, InterruptedException {
        
        ModelAndView modelEdit = new ModelAndView();

        String country = service.getCountryFromISO(iso);
        
        model.addAttribute("daily", service.countryDataToday(iso, country));
        model.addAttribute("last6months", service.getLastSixMonthsData(iso));

        modelEdit.setViewName("report");
        
        return modelEdit;
    }

    // world report
    @GetMapping("/world")
    public ModelAndView getWorldReport(Model model) throws ResourceNotFoundException, IOException, InterruptedException {
        
        ModelAndView modelEdit = new ModelAndView();
        
        model.addAttribute("world", service.getWorldData());
        model.addAttribute("top10", service.getTop10());

        modelEdit.setViewName("world");
        
        return modelEdit;
    }

    // get cache
    @GetMapping("/cache")
    public ModelAndView getCache(Model model) throws ResourceNotFoundException, IOException, InterruptedException {
        
        ModelAndView modelEdit = new ModelAndView();
        
        model.addAttribute("cache", service.getCacheDetails());

        modelEdit.setViewName("cache");
        
        return modelEdit;
    }

    // get all countries
    @GetMapping("/countries")
    public TreeMap<String, String> getCountries() throws InterruptedException, IOException {
        return service.getMapCountryISO();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    // for testing
    @GetMapping("/report/{iso}")
    public Country getJsonCountry(@PathVariable String iso) throws ResourceNotFoundException, IOException, InterruptedException{
        String country = service.getCountryFromISO(iso);
        return service.countryDataToday(iso, country);
    }

    @GetMapping("/report/world")
    public Country getJsonWorld() throws ResourceNotFoundException, IOException, InterruptedException{
        return service.getWorldData();
    }

    @GetMapping("/report/top10")
    public List<Country> getJsonTop10() throws ResourceNotFoundException, IOException, InterruptedException{
        return service.getTop10();
    }

    @GetMapping("/report/iso/{country}")
    public String getIsoFromCountry(@PathVariable String country) throws ResourceNotFoundException, IOException, InterruptedException{
        String iso = service.getIsoFromCountry(country);
        return "{ \"iso\" : \""+ iso +"\"}";
    }

    @GetMapping("/report/country/{iso}")
    public String getCountryFromIso(@PathVariable String iso) throws ResourceNotFoundException, IOException, InterruptedException{
        String country = service.getCountryFromISO(iso);
        return "{ \"country\" : \""+ country +"\"}";
    }

    @GetMapping("/report/cache")
    public String getCacheDetailsReport(){
       return service.getCacheDetails();
    }

    @GetMapping("/report/lastsixmonths/{iso}")
    public List<LastSixMonths> getLastsixMonths(@PathVariable String iso) throws IOException, InterruptedException{
        return service.getLastSixMonthsData(iso);
    }

}

