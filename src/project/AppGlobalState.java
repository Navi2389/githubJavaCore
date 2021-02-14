package project;

import java.sql.*;

public class AppGlobalState {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    private static Statement statement;

    private static PreparedStatement insertWeatherPreparedStatement;

    private static AppGlobalState instanse;

    private String cityKey;

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static PreparedStatement getInsertWeatherPreparedStatement() {
        return insertWeatherPreparedStatement;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }
    public String getApiKey() {
        return "H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq";
    }
    /*public String getApiKey() {
        return System.getenv("ACCUWEATHER_API_KEY");
    }*/

    public String getDbName() {
        return "weather-app.db";
    }

    private AppGlobalState() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDbName());
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (" +
                    "city TEXT NOT NULL, temp TEXT NOT NULL );");

            insertWeatherPreparedStatement = connection.prepareStatement(
                    "INSERT INTO weather  (city, temp) VALUES (?,?);"
            );

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        }

    }

    public static AppGlobalState getInstance() {
        if (instanse == null) {
            instanse = new AppGlobalState();
        }
        return instanse;
    }
}
