package project.model.entity;

public class Weather {

    private String city;
    private String temperature;

    public Weather(String city, String temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\nWeather{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
