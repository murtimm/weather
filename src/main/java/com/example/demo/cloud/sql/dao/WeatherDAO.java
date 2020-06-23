package com.example.demo.cloud.sql.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.cloud.sql.entity.EWeather;

public interface WeatherDAO extends CrudRepository<EWeather, Integer> {

	@Query("Select weather from EWeather weather where weather.latitude =:latitude and "
			+ " weather.longitude =:longitude")
	EWeather findByIdLatitudeLongitude(@Param("latitude") String latitude, @Param("longitude") String longitude);

}
