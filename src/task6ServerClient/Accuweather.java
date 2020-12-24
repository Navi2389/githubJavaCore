package task6ServerClient;

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
    String authBodyString="{"+
            "\"username\": \"Navi2389\", "+
            "\"password\": \"q1w2e3r4\""+"}";
    System.out.println(authBodyString);
    RequestBody requestBody=RequestBody.create(authBodyString,JSON);
    Request request=new Request.Builder()
            .url("https://developer.accuweather.com/user/login")
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
