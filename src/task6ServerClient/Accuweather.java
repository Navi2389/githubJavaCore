package task6ServerClient;

//1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
// пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий: зарегистрироваться,
// зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
// Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
// (этого достаточно для выполнения д/з).

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Accuweather {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

    MediaType JSON=MediaType.parse("application/json");

//не понял как выполнить сегментированное построение HTTP реквеста с использованием билдера:

        /*HttpUrl url = new HttpUrl.Builder()
                .scheme("https://developer.accuweather.com/user/login")
                .host("")
//еще какие-то аргументы
                .build();*//*
        RequestBody requestBody=RequestBody.create(String.valueOf(url),JSON);*/


    String authBodyString="{"+
            "\"username\": \"Navi2389\", "+
            "\"password\": \"q1w2e3r4\""+"}";
    System.out.println(authBodyString);
    RequestBody requestBody=RequestBody.create(authBodyString,JSON);



// значение 295212 для Санкт-Петербурга взяли с сайта
// https://developer.accuweather.com/accuweather-locations-api/apis/get/locations/v1/cities/%7BcountryCode%7D/search
    Request request=new Request.Builder()
            .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq")
            .post(requestBody)
            .build();

    Response responseWithToken=client.newCall(request).execute();
    String responseBody=responseWithToken.body().string();
        System.out.println(responseBody);
        String token = responseBody.split(":")[1];
        token = token.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        System.out.println(token);

    }

}
