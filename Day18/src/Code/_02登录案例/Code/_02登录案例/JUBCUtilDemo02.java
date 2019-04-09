package Code._02登录案例;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JUBCUtilDemo02 {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        String sql = "select * from user where username = ? and password = ?;";
        Connection conn = Code._02登录案例.JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1,username);
        ps.setString(2,password);

        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        Code._02登录案例.JDBCUtil.close(rs,ps,conn);
    }
}
