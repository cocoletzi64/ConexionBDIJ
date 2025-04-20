package org.example.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static String url="jdbc:mysql://localhost:3306/veterinaria?serverTimezone=UTC";
    private static String username="root";
    private static String password="";
    private static Connection connection;


    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection= DriverManager.getConnection(url,username,password);
        }
        return connection;
    }
}

