CREATE TABLE IF NOT EXISTS WEATHER (
    ID int,
    country_Name varchar(255),
    temperature float,
    apparent_Temperature float,
    humidity float,
    pressure float,
    wind_Speed float,
    latitude varchar(20),
    longitude varchar(20),
    purchase_Date DATETIME DEFAULT CURRENT_TIMESTAMP
    );
