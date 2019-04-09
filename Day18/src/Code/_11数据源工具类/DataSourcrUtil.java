package Code._11数据源工具类;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
数据源工具类
* */
public class DataSourcrUtil {
    private static DataSource ds = new ComboPooledDataSource();

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }

    public static void close(ResultSet rs,
                             Statement stmt,Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt , Connection conn){
        close(null,stmt,conn);
    }
}
