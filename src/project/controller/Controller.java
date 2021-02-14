package project.controller;

import project.AppGlobalState;
import project.model.*;
import project.model.entity.Weather;

import java.io.IOException;
import java.util.List;

public class Controller implements IController {

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider();
    IWeatherProvider weatherProvider = new AccuWeatherProvider();
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository();

    @Override
    public void onCityInput(String city) throws IOException {
        if (city.length() == 1) {
            throw new IOException("Недопустимо короткое название города");
        }

        codeProvider.getCodeByCityName(city);
    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException {
        switch (selectedCommand) {
            case 1: {
                Weather currentWeather = weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                System.out.println(currentWeather);
                weatherRepository.saveWeatherObject(currentWeather);
                break;
            }
            case 2: {
                List<Weather> allData = weatherRepository.getAllData();
                allData.forEach(System.out::println);

                break;
            }
            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }
}
