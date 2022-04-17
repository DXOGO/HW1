package com.dxogo.hw1.service;

import java.util.Date;
import java.util.Map;
import java.io.IOException;
import java.net.URISyntaxException;

import com.dxogo.hw1.cache.Cache;
import com.dxogo.hw1.exception.ResourceNotFoundException;
import com.dxogo.hw1.model.Reports;
import com.dxogo.hw1.repository.ReportsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportsService {

    private static final Logger log = LoggerFactory.getLogger(ReportsService.class);

    @Autowired
    private ReportsRepository repository;

    @Autowired
    private Cache cache;

    // public Map<String, Object> getCacheDetails() {
    //     return null;    
    // }

    public Reports getReportsByRegion(String region_province) throws ResourceNotFoundException {
        return repository.findByRegion(region_province);
    }

    public Reports getReportsByIso(String iso) throws ResourceNotFoundException {
        return repository.findByCountry(iso);
    }
}
