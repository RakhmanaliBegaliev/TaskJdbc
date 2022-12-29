package com.peaksoft;


import java.sql.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        createTable1();
        System.out.println(getCount1());
        createTable2();
        System.out.println(getCount2());
        createTable();
        System.out.println(getCount());

        ArrayList<?> arrayList = new ArrayList<>();

//        addCity("Tokyo", 1396000);
//        addCity("NewYork", 8500000);
//        addCity("Moscow", 12000000);
//        addCity("Bishkek", 1000000);
//        addCity("Isfana", 30000);

    }

    public static void createTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS cities(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR (50), " +
                " population INT);";
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
    public static void addCity(String name, int population ) {
        String SQL = "INSERT INTO cities (name, population) VALUES (?,?)";
        try (Connection conn = Task.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setInt(2, population);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void createTable1() {
            String SQL = "CREATE TABLE IF NOT EXISTS coutries(" +
                    "id SERIAL PRIMARY KEY,"+
                    "name VARCHAR (40)," +
                    "president_of_country VARCHAR(20));";
            try(Connection connection = Task.connection();
            Statement statement = connection.createStatement()){
                statement.executeUpdate(SQL);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        public static int getCount1(){
            String SQL = "SELECT count(*) FROM countries";
            int count = 0;
            try(Connection connection = Task.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL)){
                resultSet.next();
                count = resultSet.getInt(1);
            }catch (SQLException e){
                e.printStackTrace();
            }
            return count;
        }

        public static void AddCountry (String name, String president_of_country){
        String SQL = "INSERT INTO countries (name, president_of_countries) VALUES(?,?)";
        try(Connection connection = Task.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, name);
            statement.setString(2, president_of_country);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        }
    public static void createTable2() {
        String SQL = "CREATE TABLE IF NOT EXISTS mayors(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "age INT);";
        try(Connection connection = Task.connection();
            Statement statement = connection.createStatement()){
            statement.executeUpdate(SQL);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int getCount2(){
        String SQL = "SELECT count(*) FROM mayors";
        int count = 0;
        try(Connection connection = Task.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL)){
            resultSet.next();
            count = resultSet.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }

    public static void AddMayors (String name, int age){
        String SQL = "INSERT INTO countries (name, age) VALUES(?,?)";
        try(Connection connection = Task.connection();
            PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    }

