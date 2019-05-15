package basic;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiao_sx
 * @date 2019/5/8
 */
public class TestJDBC {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String DATABASE = "jdbc:mysql://127.0.0.1:3306/TEST";

    @Test
    public void testJDBC() {
        List<String> databases = new ArrayList<>();
        String sql = String.format("show databases");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DATABASE, USER, PASSWORD);
            ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String database = resultSet.getString(1);
                databases.add(database);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(String database : databases) {
            System.out.println(database);
        }
    }
}
