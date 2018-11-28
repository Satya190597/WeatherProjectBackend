package com.backendprojectweather.backendprojectweather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backendprojectweather.backendprojectweather.model.Weather;
import com.backendprojectweather.backendprojectweather.service.WeatherService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(value = "/weather")
@RestController
public class WeatherController 
{
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public Weather addWeather(@RequestBody Weather weather)
	{
		return weatherService.save(weather);
	}
	
}
