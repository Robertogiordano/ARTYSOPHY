package bbdd;

import java.sql.*;

class ConnectionManager {
    public static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/artysophy";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
