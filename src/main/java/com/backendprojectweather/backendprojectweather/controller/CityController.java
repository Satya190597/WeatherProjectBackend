package com.backendprojectweather.backendprojectweather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backendprojectweather.backendprojectweather.model.City;
import com.backendprojectweather.backendprojectweather.service.CityService;


@RequestMapping("/city")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CityController 
{
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public City addCity(@RequestBody City city)
	{
		return cityService.save(city);
	}
	
	@RequestMapping(value= {"/","/all",""},method = RequestMethod.GET)
	public List<City> allCity()
	{
		return cityService.findAll();
	}
}
