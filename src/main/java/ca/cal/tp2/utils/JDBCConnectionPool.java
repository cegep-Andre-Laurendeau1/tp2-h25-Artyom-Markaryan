package ca.cal.tp1.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnectionPool {
    private static final BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:sqlite:src/main/resources/database.sqlite");
        dataSource.setUsername("");
        dataSource.setPassword("");
        dataSource.setMaxTotal(10);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
