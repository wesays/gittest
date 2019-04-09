package Code._02登录案例;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
SQL注入演示
    select * from user where username = 'jack' and password = 'a' or
    '1' = '1';

SQL注入的解决方案
    *
    用户输入的内容不要和SQL语句进行拼接，使用PrepareStatement接口来执行增删
    改查操作。
* */
public class LoginDemo01 {
    public static void main(String[] args) throws Exception {
        //1.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //2.提示用户输入账号
        System.out.println("请输入账号：");
        //3.接收用户输入的账号
        String username = sc.nextLine();
        //4.提示用户输入密码
        System.out.println("请输入密码：");
        //5.接收用户输入的密码
        String password = sc.nextLine();

        //6.获得连接对象
        Connection conn = Code._02登录案例.JDBCUtil.getConnection();
        //7.获得发送对象
        Statement stmt = conn.createStatement();
        //8.准备SQL语句：将账号和密码拼接在一起
        String sql = "select * from user where username = '"+username+"' and password = '"+password+"';";
        System.out.println(sql);

        //9.执行查询操作并获得结果集对象
        ResultSet rs = stmt.executeQuery(sql);
        //10.根据结果及对象判断是否有数据返回，有则表示登录成功，否则登录失败
        if (rs.next()){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        Code._02登录案例.JDBCUtil.close(rs,stmt,conn);
    }
}
