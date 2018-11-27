package com.backendprojectweather.backendprojectweather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendprojectweather.backendprojectweather.model.City;
import com.backendprojectweather.backendprojectweather.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public List<City> findAll()
	{
		return cityRepository.findAll();
	}
	@Override
	public City save(City city)
	{
		return cityRepository.save(city);
	}
}
