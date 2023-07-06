package gym.management.system.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConfig {

    private static String connUrl = "jdbc:oracle:thin:@//localhost:1521/pdborcl";
    private static String driverClass = "oracle.jdbc.driver.OracleDriver";
    private static Connection connection = null;

    {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connUrl, "hr", "hr");
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void closeStatement(Statement stmt, ResultSet result) {
        if (result != null) {
            try {
                result.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int getLastId(String tableName) {
        int lastId = 0;
        try (Connection conn = DbConfig.getConnection()) {
            PreparedStatement stmtMaxId = conn.prepareStatement("select coalesce(max(id), 0) as max_id from " + tableName);
            ResultSet rsMaxId = stmtMaxId.executeQuery();
            if (rsMaxId.next()) {
                lastId = rsMaxId.getInt("max_id");
            }
            DbConfig.closeStatement(stmtMaxId, rsMaxId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ++lastId;
    }

}
