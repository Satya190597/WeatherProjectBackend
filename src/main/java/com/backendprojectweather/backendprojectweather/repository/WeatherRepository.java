package com.backendprojectweather.backendprojectweather.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendprojectweather.backendprojectweather.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>{
	@Query(value = "SELECT * FROM WEATHER WHERE CREATED_AT > CURRENT_DATE() LIMIT 1",nativeQuery = true)
	public Weather currentDateWeather(String dateFormat);
	@Query(value = "SELECT COUNT(*) FROM WEATHER WHERE DAY(CREATED_AT) = DAY(CURRENT_DATE()) AND MONTH(CREATED_AT) = MONTH(CURRENT_DATE()) AND YEAR(CREATED_AT) = YEAR(CURRENT_DATE())",nativeQuery = true)
	public int countTodayEntry();
	@Query(value = "SELECT * FROM WEATHER WHERE CITY_ID = ?1",nativeQuery = true)
	public List<Weather> findByCityId(int id);
}
