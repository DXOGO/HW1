package com.dxogo.hw1.repository;

import com.dxogo.hw1.model.Reports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<Reports,Integer>{
    Reports findByRegion(String region_province);
    Reports findByCountry(String iso); 

}
