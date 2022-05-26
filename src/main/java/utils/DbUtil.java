package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/products_ex?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static String DB_USER = "root";
    private static String DB_PASS = "coderslab";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    public static Connection connect(String dbName) throws SQLException {
        return DriverManager.getConnection(DB_URL.replaceAll("products_ex", dbName), DB_USER, DB_PASS);
    }
}
