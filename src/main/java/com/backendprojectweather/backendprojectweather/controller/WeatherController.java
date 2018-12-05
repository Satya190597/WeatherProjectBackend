package com.backendprojectweather.backendprojectweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/*
	 *	POST, weather record to enter a new weather record
	 */
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public Weather addWeather(@RequestBody Weather weather)
	{
		return weatherService.save(weather);
	}
	/*
	 *	Get, Todays weather records (Under Development)
	 */
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public Weather test()
	{
		return weatherService.currentDateWeather();
	}
	/*
	 * 	Get, All weather records
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Weather> findAll()
	{
		return weatherService.findAll();	
	}
	/*
	 *	Get, All weathers records my CITY_ID
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public List<Weather> findByCity(@PathVariable int id)
	{
		return weatherService.findByCityId(id);
	}
}
