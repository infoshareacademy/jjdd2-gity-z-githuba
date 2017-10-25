package pl.infoshareacademy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnect {
    final static String userName = "root";
    final static String password = "password";


    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "password");
        conn = DriverManager.getConnection(
                "jdbc:mysql://172.17.0.2:3306/", connectionProps);
        System.out.println("Connection estabilished!");
        return conn;
    }

    public static void writeToDatabase() {
        try {
            Connection conn = getConnection();
            Statement s1 = conn.createStatement();
            String s = "CREATE DATABASE CLASSIFIED";
            s1.executeUpdate(s);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String args[]) {
        writeToDatabase();
    }
}