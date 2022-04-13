package xyz.h4p3.darc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author neal.armstrong
 * @version 1.0
 * @since 2022-04-12
 */
public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String url, String name, String pwd) throws SQLException {
        return DriverManager.getConnection(url, name, pwd);
    }

    public static void execute(String sql, String url, String name, String pwd) {
        try (Connection connection = getConnection(url, name, pwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
