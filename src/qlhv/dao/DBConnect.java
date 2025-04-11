
package qlhv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author VU THANH HAI
 */
public class DBConnect {
     public static Connection getConnection() {
        
        try {
            Connection cons = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            cons = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/db_qlhv?useSSL=false&serverTimezone=UTC", "root", "241104");
            return cons;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println("connect thanh cong!");
        c.close();
    }
}
