package com.backendprojectweather.backendprojectweather.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Weather 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private float grnd_level;
	@NotBlank
	private float humidity;
	@NotBlank
	private float pressure;
	@NotBlank
	private float sea_level;
	@NotBlank
	private float temp;
	@NotBlank
	private float temp_max;
	@NotBlank
	private float temp_min;
	@NotBlank
	private float speed;
	@NotBlank
	private String country;
	@NotBlank
	private String icon;
	@NotBlank
	private String description;
	@NotBlank
	@OneToOne
	private City city;
	public float getGrnd_level() {
		return grnd_level;
	}
	public void setGrnd_level(float grnd_level) {
		this.grnd_level = grnd_level;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getSea_level() {
		return sea_level;
	}
	public void setSea_level(float sea_level) {
		this.sea_level = sea_level;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	public float getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}
