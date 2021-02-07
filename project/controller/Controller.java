package src.src.main.java.project.controller;

import src.src.main.java.project.AppGlobalState;
import src.src.main.java.project.model.*;

import java.io.IOException;

public class Controller implements IController {

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider();
    IWeatherProvider weatherProvider = new YandexWeatherProvider();

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
                weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }
            case 2: {
                weatherProvider.getFiveDaysWeather(AppGlobalState.getInstance().getCityKey());
                break;
            }
            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }
}
