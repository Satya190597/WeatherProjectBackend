package com.backendprojectweather.backendprojectweather.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendprojectweather.backendprojectweather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{

	@Query(value = "SELECT * FROM WEATHER WHERE CURRENT_DATE(CREATED_AT)='2018-11-28' LIMIT 1",nativeQuery = true)
	public Weather checkTodayEntry(String dateFormat);
	
}
