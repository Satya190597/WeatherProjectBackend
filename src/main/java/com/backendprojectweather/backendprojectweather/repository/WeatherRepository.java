package com.backendprojectweather.backendprojectweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendprojectweather.backendprojectweather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{

}
