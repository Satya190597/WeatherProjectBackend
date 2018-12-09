package com.backendprojectweather.backendprojectweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backendprojectweather.backendprojectweather.model.User;
import com.backendprojectweather.backendprojectweather.model.Weather;
import com.backendprojectweather.backendprojectweather.repository.WeatherRepository;
import com.backendprojectweather.backendprojectweather.service.UserService;
import com.backendprojectweather.backendprojectweather.service.WeatherService;

@RequestMapping(value = "/weather")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class WeatherController 
{
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private UserService userService;
	
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		return weatherService.findAllByCurrentUser(user.getId());	
	}
	/*
	 *	Get, All weathers records my CITY_ID
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public List<Weather> findByCity(@PathVariable int id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		return weatherService.findByCityId(id,user.getId());
	}
	/*
	 * DELETE A Particular Weather Record
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public void deleteById(@PathVariable Long id)
	{
		weatherService.deleteById(id);
	}
}
