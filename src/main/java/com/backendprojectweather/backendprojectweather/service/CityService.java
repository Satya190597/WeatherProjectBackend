package com.backendprojectweather.backendprojectweather.service;

import java.util.List;

import com.backendprojectweather.backendprojectweather.model.City;

public interface CityService {
	
	public List<City> findAll();
	public City save(City city);
}
