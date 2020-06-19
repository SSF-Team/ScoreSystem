package Features;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chuhelan.com
 */
public class DBUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static Connection con = null;
    private static Statement smt = null;
    private static ResultSet rs = null;

    public static Connection createConnection(String url) {
    	String URL = url;
        try {
            Class.forName(driver);
            return DriverManager.getConnection(URL, "SQL Info（账户）", "SQL Info（密码）");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("Can't load Driver");
        }
        return null;
    }

    public static int runUpdate(String sql,String url) throws SQLException {
        int count = 0;
        if (con == null) {
            con = createConnection(url);
        }
        if (smt == null) {
            smt = con.createStatement();
        }

        count = smt.executeUpdate(sql);

        if (smt != null) {
            smt.close();
            smt = null;
        }
        if (con != null) {
            con.close();
            con = null;
        }
        return count;
    }


    public static ResultSet runQuery(String sql,String url) throws SQLException {
        if (con == null) {
            con = createConnection(url);
        }
        if (smt == null) {
            smt = con.createStatement();
        }
        return smt.executeQuery(sql);
    }

    public static void realeaseAll() {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (smt != null) {
            try {
                smt.close();
                smt = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException ex) {
                Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static void closeConnection(Connection conn) {
        System.out.println("...");
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}