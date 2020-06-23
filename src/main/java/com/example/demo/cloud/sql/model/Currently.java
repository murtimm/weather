package com.example.demo.cloud.sql.model;

public class Currently {

	private float temperature;
	
	private float apparentTemperature;
	
	private float humidity;
	
	private float pressure;
	
	private float windSpeed;

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

	@Override
	public String toString() {
		return "Currently [temperature=" + temperature + ", apparentTemperature=" + apparentTemperature + ", humidity="
				+ humidity + ", pressure=" + pressure + ", windSpeed=" + windSpeed + "]";
	}


}
