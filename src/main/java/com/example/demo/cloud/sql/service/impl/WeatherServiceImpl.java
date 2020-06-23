package com.example.demo.cloud.sql.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.cloud.sql.dao.WeatherDAO;
import com.example.demo.cloud.sql.entity.EWeather;
import com.example.demo.cloud.sql.model.Currently;
import com.example.demo.cloud.sql.model.Weather;
import com.example.demo.cloud.sql.service.WeatherService;

@Component
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherDAO weatherDAO;


	public List<Weather> getWeather(Float latitude, Float longitude) {
		StringBuffer weatherURL = new StringBuffer(
				"https://api.darksky.net/forecast/71e365fe53a4e9ba08abfd779cce581b/");
		
		System.out.println("Getting weather latitude" + latitude + " longitude = " + longitude);
		
		List<Weather> list = new ArrayList<Weather>();
		
		EWeather weatherEntity = checkForExistingRecord(latitude, longitude);
		
		java.util.Date current_date = Calendar.getInstance().getTime();

		long diff = 0;
		if (weatherEntity != null) {
			long diffInMillies = Math.abs(current_date.getTime() - weatherEntity.getPurchase_Date().getTime());
			diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		}

		if (diff > 1 || weatherEntity == null) {
			System.out.println("Record not exist in last 24 hours");
			fetchWeatherForecast(latitude, longitude, weatherURL, list);
		} else {
			System.out.println("Records already exist, fetching from database");
			fetchForecastFromDB(list, weatherEntity);
		}
		return list;
	}


	private EWeather checkForExistingRecord(Float latitude, Float longitude) {
		EWeather weatherEntity = weatherDAO.findByIdLatitudeLongitude(String.valueOf(latitude),
				String.valueOf(longitude));
		return weatherEntity;
	}


	private void fetchForecastFromDB(List<Weather> list, EWeather weatherEntity) {
		Weather weatherObj = copyEntityToModel(weatherEntity);
		list.add(weatherObj);
	}


	private void fetchWeatherForecast(Float latitude, Float longitude, StringBuffer weatherURL, List<Weather> list) {
		RestTemplate client = new RestTemplate();
		String url = weatherURL.append(latitude).append(",").append(longitude).toString();
		System.out.println("Request url" + url);
		
		Weather weatherObj = null;
		try {
			weatherObj = client.getForObject(url, Weather.class);
		} catch ( RestClientException  exception) {
			System.out.println("No data found for Latitude =" + latitude + " Longitude =" + longitude);
			return;
		}

		System.out.println("Time Zone" + weatherObj.getTimezone());
		System.out.println(weatherObj.toString());
		EWeather entity = copyEntity(weatherObj);
		entity.setLongitude(String.valueOf(longitude));
		entity.setLatitude(String.valueOf(latitude));
		entity.setPurchase_Date(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		weatherDAO.save(entity);
		list.add(weatherObj);
	}
	
	
	private Weather copyEntityToModel(EWeather weatherEntity) {
		Weather weather = new Weather();
		weather.setCurrently(new Currently());
		weather.setTimezone(weatherEntity.getCountryName());
		weather.getCurrently().setTemperature(weatherEntity.getTemperature());
		weather.getCurrently().setApparentTemperature(weatherEntity.getApparentTemperature());
		weather.getCurrently().setHumidity(weatherEntity.getHumidity());
		weather.getCurrently().setPressure(weatherEntity.getPressure());
		weather.getCurrently().setWindSpeed(weatherEntity.getWindSpeed());
		return weather;
	}

	private EWeather copyEntity(Weather weatherObj) {
		EWeather weather = new EWeather();

		weather.setCountryName(weatherObj.getTimezone());
		weather.setTemperature(weatherObj.getCurrently().getTemperature());
		weather.setApparentTemperature(weatherObj.getCurrently().getApparentTemperature());
		weather.setHumidity(weatherObj.getCurrently().getHumidity());
		weather.setPressure(weatherObj.getCurrently().getPressure());
		weather.setWindSpeed(weatherObj.getCurrently().getWindSpeed());
		return weather;
	}
}
