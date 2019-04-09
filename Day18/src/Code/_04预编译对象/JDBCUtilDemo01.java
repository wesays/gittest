package Code._04预编译对象;

import Code._02登录案例.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtilDemo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from student;");
        ResultSet rs = ps.executeQuery();
        List<Student> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String address = rs.getString("address");
            Student student = new Student(id, name, address);
            list.add(student);
        }
        list.forEach(System.out::println);
        JDBCUtil.close(ps,conn);
    }
}
