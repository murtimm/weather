package com.example.demo.cloud.sql.service;

import java.util.List;

import com.example.demo.cloud.sql.model.Weather;

public interface WeatherService {

	/**
	 * Fetch Weather Forecast by using latitude and longitude
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	List<Weather> getWeather(Float latitude, Float longitude);

}
