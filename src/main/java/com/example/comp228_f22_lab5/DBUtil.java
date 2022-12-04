package com.example.comp228_f22_lab5;
import javax.xml.transform.Result;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.util.*;


public class DBUtil {
    private static Connection connection = null;
    private static Statement statement = null;

    public static void dbConnect() throws SQLException {
        //connect to database
        String dbURL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        String username = "COMP228_F22_sh_9";
        String password = "password";

        try {
            connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Database is connected!");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Database is not connected!");
            System.out.println(e.getMessage());
        }

    }

    //close database
    public static void dbDisconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database is Disconnected!");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void createTable(String tableName) throws SQLException {
        dbConnect();
        String sql = "CREATE TABLE " + tableName + "(s_id INTEGER PRIMARY KEY, s_name VARCHAR2(100))";
        try {
            statement.execute(sql);
            System.out.println("Table is created!");
        } catch (SQLException e) {
            System.out.println("Table is Not created!");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTable(String tableName) throws SQLException {
        dbConnect();
        String sql = "DROP TABLE " + tableName;
        try {
            statement.execute(sql);
            System.out.println("Table is dropped!");
        } catch (SQLException e) {
            System.out.println("Table is Not dropped!");
            System.out.println(e.getMessage());
        }
    }

    public static void insertDataGame(String tableName, int id, String name) throws SQLException {
        dbConnect();
        String sql = "INSERT INTO " + tableName + " VALUES(" + id + ",'" + name + "')";
        statement.executeUpdate(sql);
        System.out.println(id + ", " + name + " is inserted");
    }

    public static void insertDataPlayer(String tableName, int id, String first_name, String last_name, String address, String postal_code, String Province, String phone_number ) throws SQLException {
        dbConnect();
        String sql = "INSERT INTO " + tableName + " VALUES(" + id + ", '" + first_name + "', '" + last_name +  "', '" + address + "', '" + postal_code  + "', '" + Province + "', '" + phone_number + "')";
        statement.executeUpdate(sql);
        System.out.println(id + ", " + first_name + ", " +  last_name + ", " + address + ", "+ postal_code + ", " + Province + ", " + phone_number + " is inserted");
    }

    public static void insertDataPlayerGame(String tableName, int playerGameId, int gameId, int playerId, String playingDate, int score) throws SQLException {
        dbConnect();
        String sql = "INSERT INTO " + tableName + " VALUES(" + playerGameId + ", '" + gameId + "', '" + playerId +  "', '" + playingDate + "', '" + score  + "')";
        statement.executeUpdate(sql);
        System.out.println(playerGameId + ", " + gameId + ", " +  playerId + ", " + playingDate + ", "+ score + " is inserted");
    }

    public static ResultSet query(String sql) throws SQLException {
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        dbConnect();
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(sql);
        crs.populate(resultSet);
        while (resultSet.next()) {
            int player_game_id = resultSet.getInt("player_game_id");
            int game_id = resultSet.getInt("game_id");
            int player_id = resultSet.getInt("player_id");
            String playing_date = resultSet.getString("playing_date");
            int score = resultSet.getInt("score");
            System.out.println(game_id + " " + player_id + " " + player_game_id + " " + playing_date + " " + score);
        }
        if (statement != null) {
            statement.close();
        }
        dbDisconnect();
        return crs;
    }


    public static void deleteData(String tableName, int id) throws SQLException {
        dbConnect();
        String sql = "DELETE FROM " + tableName + " WHERE s_id=" + id;
        statement.execute(sql);
        System.out.println("Data is deleted!");
    }
}