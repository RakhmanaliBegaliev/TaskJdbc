package com.peaksoft;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


//        createTable();
//        System.out.println(getCount());
//dropTable();
    addCity("Moscow", "Sobyanin");
//    addCity("Bishkek", "Djunushaliev");
//    addCity("New York", "Adams");
//    addCity("Tokyo", "Youriko");
//    addCity("Istanbul", "Imamoglu");
//getAllCites();

    }
public static void dropTable(){
        String SQL = "DROP TABLE cities";
        try(Connection connection = Task.connection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
}
    public static void createTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS cities(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR (50), " +
                " president_of_city VARCHAR (128));";
        try (Connection conn = Task.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        String SQL = "SELECT count(*) FROM cities";
        int count = 0;
        try (Connection conn = Task.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void addCity( String name, String president_Of_city) {
        String SQL = "INSERT INTO cities ( name, president_of_city) VALUES (?,?)";
        try (Connection conn = Task.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(2, name);
            statement.setString(3, president_Of_city);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<City> getAllCites() {
        String SQL = "SELECT * FROM cities";
        List<City> cities = new ArrayList<>();
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setPresidet_of_city(resultSet.getString("president_of_city"));
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static City getById(int id) {
        String SQL = "SELECT * FROM users WHERE id = ?";
        City city = new City();
        try (Connection connection = Task.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setPresidet_of_city(resultSet.getString("president_of_city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


    public static void createTable1() {
        String SQL = "CREATE TABLE IF NOT EXISTS coutries(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR (40)," +
                "president_of_country VARCHAR(20));";
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCount1() {
        String SQL = "SELECT count(*) FROM countries";
        int count = 0;
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void AddCountry(String name, String president_of_country) {
        String SQL = "INSERT INTO countries (name, president_of_countries) VALUES(?,?)";
        try (Connection connection = Task.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, president_of_country);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable2() {
        String SQL = "CREATE TABLE IF NOT EXISTS mayors(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "age INT);";
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getCount2() {
        String SQL = "SELECT count(*) FROM mayors";
        int count = 0;
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void AddMayors(String name, int age) {
        String SQL = "INSERT INTO countries (name, age) VALUES(?,?)";
        try (Connection connection = Task.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

