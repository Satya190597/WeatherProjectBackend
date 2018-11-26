package com.backendprojectweather.backendprojectweather.service;

import java.util.Optional;
import com.backendprojectweather.backendprojectweather.model.User;

public interface UserService 
{
	public Optional<User> findById(Long regno);
	
	public User save(User user);
	
	public User login(String email);
}
