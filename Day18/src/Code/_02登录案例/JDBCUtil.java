package Code._02登录案例;

import java.sql.*;

/*
实现工具类的步骤
    1.将固定字符串定义为常量
    2.在静态代码块中注册驱动（只注册一次）
    3.提供一个获取连接的方法：static Connection getConnection();
    4.定义关闭资源的方法：close(Connection conn,Statement stmt,
        ResultSet rs);
    5.重载关闭方法：close(Connection conn,Statement stmt)
* */
public class JDBCUtil {
    //1.将固定字符串定义为常量
    private static final String DRIVER_CLASS ="coms.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql:///day18";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    //2.在静态代码块中注册驱动（只注册一次）
    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3.提供一个获取连接的方法：static Connection getConnection();
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //return null;
    }

    //4.定义关闭资源的方法：close(Connection conn,Statement stmt,
    // ResultSet rs)
    public static void close(ResultSet rs, Statement stmt,Connection conn){
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

    //5.重载关闭方法：close(Connection conn,Statement stmt)
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
}
