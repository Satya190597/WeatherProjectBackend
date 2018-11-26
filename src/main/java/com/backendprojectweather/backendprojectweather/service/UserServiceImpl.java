package com.backendprojectweather.backendprojectweather.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendprojectweather.backendprojectweather.model.User;
import com.backendprojectweather.backendprojectweather.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findById(Long regno) 
	{	
		return userRepository.findById(regno);
	}
	
	@Override
	public User save(User user)
	{
		return userRepository.save(user);
	}
	
	@Override
	public User login(String email)
	{
		return userRepository.login(email);
	}
}
