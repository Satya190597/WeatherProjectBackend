package com.backendprojectweather.backendprojectweather.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendprojectweather.backendprojectweather.model.User;
import com.backendprojectweather.backendprojectweather.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping(value="/user",params = "id",method = RequestMethod.GET)
	public Optional<User> getUserDetail(@RequestParam("id") Long id)
	{
		return userService.findById(id);
	} 
	
	@RequestMapping(value="/user",method = RequestMethod.POST)
	public User createUser(@RequestBody User user)
	{
		return userService.save(user);
	}
	
	@RequestMapping(value="/userlogin",method = RequestMethod.GET)
	public User login(@RequestHeader HttpHeaders headers)
	{
		String email = headers.get("email").get(0);
		return userService.login(email);
	}
}
