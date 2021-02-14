package project2.model;

import project2.model.entity.Weather;

import java.util.List;

public interface IWeatherRepository {

    List<Weather> getAllData(); // добавили метод для просмотра нашего архива

    void saveWeatherObject (Weather weather);
}
