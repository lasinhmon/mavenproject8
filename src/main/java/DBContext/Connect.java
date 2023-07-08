/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lasin
 */
public class Connect {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "sql110.epizy.com";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1234";
    private static Driver driver;
    public static synchronized Connection getConnection() throws SQLException {
        java.sql.Connection connection=null;
        if (driver == null) {
            try {
                //System.out.println("Ket noi dc do");
                //private static Connection connection;
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection=(java.sql.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/charonbus?useSSL=false","root","1234");
                //System.out.println("Ket noi dc do");
                return connection;
            } catch (Exception var1) {
                System.out.println("Failure to load the JDBC driver");
                var1.printStackTrace(System.out);
            }
        }
        return null;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
    public static void close(CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
    
}
