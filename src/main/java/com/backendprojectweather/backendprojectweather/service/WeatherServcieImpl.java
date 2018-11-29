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
	@Override
	public Weather save(Weather weather)
	{
		return weatherRepository.save(weather);
	}
	@Override
	public Weather currentDateWeather() {
		return weatherRepository.checkTodayEntry(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
	}
	@Override
	public List<Weather> findAll() {
		return weatherRepository.findAll();
	}
}
