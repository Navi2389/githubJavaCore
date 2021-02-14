package project.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import project.AppGlobalState;
import project.model.entity.Weather;

import java.io.IOException;

public class AccuWeatherProvider implements IWeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CONDITIONS_PATH = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Weather getCurrentWeather(String cityKey) throws IOException {
        //http://dataservice.accuweather.com/currentconditions/v1/27497?apikey={{accuweatherApiKey}}


        HttpUrl getWeatherUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(CONDITIONS_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .build();

        Request getWeatherRequest = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(getWeatherUrl)
                .build();

        Response response = client.newCall(getWeatherRequest).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Ошибка сети\n");
        }


        String temperature = objectMapper.readTree(response.body().string()).get(0).at("/Temperature/Metric/Value").asText();

        Weather result = new Weather(AppGlobalState.getInstance().getCityName(), temperature);
        return result;
    }
}

/*
[
    {
        "LocalObservationDateTime": "2021-02-10T21:45:00+03:00",
        "EpochTime": 1612982700,
        "WeatherText": "Cloudy",
        "WeatherIcon": 7,
        "HasPrecipitation": false,
        "PrecipitationType": null,
        "IsDayTime": false,
        "Temperature": {
            "Metric": {
                "Value": -7.6,
                "Unit": "C",
                "UnitType": 17
            },
            "Imperial": {
                "Value": 18.0,
                "Unit": "F",
                "UnitType": 18
            }
        },
        "MobileLink": "http://m.accuweather.com/en/by/brest/27497/current-weather/27497?lang=en-us",
        "Link": "http://www.accuweather.com/en/by/brest/27497/current-weather/27497?lang=en-us"
    }
]
 */