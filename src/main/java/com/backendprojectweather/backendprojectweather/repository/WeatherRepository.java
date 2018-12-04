package com.backendprojectweather.backendprojectweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendprojectweather.backendprojectweather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{

	@Query(value = "SELECT * FROM WEATHER WHERE CREATED_AT > CURRENT_DATE() LIMIT 1",nativeQuery = true)
	public Weather checkTodayEntry(String dateFormat);
	
	@Query(value = "SELECT COUNT(*) FROM WEATHER WHERE DAY(CREATED_AT) = DAY(CURRENT_DATE()) AND MONTH(CREATED_AT) = MONTH(CURRENT_DATE()) AND YEAR(CREATED_AT) = YEAR(CURRENT_DATE())",nativeQuery = true)
	public int countTodayEntry();
	
}
