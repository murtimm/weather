package com.example.demo.cloud.sql.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "WEATHER")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EWeather {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "country_Name")
	private String countryName;

	@Column(name = "temperature")
	private float temperature;

	@Column(name = "apparent_Temperature")
	private float apparentTemperature;

	@Column(name = "humidity")
	private float humidity;

	@Column(name = "pressure")
	private float pressure;

	@Column(name = "wind_Speed")
	private float windSpeed;
	
	@Column(name = "purchase_Date")
	private Date purchase_Date;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longitude;

	public Date getPurchase_Date() {
		return purchase_Date;
	}

	public void setPurchase_Date(Date purchase_Date) {
		this.purchase_Date = purchase_Date;
	}


	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(float apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
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

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}


}
