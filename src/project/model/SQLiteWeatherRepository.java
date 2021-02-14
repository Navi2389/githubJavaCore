package project.model;

import project.AppGlobalState;
import project.model.entity.Weather;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteWeatherRepository implements IWeatherRepository {

    @Override
    public List<Weather> getAllData() {
        Statement statement = AppGlobalState.getStatement();
        List<Weather> result = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM weather");
            while (rs.next()) {
                result.add(new Weather(
                        rs.getString(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public void saveWeatherObject(Weather weather) {
        PreparedStatement insertOne = AppGlobalState.getInsertWeatherPreparedStatement();
        try {
            insertOne.setString(1, weather.getCity());
            insertOne.setString(2, weather.getTemperature());
            insertOne.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
