package project.model;

import project.model.entity.Weather;

import java.util.List;

public interface IWeatherRepository {

    List<Weather> getAllData();

    void saveWeatherObject(Weather weather);
}
