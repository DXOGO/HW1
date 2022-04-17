package com.dxogo.hw1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dxogo.hw1.exception.ResourceNotFoundException;
import com.dxogo.hw1.model.Reports;
import com.dxogo.hw1.service.ReportsService;

import java.util.Date;
import java.util.Map;

@RestController
public class ReportsController {

    @Autowired
    ReportsService reportsService;

    @GetMapping("/reports/{region}")
    public Reports getReportsByRegion(@PathVariable(value = "region") String region) throws ResourceNotFoundException {
        return reportsService.getReportsByRegion(region);
    }

    @GetMapping("/reports/{iso}")
    public Reports getReportsByIso(@PathVariable(value = "iso") String iso) throws ResourceNotFoundException {
        return reportsService.getReportsByIso(iso);
    }

    // @GetMapping("/cache")
    // public Map<String, Object> getCacheDetails() {
    //     return reportsService.getCacheDetails();
    // }
    
}
