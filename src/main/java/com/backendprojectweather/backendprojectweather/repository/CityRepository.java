package com.backendprojectweather.backendprojectweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendprojectweather.backendprojectweather.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
