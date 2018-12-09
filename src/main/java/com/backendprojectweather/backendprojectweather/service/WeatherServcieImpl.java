package com.backendprojectweather.backendprojectweather.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendprojectweather.backendprojectweather.model.Weather;
import com.backendprojectweather.backendprojectweather.repository.WeatherRepository;

@Service
public class WeatherServcieImpl implements WeatherService{
	
	@Autowired
	private WeatherRepository weatherRepository;
	/*
	 *	Save weather record
	 */
	@Override
	public Weather save(Weather weather)
	{
		// Check if todays record is present or not
		if(weatherRepository.countTodayEntry()<=0)
			return weatherRepository.save(weather);
		else
			return new Weather();
	}
	/*
	 * 	Return Todays weather record
	 */
	@Override
	public Weather currentDateWeather() 
	{
		return weatherRepository.currentDateWeather(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
	}
	/*
	 *  Return list of weather record data
	 */
	@Override
	public List<Weather> findAll() 
	{
		return weatherRepository.findAll();
	}
	/*
	 *  Return list of weather data according to city id
	 */
	@Override
	public List<Weather> findByCityId(int id,Long user_id) {
		return weatherRepository.findByCityId(id,user_id);
	}
	/*
	 *	Select Specific User Data
	 */
	@Override
	public List<Weather> findAllByCurrentUser(Long user_id) {
		return weatherRepository.findAllByCurrentUser(user_id);
	}
	
}
