package com.peaksoft;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


        createTable();
        dropTable();
        addCity("Moscow", "Sobyanin");
        addCity("Bishkek", "Djunushaliev");
        addCity("New York", "Adams");
        addCity("Tokyo", "Youriko");
        addCity("Istanbul", "Imamoglu");
        getAllCites();
        getByIdCity(2);

        createTable1();
        AddCountry("Russia", "Moscow");
        AddCountry("Kyrgyzstan", "Bishkek");
        AddCountry("U.S.A", "New York");
        AddCountry("Korea", "Tokyo");
        AddCountry("Turkey", "Istanbul");
        getAllCountries();


        createTable2();
        AddPresidents("Sobyanin", "Moscow");
        AddPresidents("Djunushaliev", "Bishkek");
        AddPresidents("Adams", "New York");
        AddPresidents("Youriko", "Tokyo");
        AddPresidents("Imamoglu", "Istanbul");


    }

    public static void dropTable() {
        String SQL = "DROP TABLE cities";
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS cities(" +
                "id SERIAL PRIMARY KEY ," +
                "name VARCHAR (50) NOT NULL, " +
                " president_of_city VARCHAR (128) NOT NULL, " +
                "UNIQUE (name, president_of_city) );";
        try (Connection conn = Task.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCity(String name, String president_Of_city) {
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

    public static City getByIdCity(int id) {
        String SQL = "SELECT * FROM cities WHERE id = ?";
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
                "name VARCHAR (50)," +
                "city_of_country VARCHAR(50) REFERENCES cities (name));";
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void AddCountry(String name, String city_of_country) {
        String SQL = "INSERT INTO countries (name, city_of_countries) VALUES(?,?)";
        try (Connection connection = Task.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, city_of_country);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Country> getAllCountries() {
        String SQL = "SELECT * FROM countries";
        List<Country> countries = new ArrayList<>();
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCity_of_country(resultSet.getString("city_of_country"));
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

//    public static Country getByIdCountry(int id) {
//        String SQL = "SELECT * FROM countries WHERE id = ?";
//        Country country = new Country();
//        try (Connection connection = Task.connection();
//             PreparedStatement statement = connection.prepareStatement(SQL)) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                country.setId(resultSet.getInt("id"));
//                country.setName(resultSet.getString("name"));
//                country.setCity_of_country(resultSet.getString("city_of_country"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return country;
//    }


    public static void createTable2() {
        String SQL = "CREATE TABLE IF NOT EXISTS president_of_city(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "president_of_city VARCHAR(120) REFERENCES city (name));";
        try (Connection connection = Task.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void AddPresidents(String name, String president_of_city) {
        String SQL = "INSERT INTO countries (, name, president_of_city) VALUES(?,?)";
        try (Connection connection = Task.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(2, name);
            statement.setString(3, president_of_city);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

