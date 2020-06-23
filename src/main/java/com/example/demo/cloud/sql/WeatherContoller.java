package com.example.demo.cloud.sql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cloud.sql.model.Weather;
import com.example.demo.cloud.sql.service.WeatherService;

@RestController
public class WeatherContoller {

	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value = "/getWeather/{latitude}/{longitude}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Weather> getWeather(@PathVariable("latitude") Float latitude,
			@PathVariable("longitude") Float longitude) {
		return weatherService.getWeather(latitude, longitude);
	}

}
